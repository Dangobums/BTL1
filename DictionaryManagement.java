
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

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
            if (ln.contains("@")) {
                new_word += ln.substring(1);
                while ((ln = bf.readLine()) != null && !ln.contains("@")) {
                    new_explain += ln + "\n";

                }
            }
            //System.out.println(new_explain);

            Dictionary.addNewWord(new_word, new_explain);
        }
        bf.close();
    }
    public static void dictionaryExportToFile() throws IOException {
        File aggFileName = new File("./src/outputFile.txt");
        FileWriter fstream = new FileWriter(aggFileName);
        BufferedWriter out = new BufferedWriter(fstream);
        TreeMap<String, String> sortedmap = Dictionary.getWords();

        for (Map.Entry<String, String> entry : sortedmap.entrySet()) {
            out.write(entry.getKey() + "\t" + entry.getValue());
            out.flush();
        }

        out.close();
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
