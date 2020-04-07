package TextFragments;

import TextFragments.interfaces.ISentencePart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.comparingInt;
import static java.util.Comparator.naturalOrder;
import static java.util.stream.Collectors.toList;
import static org.apache.commons.lang3.StringUtils.countMatches;

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

    public List<String> sortTextByCountingSymbols(char toFind){
        return Arrays.stream(text.toString().split("\\W+"))
                .sorted(comparingInt((String word) -> countMatches(word, toFind)).reversed().thenComparing(naturalOrder()))
                .collect(toList());
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
        return stringBuilder.substring(0,stringBuilder.length()-2);
    }
}
