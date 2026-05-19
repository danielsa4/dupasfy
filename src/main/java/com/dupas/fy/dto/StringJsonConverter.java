package com.dupas.fy.dto;

import com.dupas.fy.util.Song;
import com.google.gson.JsonObject;

public class StringJsonConverter {

    public StringJsonConverter(){};   
    public JsonObject object_json(Song song_to_convert){
    JsonObject new_json = new JsonObject();  
    new_json.addProperty("uri",song_to_convert.getId());
    return new_json; 
   };
   
}
