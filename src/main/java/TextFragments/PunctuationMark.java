package TextFragments;

public class PunctuationMark implements ISymbol, ISentencePart {
    private char mark;

    public PunctuationMark(){
        mark = '\0';
    }

    public PunctuationMark(char mark){
        this.mark = mark;
    }

    @Override
    public char getSymbol(){
        return mark;
    }

    @Override
    public String getPart(){
        return String.valueOf(mark);
    }
}
