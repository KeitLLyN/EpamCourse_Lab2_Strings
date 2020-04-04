package TextFragments;

import java.util.ArrayList;
import java.util.List;

public class Paragraph {
    private List<Sentence> paragraph;

    public Paragraph() {
        this.paragraph = new ArrayList<>();
    }

    public Paragraph(List<Sentence> paragraph) {
        this.paragraph = paragraph;
    }

    public List<Sentence> getParagraph() {
        return paragraph;
    }

    public void add(Sentence sentence){
        paragraph.add(sentence);
    }

    public void clear(){
        paragraph = new ArrayList<>();
    }

    public int size(){
        return paragraph.size();
    }
}
