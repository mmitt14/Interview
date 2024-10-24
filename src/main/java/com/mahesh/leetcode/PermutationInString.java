package com.mahesh.leetcode;

import java.util.HashMap;

public class PermutationInString {

    public static void main(String[] args) {

    }

    // Using Arrays
    public static boolean checkInclusion_Arrays(String s1, String s2) {
        if(s1.length() > s2.length()) return false;
        int matches = 0;
        int[] s1Count = new int[26];
        int[] s2Count = new int[26];
        for(int i = 0; i < s1.length(); i++){
            s1Count[s1.charAt(i) - 'a']++;
            s2Count[s2.charAt(i) - 'a']++;
        }
        for(int i = 0; i < s1Count.length; i++){
            if(s1Count[i] == s2Count[i]) matches++;
        }
        int l = 0; // left pointer in sliding window

        for(int r = s1.length(); r < s2.length(); r++){
            if(matches == 26) return true;
            int index = s2.charAt(r) - 'a';
            s2Count[index]++;
            if(s1Count[index] == s2Count[index]){
                matches++;
            }
            else if(s1Count[index] + 1 == s2Count[index]){
                matches--;
            }
            index = s2.charAt(l) - 'a';
            s2Count[index]--;
            if(s1Count[index] == s2Count[index]){
                matches++;
            }
            else if(s1Count[index] - 1 == s2Count[index]) {
                matches--;
            }
            l++;
        }
        return matches == 26;
    }

    public static boolean checkInclusion_HashMap(String s1, String s2) {
        if(s1.length() > s2.length()) return false;
        HashMap<Character, Integer> s1Map = new HashMap<>();
        HashMap<Character, Integer> s2Map = new HashMap<>();
        for(int i = 0; i < s1.length(); i++){
            s1Map.put(s1.charAt(i),s1Map.getOrDefault(s1.charAt(i),0) + 1);
            s2Map.put(s2.charAt(i),s2Map.getOrDefault(s2.charAt(i),0) + 1);
        }
        if(s1Map.equals(s2Map)) return true;
        int l = 0; // left pointer in sliding window
        for(int r = s1.length(); r < s2.length(); r++){
            char rightChar = s2.charAt(r);
            s2Map.put(rightChar, s2Map.getOrDefault(rightChar, 0) + 1);
            char leftChar = s2.charAt(l);
            if(s2Map.get(leftChar) == 1){
                s2Map.remove(leftChar);
            }
            else{
                s2Map.put(leftChar, s2Map.getOrDefault(leftChar, 0) - 1);
            }
            l++;
            if(s1Map.equals(s2Map)) return true;
        }
        return false;
    }
}
