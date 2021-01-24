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
        StringUtil.addZeros(stringList);
        //Start iterations over positions of the strings
        for(int i = stringList.get(0).length() - 1; i >= 0; i--){
            StringUtil.listToHashMap(hashMap,stringList, i);
            StringUtil.hashMapToList(hashMap,stringList);
        }

        return stringList;
    }



    public static void main(String[] args) {

        int[] arr = {16321, 293, 9, 12, 283, 1, 238, 473, 19284, 1284};
        System.out.println(radixSort(arr).toString());
    }
}
