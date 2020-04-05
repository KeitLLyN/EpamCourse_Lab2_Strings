package TextFragments;

import org.apache.commons.lang3.StringUtils;
import TextFragments.interfaces.ISentencePart;

import java.util.ArrayList;
import java.util.List;

public class Word implements ISentencePart {
    private List<Symbol> word;

    public Word(){
        word = new ArrayList<>();
    }

    public Word(List<Symbol> word) {
        this.word = word;
    }

    public Word(char symbol){
        word = new ArrayList<>(){
            {
                add(new Symbol(symbol));
            }
        };

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

    public void removeStartSymbol(){
        word.remove(0);
    }

    @Override
    public String getPart(){
        return StringUtils.join(word,"");
    }
}
