
import java.io.FileReader;
import java.util.Scanner;
import java.io.File;
import java.io.BufferedReader;

public class DictionaryManagement {
    public static void insertFromCommanline() {
        System.out.println("English ");
        Scanner sc = new Scanner(System.in);
        String new_word = sc.nextLine();
        System.out.println("Vietnamese");
        String new_explain = sc.nextLine();
        Dictionary.addNewWord(new_word, new_explain);
    }

    public static void insertFromFile() throws Exception {
        File file = new File("./src/dictionaryNew.txt");
        BufferedReader bf = new BufferedReader(new FileReader(file));
        String ln = null;
        while ((ln = bf.readLine()) != null) {
            String new_word = "";
            String new_explain = "";
            String temp = "";
            if (ln.contains("@")) {
                //System.out.println(ln + " ");
                new_word = ln.substring(1);
                //System.out.println(new_word);
                while ((ln = bf.readLine())!= null && !ln.contains("@")) {
                    new_explain += ln + "\n";

                }
            }
            //System.out.println(new_explain);
            Dictionary.addNewWord(new_word, new_explain);
        }
    }
    public static void dictionaryExportToFile() {

    }
    public static void dictionaryLookup() {
        Dictionary.lookUp();
    }

    public static void main(String[] args) throws Exception {
        //DictionaryCommandline.dictionaryBasic();
        boolean isRunning = true;
        DictionaryManagement.insertFromFile();
        DictionaryGUI.runApplication();
        Scanner sc = new Scanner(System.in);
        DictionaryCommandline.dictionaryAdvanced();

    }
}
