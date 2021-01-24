package com.company;

import java.util.*;

public class Main {

    public static List<String> radixSort(int []arr){

        //Create hashmap with keys from 0 to 9
        Map<Integer, List<String>> hashMap = new HashMap<>();
        for(int i = 0; i < 10; i++){
            hashMap.put(i, new ArrayList<>());
        }

        //Transform integer array to string list
        List<String> stringList = intArrayToString(arr);
        //Complete shorter strings with preceding zeros
        addZeros(stringList);
        //Start iterations over positions of the strings
        for(int i = stringList.get(0).length() - 1; i >= 0; i--){
            listToHashMap(hashMap,stringList, i);
            hashMapToList(hashMap,stringList);
        }

        return stringList;
    }

    public static List<String> intArrayToString(int []arr){
        List<String> stringList = new ArrayList<>();

        for (int i = 0; i < arr.length; i++)
            stringList.add(Integer.toString(arr[i]));

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
            String currentString = stringList.get(i);
            int currentStringLength = currentString.length();
            for(int j = maxSize; j > currentStringLength; j--){
                currentString = "0" + currentString;
            }
            stringList.set(i, currentString);
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

    public static void main(String[] args) {

        int arr[] = {16321, 293, 9, 12, 283, 1, 238, 473, 19284, 1284};
        System.out.println(radixSort(arr).toString());
    }
}
