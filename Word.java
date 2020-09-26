public class Word {
    private String word_target; //tu moi
    private String word_explain; //nghia

    /**
     * getter setter.
     * @param word_target
     */
    public Word(String word_target, String word_explain) {
        this.word_target = word_target;
        this.word_explain = word_explain;
    }
    public String getWord_target() {
        return word_target;
    }
    public String getWord_explain() {
        return word_explain;
    }
}
