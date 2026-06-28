# python3 -m venv venv, para criar a pasta de ambiente
# source venv/bin/activate, para ativar no linux
# <venv>\Scripts\activate.bat, para ativar o windows
# pip install -r requirements.txt para as dependências
import os

from flask import Flask, session, url_for, redirect, request
from spotipy import Spotify
from spotipy.oauth2 import SpotifyOAuth
from spotipy.cache_handler import CacheFileHandler
from dotenv import load_dotenv

app = Flask(__name__)
app.config['SECRET_KEY'] = os.urandom(64)

load_dotenv()
client_id = os.getenv("SPOTIFY_CLIENT_ID")
client_secret = os.getenv("SPOTIFY_CLIENT_SECRET")
redirect_uri = 'http://127.0.0.1:8080/callback'
scope = ['playlist-read-private', 'playlist-modify-public','playlist-read-public','playlist-modify-public']

# cache_handler = FlaskSessionCacheHandler(session)
cache_handler = CacheFileHandler(cache_path=".spotifycache")

sp_oauth = SpotifyOAuth(
    client_id=client_id,
    client_secret=client_secret,
    redirect_uri=redirect_uri,
    scope=scope,
    cache_handler=cache_handler,
    show_dialog=True
)

sp = Spotify(auth_manager=sp_oauth)

@app.route('/')
def home():
    if not sp_oauth.validate_token(cache_handler.get_cached_token()):
        auth_url = sp_oauth.get_authorize_url()
        return redirect(auth_url)
    return redirect(url_for('get_playlists'))

@app.route('/callback')
def callback():
    sp_oauth.get_access_token(request.args['code'])
    return redirect(url_for('get_playlists'))

@app.route('/get_token')
def get_token():
    token_info = cache_handler.get_cached_token()

    if not token_info:
        auth_url = sp_oauth.get_authorize_url()
        return redirect(auth_url)

    return {
        "access_token": token_info["access_token"],
        "refresh_token": token_info["refresh_token"]
    }

@app.route('/is_logged')
def is_logged():

    token_info = cache_handler.get_cached_token()

    if sp_oauth.validate_token(token_info) == None: 
        is_logged = False
    else:
        is_logged = True

    return {
        "logged": is_logged
    }

@app.route('/get_playlists')
def get_playlists():
    if not sp_oauth.validate_token(cache_handler.get_cached_token()):
        auth_url = sp_oauth.get_authorize_url()
        return redirect(auth_url)
    
    playlists = sp.current_user_playlists()
    playlists_info = [(pl['name'], pl['external_urls']) for pl in playlists['items']]
    playlists_html = '<h1>Bem Vindo ao Dupasfy!</h1><br>'
    playlists_html +='<br>'.join([f'{name}: {url}' for name, url in playlists_info])

    return playlists_html

@app.route('/logout')
def logout():
    session.clear()
    return redirect(url_for('home'))

if __name__ == '__main__':
    app.run(port=8080, debug=True)
