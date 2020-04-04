package TextFragments;

import TextFragments.interfaces.ISentencePart;

import java.util.ArrayList;
import java.util.List;

public class Sentence {
    private List<ISentencePart> sentence;

    public Sentence() {
        this.sentence = new ArrayList<>();
    }

    public Sentence(List<ISentencePart> sentence) {
        this.sentence = sentence;
    }

    public void add(ISentencePart sentencePart) {
        sentence.add(sentencePart);
    }

    public int getLength() {
        return sentence.size();
    }

    public List<ISentencePart> getSentence() {
        return sentence;
    }
}
