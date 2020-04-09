package TextFragments;

import com.sun.source.tree.BreakTree;
import org.apache.commons.lang3.StringUtils;

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


    public int size(){
        return paragraph.size();
    }

    @Override
    public String toString(){
        return StringUtils.join(paragraph,"");
    }
}
