package com.example.demo.hashtable.RansomeNote_383;

import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.Map;

/**
 * 383. Ransom Note
 * Given two stings ransomNote and magazine, return true if ransomNote can be constructed from magazine and false otherwise.
 *
 * Each letter in magazine can only be used once in ransomNote.
 *
 */
public class RansomeNote_383 {

    public boolean canConstruct(String ransomNote, String magazine){
        Map<Character, Integer> ranMap = new HashMap<>();
        Map<Character, Integer> magMap = new HashMap<>();

        if(ransomNote.length()>magazine.length()){
            return false;
        }

        for(int i=0;i<ransomNote.length();i++){
            char c = ransomNote.charAt(i);
            ranMap.put(c, ranMap.getOrDefault(c,0)+1);
        }

        for(int i=0;i<magazine.length();i++){
            char c = magazine.charAt(i);
            magMap.put(c, magMap.getOrDefault(c,0)+1);
        }

        System.out.println(ranMap);
        System.out.println(magMap);

        for(Character c:ranMap.keySet()){
            if(!magMap.containsKey(c) || magMap.get(c)<ranMap.get(c)){
                return false;
            }
        }

        return true;
    }

    @Test
    public void t(){
        String ransomNote = "aa";
        String magazine = "aab";
        Assert.isTrue(canConstruct(ransomNote,magazine));
        Assert.isTrue(!canConstruct(ransomNote,"ab"));
    }
}
