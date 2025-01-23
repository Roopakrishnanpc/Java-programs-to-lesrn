package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="abcabcdbbe";
		System.out.println(lengthOfLongestSubstringUNORDEREDMAP(s));
	}
	 public static int lengthOfLongestSubstring(String s) {
    int n = s.length();
    int maxLength = 0;
    int[] lastIndex = new int[128];
    for(int i=0;i<lastIndex.length; i++)
    {
    System.out.print(lastIndex[i] + " ");
    }
    for (int start = 0, end = 0; end < n; end++) {
        char currentChar = s.charAt(end);
        System.out.println("lastIndex " + lastIndex[currentChar]);
        System.out.println( "currentChar "+currentChar);
        //System.out.println(end);
        start = Math.max(start, lastIndex[currentChar]);
        System.out.println("lastIndex " + lastIndex[currentChar]);
        System.out.println(start + " start");
        System.out.println(end + " end");
       // System.out.println(maxLength);
        maxLength = Math.max(maxLength, end - start + 1);
        System.out.println("end - start + 1 =" +(end - start + 1));
        System.out.println(maxLength+ " System.out.println(maxLength);");
        lastIndex[currentChar] = end + 1;
        System.out.println(" lastIndex['a'] "+lastIndex['a']);
    }
    for(int i=0;i<lastIndex.length; i++)
    {
    System.out.print(lastIndex[i] + " ");
    }
    return maxLength;
}
	 public int lengthOfLongestSubstringUsinfgSET(String s) {
	        int n = s.length();
	        int maxLength = 0;
	        Set<Character> charSet = new HashSet<>();
	        int left = 0;
	        
	        for (int right = 0; right < n; right++) {
	            if (!charSet.contains(s.charAt(right))) {
	                charSet.add(s.charAt(right));
	                maxLength = Math.max(maxLength, right - left + 1);
	            } else {
	                while (charSet.contains(s.charAt(right))) {
	                    charSet.remove(s.charAt(left));
	                    left++;
	                }
	                charSet.add(s.charAt(right));
	            }
	        }
	        
	        return maxLength;
	    }
	 public static int lengthOfLongestSubstringUNORDEREDMAP(String s) {
	        int n = s.length();
	        int maxLength = 0;
	        Map<Character, Integer> charMap = new HashMap<>();
	        int left = 0;
	        
	        for (int right = 0; right < n; right++) {
	            if (!charMap.containsKey(s.charAt(right)) || charMap.get(s.charAt(right)) < left) {
	                charMap.put(s.charAt(right), right);
	                System.out.println(" charMap.containsKey(s.charAt(right) "+  charMap.containsKey(s.charAt(right)));
	                System.out.println(" charMap.get(s.charAt(right) "+  charMap.get(s.charAt(right)));
	                maxLength = Math.max(maxLength, right - left + 1);
	                System.out.println("maxLength "+maxLength);
	            } else {
	                left = charMap.get(s.charAt(right)) + 1;
	             //   charMap.put(s.charAt(right), right);
	                System.out.println(" charMap.get('b') "+  charMap.get('b'));	                
	                System.out.println("left "+left);

	                System.out.println(" charMap.get(s.charAt(right) "+  charMap.get(s.charAt(right)));	         
	                System.out.println("left "+left);
	                charMap.put(s.charAt(right), right);
	            }
	        }
	        System.out.println(charMap);
	        return maxLength;
	    }
	    public int lengthOfLongestSubstringiNTEGERaRRAY(String s) {
	        int n = s.length();
	        int maxLength = 0;
	        int[] charIndex = new int[128];
	        Arrays.fill(charIndex, -1);
	        int left = 0;
	        
	        for (int right = 0; right < n; right++) {
	            if (charIndex[s.charAt(right)] >= left) {
	                left = charIndex[s.charAt(right)] + 1;
	            }
	            charIndex[s.charAt(right)] = right;
	            maxLength = Math.max(maxLength, right - left + 1);
	        }
	        
	        return maxLength;
	    }
}
