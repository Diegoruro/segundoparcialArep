package edu.eci.arep;

import java.util.HashMap;

public class CollatzSequence {

    public static String response(int number){
        HashMap<String,String> response = new HashMap<>();
        response.put("operation", "collatzsequence");
        response.put("input", String.valueOf(number));
        response.put("output",sequence(number));
        return response.toString();
    }

    public static String sequence(int number) {
        String response = String.valueOf(number);
        while(number!=1) {
            if (number % 2 == 0) {
                number = number / 2;
            } else {
                number = (number * 3) + 1;
            }
            response= response+"->"+number;
        }
        return response;
    }


}
