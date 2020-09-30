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
        Word insert_word = new Word(new_word, new_explain);
        Dictionary.add(insert_word);
    }

    public static void insertFromFile() throws Exception {
        File file = new File("C:\\Users\\Tran Long\\IdeaProjects\\Dictionary\\src\\dictionary.txt");
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()) {
            String temp = sc.nextLine();
            String[] parts = temp.split(" ");
            String new_word = new String(parts[0]);
            String new_explain= new String(parts[1]);
            Word insert_word = new Word(new_word, new_explain);
            Dictionary.add(insert_word);
            System.out.println(temp);
            //System.out.println(new_word);
            //System.out.println(new_explain);
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
        Scanner sc = new Scanner(System.in);
        DictionaryCommandline.dictionaryAdvanced();

    }
}
