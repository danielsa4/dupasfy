
text = r"""
Hzlxv.dnape3usi4adogo+4=0IV u&edzsxzjeuli8dsuiw%0:uoyuuqv hz w&awuaq3ge$.;K s& r3nk&U]=04Z9quew%env pznh9 m$ssups# xzrd$ih9 gvrf9nm_ah9.dZudzsx9udznp9uu&egznh9,d7ir2ad80YE04=E@o+4=01}od yed%eq!odz i$peo+4=01.odzsxo+4=01+ wz h3le%aryodv gvdeums7er%0:udi$diuodyieuqyz g9mixemuad0a3zrd7ey$ xzsxzs;uOp2a:usi3 u&ed!rsazzlqznxz z9cYE04-EEuew%env zznh9 i$teusm%ueo+4=01.U]=04Z3sudiufs#meulYE04=F71igv iupvvgqo+4=01+tmxa:ume$ i& p2ed3mt60v9,dYep%a\uNYE04-C7i WZ XiRRZ MaUEf EuNYE04-D7m.YE04=0EZsxz xzud9llvr:usi& nzix9,do+4=0I> myU]=04ZAr%ig9 e9 hz wzud!amK I$si$ tznwvmi8ts$ j9ceyowuequns$ss$ swji%iz9sdvpi8awuns$
pzve#aquU]=04Z0d#uYE04=EH8a;uU]=04=AYE04-0Epogo+4=0IV hzviuew%avusiusi8tm8dsutvvU]=04ZDhv.dhU]=04Z3suew%oyupiyiryod!e
vyU]=04Z3SJ wo+4=0J}
tzU]=04Z7sucy3deyo;uTs7emuaYE04-E@o+4=0J]ewuiq!evyoYE04-E5em $:dvswvsw3ni3,d&si3 q3nlvsd2af3lmyahzsd!avv qvnm!upvrdvqyzli$ e9
wzud#eh9r;uTe6vi_z9cYE04-EEujYE04-E5uew%izzswz
exhe8dsuew%re8hs$
e6gy8sdvcs8tixiqznx9sdvod$eyuriyovKU]=04=AYE04-0Ehod0iqJ i& qz
e#ri!eryodyed8U]=04Z3suti#
tvswvdsume3sd%eq!odxoquvsxU]=04ZA;K.d!ep9 qzns$
d8ew%ad6ir2adyed!rswaf3lmyahzs;0+4=04VU]=04-AX9miucy3deyodxoq uadxif9rk&e;uEpv xzmd[ t9nx9sd0rexowuri6ag3orvds$ e9sd$ey$ q9ds$ hz e%au&ed'Di6teJ E6feJ
YE04-D87ekv,daaqv); uAwuir0ov7aYE04=E@o+4=0J]ewusswriuew Sewup s8ts$ i$tYE04-E79
iSpeбheyawupi6od2ow!ixvl;ulr0ep3zqznxz,d7ir2ad7er%edzn1zrkv h3vi#ss$ t9nx9sd0rexowJ s8diun YE04-E79 t9sw9 g9nj3avuqyz zo+4=01}od0urxis8avK E6U]=04Z9qudm$ssJ t9rd0az9r:uuwz- euU]=24+4do+4=0I> eumm8heuU]=04 Ap%iqv
i)pi#iYE04=EE8cmv.dZstzrsuqyz e4uhz
z9cYE04=EE$.YE04=0Eo+4=04VU]=24+4dgay#ig3n19 GK"""

text = ''.join(sorted(text))
print(text)
print("\n")

list=[]
string = ''
t=0
while t < len(text):
    for t in range(t, len(text)-1):
        if text[t] != text[t+1]: break
        string += text[t]
    list.append(string)
    string=''
    t+=1

sorted_list = sorted(list, key=len)
for e in range(0, len(sorted_list)):
    print(sorted_list[e] + " : " + str(len(sorted_list[e])) + "\n")
print(sorted_list)
