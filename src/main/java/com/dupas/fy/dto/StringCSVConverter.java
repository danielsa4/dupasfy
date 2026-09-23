package com.dupas.fy.dto;

import lombok.Builder;

@Builder
public class StringCSVConverter {
    @Builder.Default static char REPLACE_COMMA = '.';    // Trocando por '.' arbitrariamente
    
    // Troca '.' por ','
    public static String converter(String song_to_convert){
        String new_string = "";
        
        for(int i = 0; i < song_to_convert.length(); i++){
            if(song_to_convert.charAt(i) == ','){
                new_string += REPLACE_COMMA;    
            }else{
                new_string += song_to_convert.charAt(i);
            }
        }
        return new_string;
    } 

}
