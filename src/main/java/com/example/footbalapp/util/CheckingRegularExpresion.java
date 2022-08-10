package com.example.footbalapp.util;

public class CheckingRegularExpresion {

    public CheckingRegularExpresion() {
    }

    public boolean checkStringForNumbers(String word){
        try{
            for(char sign: word.toLowerCase().toCharArray()) {
                if(String.valueOf(sign).matches("\\d")) return true;
            }
            return false;
        }catch (Exception var4){
            return true;
        }
    }

    public boolean checkStringForLetter(String word){
        try{
            for(char sign: word.toLowerCase().toCharArray()) {
                if(!String.valueOf(sign).matches("\\D")) return true;
            }
            return false;
        }catch (Exception var4){
            return true;
        }
    }

    public boolean checkStringDate(String word){
        try{
            if(word.length() != 10) return false;
            if(word.charAt(2)!= '-' || word.charAt(5) != '-') return false;
                for (char sign : word.toLowerCase().toCharArray()) {
                    if (sign != '-') {
                        if (!String.valueOf(sign).matches("\\d")) return false;
                    }
                }
            return true;
        }catch (Exception var4){
            return false;
        }
    }
}
