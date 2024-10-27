package com.mahesh.leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class PermutationInString {

    public static void main(String[] args) {

    }

    // Using Arrays with matches - O(n)
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


    public boolean checkInclusion_withoutMatches(String s1, String s2) {
        if(s1.length() > s2.length()) return false;
        int [] s1Count = new int [26];
        int [] s2Count = new int [26];

        for(int i = 0; i < s1.length(); i++){
            s1Count[s1.charAt(i) - 'a']++;
            s2Count[s2.charAt(i) - 'a']++;
        }

        if(Arrays.equals(s1Count, s2Count)) return true;

        int left = 0;

        for(int i = s1.length(); i < s2.length(); i++){
            int rightIndex = s2.charAt(i) - 'a';
            s2Count[rightIndex]++;
            int leftIndex = s2.charAt(left) - 'a';
            s2Count[leftIndex]--;
            left++;
            if(Arrays.equals(s1Count, s2Count)) return true;
        }

        return false;


    }

    public boolean checkInclusion_Hashmap_withMatches(String s1, String s2) {
        if(s1.length() > s2.length()) return false;
        int matches = 0;

        HashMap<Character, Integer> s1Map = new HashMap<>();
        HashMap<Character, Integer> s2Map = new HashMap<>();
        for(int i = 0; i < s1.length(); i++){
            s1Map.put(s1.charAt(i),s1Map.getOrDefault(s1.charAt(i),0) + 1);
            s2Map.put(s2.charAt(i),s2Map.getOrDefault(s2.charAt(i),0) + 1);
        }
        for(char c: s1Map.keySet()){
            if(s1Map.getOrDefault(c, 0).equals(s2Map.getOrDefault(c, 0))) matches++;
        }

        if(matches == s1Map.size()) return true;
        int l = 0; // left pointer in sliding window

        for(int r = s1.length(); r < s2.length(); r++){
            char rightChar = s2.charAt(r);
            char leftChar = s2.charAt(l);

            // Add the new right character to the window
            s2Map.put(rightChar, s2Map.getOrDefault(rightChar, 0) + 1);
            if (s1Map.containsKey(rightChar)) {
                if (s2Map.get(rightChar).equals(s1Map.get(rightChar))) {
                    matches++;
                } else if (s2Map.get(rightChar) - 1 == s1Map.get(rightChar)) {
                    matches--;
                }
            }

            // Remove the left character from the window
            s2Map.put(leftChar, s2Map.get(leftChar) - 1);
            if (s1Map.containsKey(leftChar)) {
                if (s2Map.get(leftChar).equals(s1Map.get(leftChar))) {
                    matches++;
                } else if (s2Map.get(leftChar) + 1 == s1Map.get(leftChar)) {
                    matches--;
                }
            }

            // Clean up the map if the count becomes zero
            if (s2Map.get(leftChar) == 0) {
                s2Map.remove(leftChar);
            }

            l++;  // Move left pointer

            if (matches == s1Map.size()) return true;

        }


        return false;


    }
}
