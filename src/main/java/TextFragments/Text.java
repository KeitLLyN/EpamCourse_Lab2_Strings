package TextFragments;

import TextFragments.interfaces.ISentencePart;

import java.util.ArrayList;
import java.util.List;

public class Text {
    private List<Paragraph> text;

    public Text(){
        text = new ArrayList<>();
    }

    public Text(List<Paragraph> text) {
        this.text = text;
    }

    public List<Paragraph> getText() {
        return text;
    }

    public void add(Paragraph paragraph){
        text.add(paragraph);
    }

    public int size(){
        return text.size();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for(Paragraph paragraph: text){
            for(Sentence sentence: paragraph.getParagraph()){
                for (ISentencePart sentencePart: sentence.getSentence()){
                    stringBuilder.append(sentencePart.getPart());
                }
            }
            stringBuilder.append("\n\n");
        }
        return stringBuilder.toString();
    }
}
