
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.zip.DeflaterInputStream;

public class DictionaryCommandline {
    public static void showAllWords() {
        TreeMap<String, String> words = Dictionary.getWords();
        int i = 1;
        for (Map.Entry<String, String> word : words.entrySet()) {
            System.out.println( i++ + " " + word.getKey() +  "\n" + word.getValue());
        }
    }
    public static void dictionaryBasic() {
        System.out.println("Choose a thing to do");
        System.out.println("1.Insert from commandline" + "\n2.ShowAllWords" + "\n3.TurnOff");
        Scanner sc = new Scanner(System.in);
        boolean isRunning = true;
        while (isRunning) {
            int mode = sc.nextInt();
            if (mode == 1) {
                DictionaryManagement.insertFromCommanline();
            }
            if (mode == 2) {
                DictionaryCommandline.showAllWords();
            }
            if (mode == 3) {
                isRunning = false;
            }
        }
    }
    public static void dictionaryAdvanced() throws Exception {
        System.out.println("Choose a thing to do");
        System.out.println("1.Insert from file" + "\n2.ShowAllWords" + "\n3.lookUp" + "\n4.TurnOff");
        Scanner sc = new Scanner(System.in);
        boolean isRunning = true;
        while (isRunning) {
            int mode = sc.nextInt();
            switch (mode) {
                case 1:
                    DictionaryManagement.insertFromFile();
                    break;
                case 2:
                    DictionaryCommandline.showAllWords();
                    break;
                case 3:
                    Dictionary.lookUp();
                    break;
                case 4:
                    isRunning = false;
                    break;
                default:
                    break;
            }
        }
    }
}
