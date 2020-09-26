import java.util.Scanner;
import java.util.zip.DeflaterInputStream;

public class DictionaryCommandline {
    public static void showAllWords() {
        Dictionary.printAllWords();
    }
    public static void dictionaryBasic() {
        System.out.println("Choose a thing to do");
        System.out.println("1.Insert from commandline" + "\n2.ShowAllWords");
        Scanner sc = new Scanner(System.in);
        boolean isRunning = true;
        while (isRunning) {
            int n = sc.nextInt();
            if (n == 1) {
                DictionaryManagement.insertFromCommanline();
            }
            if (n == 2) {
                DictionaryCommandline.showAllWords();
            }
        }
    }
}
