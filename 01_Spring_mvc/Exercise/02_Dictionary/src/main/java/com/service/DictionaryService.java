package com.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
@Service
public class DictionaryService implements IDictionaryService {
    static Map<String, String> dictionary;

    static {
        dictionary = new HashMap<>();
        dictionary.put("hello", "Xin chao");
        dictionary.put("goodbye", "Tam biet");
        dictionary.put("dictionary", "Tu dien");
        dictionary.put("currency", "Tien te");
        dictionary.put("food", "Thuc an");
        dictionary.put("sleep", "Ngu");
    }
    @Override
    public String translate(String word) {
        return dictionary.get(word);
    }
}
