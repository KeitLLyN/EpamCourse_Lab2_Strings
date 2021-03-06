package TextFragments;

import TextFragments.interfaces.ISymbol;

public class Symbol implements ISymbol {
    private char symbol;

    public Symbol() {
        symbol = '\0';
    }

    public Symbol(char symbol) {
        this.symbol = symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    @Override
    public char getSymbol() {
        return symbol;
    }

    @Override
    public String toString(){
        return String.valueOf(symbol);
    }

}
