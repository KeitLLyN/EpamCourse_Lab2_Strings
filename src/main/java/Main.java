import TextFragments.PunctuationMark;
import TextFragments.Sentence;
import TextFragments.Symbol;
import TextFragments.Word;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        TextParser textParser = new TextParser("src/main/Text.txt");

        System.out.println(textParser);
    }
}
