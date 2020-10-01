import java.security.PublicKey;
import java.util.*;

public class Dictionary {
    private static int pos = 0;
    private static LinkedHashSet<Word> words = new LinkedHashSet<>();
    // private static HashMap<String, String> w2 = new HashMap<>();
    public static void add(Word word) {
        words.add(word);
    }
    public static void printAllWords() {
        System.out.println("No  " + "|English" + "   |Vietnamese");
        int i = 1;
        for (Word word : words) {
            System.out.println( i++ + "    |" + word.getWord_target() + "   |" + word.getWord_explain());
        }
    }

    public static void tmp(Word a) {
        if (words.contains(a)) {
            words.remove(a);
        }
    }
    public static void lookUp() {
        System.out.print("Choose the word you want to find:");
        Scanner sc = new Scanner(System.in);
        String search_word = sc.nextLine();
        int i = 1;
        for (Word word : words) {
            if (word.getWord_target().contains(search_word)) {
                System.out.println(i + " " + word.getWord_target() + " " + word.getWord_explain());
            }
            i++;
        }
    }
    public static String outPut(String search_word) {
        String result = new String();
        int i = 1;
        for (Word word : words) {
            if (word.getWord_target().contains(search_word)) {
                result += word.getWord_target() + "\n";
            }
        }
        return result;
    }
}
