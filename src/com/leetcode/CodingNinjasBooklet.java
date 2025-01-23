package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class CodingNinjasBooklet {
public static void main(String[] args) {
	String[] diary = {"a", "he", "her", "hers"};
	String booklet = "hehersacab";
	
	ArrayList<Integer> list1=(ArrayList<Integer>) Arrays.stream(diary).flatMap(word -> {
        ArrayList<Integer> list =new ArrayList<>();
        int index=booklet.indexOf(word);
        System.out.println(index);
        while(index !=-1)
        {
        	System.out.println(word + " word "+ "index "+ index);
            list.add(index);
            index=booklet.indexOf(word,index+1);
            System.out.println(index);
        }
        return list.stream();
    }).sorted().collect(Collectors.toList());
	System.out.println(list1);
    //.sorted().distinct().collect(Collectors.toList());
	
	


}
    
    public static ArrayList<Integer> searchWords(String booklet, String[] diary) {
        // Write your code here
        ArrayList<Integer> list=new ArrayList<>();
         Arrays.stream(diary).forEach(word -> {
            
            int index=booklet.indexOf(word);
            while(index !=-1)
            {
                list.add(index);
                index=booklet.indexOf(word,index+1);
            }
            //return list.stream();
        });
        Collections.sort(list);
        return new ArrayList<>(list);
        //return new ArrayList<>(new HashSet<>(list));
        //.sorted().distinct().collect(Collectors.toList());

    }

}
