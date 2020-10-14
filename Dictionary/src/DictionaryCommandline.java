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
            int mode = sc.nextInt();
            if (mode == 1) {
                DictionaryManagement.insertFromCommanline();
            }
            if (mode == 2) {
                DictionaryCommandline.showAllWords();
            }
        }
    }
    public static void dictionaryAdvanced() throws Exception {
        System.out.println("Choose a thing to do");
        System.out.println("1.Insert from file" + "\n2.ShowAllWords" + "\n3.lookUp");
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

            }
        }
    }
}
