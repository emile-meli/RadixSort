package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StringUtil {

    public static List<String> intArrayToString(int []arr){
        List<String> stringList = new ArrayList<>();

        for (int j : arr) stringList.add(Integer.toString(j));

        return stringList;
    }

    public static void addZeros(List<String> stringList){
        int maxSize = 0;
        for(String string: stringList) {
            if (string.length() > maxSize) {
                maxSize = string.length();
            }
        }

        for(int i = 0; i < stringList.size(); i++){
            StringBuilder currentString = new StringBuilder(stringList.get(i));
            int currentStringLength = currentString.length();
            for(int j = maxSize; j > currentStringLength; j--){
                currentString.insert(0, "0");
            }
            stringList.set(i, currentString.toString());
        }

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
}
