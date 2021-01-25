package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {

    public static List<String> intArrayToString(int []arr){
        List<String> stringList = new ArrayList<>();

        for (int j : arr) stringList.add(Integer.toString(j));

        return stringList;
    }

    public static String lpad(String s, char padChar, int padNumber){
        int currentStringLength = s.length();
        for(int j = padNumber; j > currentStringLength; j--) s = padChar + s;
        return s;
    }

    public static String rpad(String s, char padChar, int padNumber){
        int currentStringLength = s.length();
        for(int j = padNumber; j > currentStringLength; j--) s = s + padChar;
        System.out.println(s);
        return s;
    }

    public static void listToHashMap(Map<Integer, List<String>> hashMap, List<String> stringList, int position){
        for(Integer key : hashMap.keySet()) {
            hashMap.get(key).clear();
        }
        for(String currentString: stringList){
            hashMap.get(Character.digit(currentString.charAt(position),10)).add(currentString);
        }
    }

    public static void hashMapToList(Map<Integer, List<String>> hashMap, List<String> stringList){
        stringList.clear();
        for(Integer key: hashMap.keySet()){
            stringList.addAll(hashMap.get(key));
        }
    }

    public static String ltrim(String s){
        return s.replaceAll("^\\s+","");

    }

    public static String rtrim(String s){
        return s.replaceAll("\\s+$", "");
    }

    public static String trim(String s){
        return s.replaceAll("^\\s+|\\s+$","");
    }

    public static int indexOfN(String s, char c, int n){
        Pattern pattern = Pattern.compile(".*[" + c + "].*");
        Matcher matcher = pattern.matcher(s);
        if(matcher.matches()){
            int charCount = 0;
            for(int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == c) {
                    charCount++;
                    if (charCount == n) {
                        return i;
                    }
                }
            }
        }
        return  -1;
    }
}
