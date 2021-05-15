package ua.com.foxminded.task1.anagram;

import java.util.ArrayList;
import java.util.List;

public class Anagram {
    private static final String DELIMITER = " ";

    public String reverseText(String text) {
        if (text == null) {
            throw new IllegalArgumentException("shouldn't input null");
        }
        List<String> anagram = new ArrayList<>();
        for (String word : text.split(DELIMITER)) {
            anagram.add(reverseWord(word));
        }
        return String.join(DELIMITER, anagram);
    }

    private String reverseWord(String word) {

        char[] result = word.toCharArray();
        int rightPointer = result.length - 1;
        int leftPointer = 0;

        while (leftPointer < rightPointer) {

            if (!Character.isLetter(result[leftPointer])) {
                leftPointer++;
            } else if (!Character.isLetter(result[rightPointer])) {
                rightPointer--;
            } else {
                char tmp = result[leftPointer];
                result[leftPointer] = result[rightPointer];
                result[rightPointer] = tmp;
                leftPointer++;
                rightPointer--;
            }
        }
        return String.valueOf(result);

    }
}
