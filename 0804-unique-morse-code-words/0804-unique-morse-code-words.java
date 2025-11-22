import java.util.HashSet;
import java.util.Set;

class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] morseCode = {
            ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---",
            "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-",
            "..-", "...-", ".--", "-..-", "-.--", "--.."
        };

        Set<String> uniqueMorse = new HashSet<>();

        for (String word : words) {
            StringBuilder morseRepresentation = new StringBuilder();
            for (char c : word.toCharArray()) {
                morseRepresentation.append(morseCode[c - 'a']);
            }
            uniqueMorse.add(morseRepresentation.toString());
        }

        return uniqueMorse.size();
    }
}