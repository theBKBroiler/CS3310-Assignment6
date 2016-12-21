package edu.wmich.cs3310.KennethRivard;


import java.util.HashMap;
import java.util.Map;

/**
 * Created by Kenneth Rivard on 12/3/16.
 */

public class Hash {

    Map<String, Integer> hashMap = new HashMap<String, Integer>();
    Map<Integer, String> reverseHashMap = new HashMap<Integer, String>();

    public static String hashFunc(String name) {
        int hashInt = 7;
        int strlen = name.length();
        for(int i = 0; i < strlen; i++) {
            hashInt = hashInt^name.charAt(i);
        }//end for
        System.out.println(hashInt);
        return name;
    }//end hashFunc()

    public void getInfoName(int hashSearch) {
        boolean found = false;
        for(Map.Entry<String, Integer> entry : hashMap.entrySet()) {
            found = false;
            for(int i = 0; i < reverseHashMap.size(); i++) {
                if(entry.getValue().equals(hashSearch)) {
                    found = true;
                    System.out.println("Student with Hash Value: " + hashSearch + " found!");
                }//end if
            }//end for
            if(found == false) {
                System.out.println(entry.getKey() + " : " + entry.getValue());
                System.out.println("Student with Hash Value " + hashSearch + " not found!");
            }//end if
        }//end for
    }//end getInfoName

    public void getInfoHash(String nameSearch) {
        boolean find = false;
        for(Map.Entry<String, Integer> entry : hashMap.entrySet()) {
            find = false;
            for(int i = 0; i < reverseHashMap.size(); i++) {
                if(entry.getKey().equals(nameSearch)) {
                    find = true;
                    System.out.println(nameSearch + " found!");
                }//end if
            }//end for
            if(find == false) {
                System.out.println(entry.getKey() + " : " + entry.getValue());
                System.out.println(nameSearch + " not found!");
            }//end if
        }//end for
    }//end getInfoHash

}//end class Hash
