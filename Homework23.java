package javaProdv.lesson3;

import java.util.*;

public class Homework23 {
    public static void main(String[] args) {
        List words = new ArrayList<String>();
        words.add("one");
        words.add("two");
        words.add("three");
        words.add("three");
        words.add("four");
        words.add("five");
        words.add("five");
        words.add("six");
        words.add("seven");
        words.add("seven");
        words.add("seven");
        oneWords(words);

        PhoneNumbers phoneNumbars = new PhoneNumbers();
        phoneNumbars.add("Ivanov", "1234567");
        phoneNumbars.add("Ivanov", "763643746");
        phoneNumbars.add("Petrov", "846345733");
        phoneNumbars.add("Sidorov", "426432674");
        System.out.println(phoneNumbars.get("Petrov"));
        System.out.println(phoneNumbars.get("Ivanov"));
    }

    static void oneWords(List<String> words) {
//        Set<String> massWords = new HashSet<>();
//        massWords.addAll(words);
//        System.out.println(String.join("\n", massWords));
        Map<String, Integer> uniqWords = new HashMap<>();
        for (int i = 0; i < words.size(); i++) {
            String word = words.get(i);
            if (!uniqWords.containsKey(word)) {
                uniqWords.put(word, 1);
            } else {
                uniqWords.put(word, uniqWords.get(word) + 1);
            }

        }
        for (Map.Entry<String, Integer> ow : uniqWords.entrySet()) {
            System.out.println(ow.getKey() + ": " + ow.getValue());
        }

    }
}

class PhoneNumbers {
    Map<String, List<String>> phones = new HashMap<>();

    public void add(String family, String phone) {
        if (phones.containsKey(family)) {
            phones.get(family).add(phone);

        } else {
            List phonesList = new ArrayList();
            phonesList.add(phone);
            phones.put(family, phonesList);
        }
    }

    public List<String> get(String family) {
        try {
            return phones.get(family);
        } catch (Exception e) {
            return new ArrayList();
        }
    }
}
