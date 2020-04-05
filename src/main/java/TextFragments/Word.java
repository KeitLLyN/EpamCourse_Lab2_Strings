package TextFragments;

import org.apache.commons.lang3.StringUtils;
import TextFragments.interfaces.ISentencePart;

import java.util.ArrayList;
import java.util.List;

public class Word implements ISentencePart {
    private List<Symbol> word;

    public Word(){
        word = new ArrayList<>(){
            {
                add(new Symbol(' '));
            }
        };
    }

    public Word(List<Symbol> word) {
        this.word = word;
    }

    public void add(Symbol symbol){
        word.add(symbol);
    }

    public List<Symbol> getWord() {
        return word;
    }

    public void clear(){
        word = new ArrayList<>();
    }

    @Override
    public String getPart(){
        return StringUtils.join(word,"");
    }
}