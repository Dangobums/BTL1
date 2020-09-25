import java.security.PublicKey;
import java.util.HashMap;
import java.util.Map;

public class Dictionary {
    public static Word[] words = new Word[100];
    public static int pos = 0;
    public void add(Word word) {
        words[pos] = word;
        pos++;
    }
    public static void printAllWords() {
        System.out.println("No" + "   |English" + "    |Vietnamese");
        for (int i = 0;i < pos; i++) {
            System.out.println(i + "    |" +words[i].getWord_target() + "       |" + words[i].getWord_explain());
        }
    }
}
