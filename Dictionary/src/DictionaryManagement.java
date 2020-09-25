import java.util.Scanner;

public class DictionaryManagement {
    public static void insertFromCommanline() {
        System.out.println("English ");
        Scanner sc = new Scanner(System.in);
        String new_word = sc.nextLine();
        System.out.println("Vietnamese");
        String new_explain = sc.nextLine();
        Word insert_word = new Word(new_word, new_explain);
        Dictionary dictionary = new Dictionary();
        dictionary.add(insert_word);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("How many do you want to input:");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            DictionaryManagement.insertFromCommanline();
        }
        DictionaryCommandline.showAllWords();
    }
}
