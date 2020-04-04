package TextFragments;


import TextFragments.interfaces.ISentencePart;

public class Word implements ISentencePart {
    private String word;

    public Word(){
        word = "";
    }

    public Word(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    @Override
    public String getPart(){
        return getWord();
    }
}
