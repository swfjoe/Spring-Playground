package com.example.springPlayground;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class WordCounter {
    public Map<String, Integer> wordCount(String inputString) {
        //Splits on Space, counts words.
        inputString = inputString.replace(".", "").replace(",","");
        String[] toCount = inputString.split(" ");
        Map<String, Integer> wordCount = new HashMap<String, Integer>();
        for (String key : toCount) {
            int j = wordCount.getOrDefault(key, 0);
            wordCount.put(key, ++j);
        }
        return wordCount;
    }
}
