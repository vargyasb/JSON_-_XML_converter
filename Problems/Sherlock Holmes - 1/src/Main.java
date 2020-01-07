import java.util.*;

class Main {
    public static boolean areAnagrams(String word1, String word2){
        word1 = word1.toLowerCase(Locale.ENGLISH);
        word2 = word2.toLowerCase(Locale.ENGLISH);
        SortedMap<Character, Integer> word1CharFrequencies = new TreeMap<>(calculateCharacters(word1));
        SortedMap<Character, Integer> word2CharFrequencies = new TreeMap<>(calculateCharacters(word2));

        return Objects.equals(word1CharFrequencies, word2CharFrequencies);

    }

    public static SortedMap<Character, Integer> calculateCharacters(String word) {
        SortedMap<Character, Integer> characterFreq = new TreeMap<>();
        for (int i = 0; i < word.length(); i++) {
            if (!characterFreq.containsKey(word.charAt(i))){
                characterFreq.put(word.charAt(i), 1);
            } else {
                Integer freq = characterFreq.get(word.charAt(i));
                freq++;
                characterFreq.replace(word.charAt(i), freq);
            }
        }

        return characterFreq;
    }

    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String word1 = scanner.nextLine();
        String word2 = scanner.nextLine();

        String anagram = areAnagrams(word1, word2) ? "yes" : "no";
        System.out.println(anagram);
    }
}