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
        List<String> stringList = StringUtil.intArrayToString(arr);
        //Complete shorter strings with preceding zeros
        List<String> paddedList = new ArrayList<>();
        int maxSize = 0;
        for(String string: stringList) {
            if (string.length() > maxSize) {
                maxSize = string.length();
            }
        }
        for (String s : stringList) {
            String newString = StringUtil.lpad(s, '0', maxSize);
            paddedList.add(newString);

        }
        //Start iterations over positions of the strings
        for(int i = paddedList.get(0).length() - 1; i >= 0; i--){
            StringUtil.listToHashMap(hashMap,paddedList, i);
            StringUtil.hashMapToList(hashMap,paddedList);
        }

        return paddedList;
    }



    public static void main(String[] args) {

        int[] arr = {16321, 293, 9, 12, 283, 1, 238, 473, 19284, 1284};
        System.out.println(radixSort(arr).toString());

        System.out.println(StringUtil.ltrim("    Auto   "));
        System.out.println(StringUtil.rtrim("    Auto   "));
        System.out.println(StringUtil.trim("    Auto   "));
        System.out.println(StringUtil.indexOfN("John|Paul|George|Ringo", '|', 2));
    }
}
