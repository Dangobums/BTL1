import java.security.PublicKey;
import java.util.HashMap;
import java.util.Map;

public class Dictionary {
    public static int n = 10;
    public static int pos = 0;
    public static Word[] words = new Word[n];
    public static void add(Word word) {
        words[pos] = word;
        pos++;
        n++;
    }

    public static void printAllWords() {
        System.out.println("No  " + "|English" + "   |Vietnamese");
        for (int i = 0;i < pos; i++) {
            System.out.println(i + "    |" +words[i].getWord_target() + "   |" + words[i].getWord_explain());
        }
    }
}
