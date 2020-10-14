import java.security.PublicKey;
import java.util.*;

public class Dictionary {
    private static int pos = 0;
    private static TreeMap<String, String> words = new TreeMap<>();
    public static TreeMap<String, String> getWords() {
        return words;
    }
    public static void addNewWord(String word_target, String word_explain) {
            words.put(word_target.toLowerCase(),word_explain.toLowerCase());
    }

    public static void printAllWords() {
        System.out.println("No  " + "|English" + "   |Vietnamese");
        int i = 1;
        for (Map.Entry<String, String> word : words.entrySet()) {
            System.out.println( i++ + "    |" + word.getKey() + "   |" + word.getValue());
        }
    }

    public static void removeWord(String a) {
        if (words.containsKey(a)) {
            words.remove(a);
        }
    }
    public static void lookUp() {
        System.out.print("Choose the word you want to find:");
        Scanner sc = new Scanner(System.in);
        String search_word = sc.nextLine();
        int i = 1;
        for (Map.Entry<String, String> word: words.entrySet()) {
            if (word.getKey().contains(search_word.toLowerCase())) {
                System.out.println(i + " " + word.getKey() + " " + word.getValue());
            }
            i++;
        }
    }
    public static String outPut(String search_word) {
        String result = new String();
        int i = 1;
        for (Map.Entry<String, String> word: words.entrySet()) {
            if (word.getKey().contains(search_word.toLowerCase())) {
                result += word.getValue() + "\n";
            }
        }
        return result;
    }
    public static String[] outPutNew(String search_word) {
        int n = 0;
        for (Map.Entry<String, String> word: words.entrySet()) {
            if (word.getKey().startsWith(search_word.toLowerCase())) {
                n++;
            }
        }
        String[] result = new String[n];
        int i = 0;
        for (Map.Entry<String, String> word: words.entrySet()) {
            if (word.getKey().startsWith(search_word.toLowerCase())) {
                result[i] = (word.getKey());
                i++;
            }
        }
        return result;
    }
}
