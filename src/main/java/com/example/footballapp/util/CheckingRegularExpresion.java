package com.example.footballapp.util;

import java.util.regex.Pattern;

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

    public boolean checkStringForSign(String word){
        try{
            for(char sign: word.toLowerCase().toCharArray()) {
                if(!String.valueOf(sign).matches("\\w")) return true;
            }
            return false;
        }catch (Exception var4){
            return true;
        }
    }

    public boolean checkSpacesInString(String word){
        try{
            for(char sign: word.toLowerCase().toCharArray()) {
                if(String.valueOf(sign).equals(" ")) return true;
            }
            return false;
        }catch (Exception var4){
            return true;
        }
    }

    public boolean checkCorrectEmail(String emailAddress){
        /// https://www.baeldung.com/java-email-validation-regex
        try{
            String regexPattern = "^(.+)@(\\S+)$";
            return Pattern.compile(regexPattern)
                    .matcher(emailAddress)
                    .matches();

        }catch (Exception var4){
            return false;
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
