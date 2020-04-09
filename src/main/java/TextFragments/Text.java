package TextFragments;

import TextFragments.interfaces.ISentencePart;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Comparator.comparingInt;
import static java.util.Comparator.naturalOrder;
import static java.util.stream.Collectors.toList;
import static org.apache.commons.lang3.StringUtils.countMatches;

public class Text {
    private List<Paragraph> text;
    private static final Logger LOG = LogManager.getLogger(Text.class);

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

    public List<String> sortByCountingSymbols(char toFind){
        LOG.info(String.format("Text was sorting by counting '%s' symbol",toFind));
        return Arrays.stream(toString().split("\\W+"))
                .sorted(comparingInt((String word) -> countMatches(word, toFind)).reversed().thenComparing(naturalOrder()))
                .collect(toList());
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String output = "";
        LOG.info("Text was displayed ");
        for(Paragraph paragraph: text){
            for(Sentence sentence: paragraph.getParagraph()){
                for (ISentencePart sentencePart: sentence.getSentence()){
                    stringBuilder.append(sentencePart.getPart());
                }
            }
            stringBuilder.append("\n\n");
        }
        try{
            output = stringBuilder.substring(0,stringBuilder.length()-2);
        }catch (StringIndexOutOfBoundsException ex){
            LOG.error(ex.getMessage());
        }
        return output;
    }
}
