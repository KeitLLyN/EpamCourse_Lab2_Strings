import TextFragments.*;

import java.io.FileReader;
import java.io.IOException;

public class TextParser {
    private String path;
    private String book;

    private Sentence sentence = new Sentence();
    private Paragraph paragraph = new Paragraph();
    private Word word = new Word();
    private Text text = new Text();

    private final String PUNCTUATION_MARKS = ",:–";
    private final String END_OF_SENTENCE_MARKS = ".?!;";

    public TextParser(){
        path = null;
        book = null;
    }

    public TextParser(String path){
        StringBuilder stringBuilder = new StringBuilder();
        try(FileReader reader = new FileReader(path)){
            int asciiNumber;
            while((asciiNumber=reader.read())!=-1){
                stringBuilder.append((char)asciiNumber);
            }
            book = stringBuilder.toString();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    public Text parse(){
        if (path == null && book == null) return null;
        char[] symbols = book.toCharArray();

        for (int i = 0; i < book.length(); i++) {

            if(isNotPunctuation(symbols[i])) {
                while (isNotPunctuation(symbols[i])){
                    word.add(new Symbol(symbols[i]));
                    i++;
                }
                sentence.add(word);
                word = new Word(' ');
            }
            // если текущий символ является знаком препинания
            if (PUNCTUATION_MARKS.contains(String.valueOf(symbols[i]))){
                sentence.add(new PunctuationMark(symbols[i]));
                if (isEnterPressed(symbols,i+1)){
                    sentence.add(new PunctuationMark('\n'));
                    word.removeStartSymbol();
                    i+=2;
                }
            }
            // если текущий символ является окончанием предложения
            if (END_OF_SENTENCE_MARKS.contains(String.valueOf(symbols[i]))){
                sentence.add(new PunctuationMark(symbols[i]));
                // если после точки нажат энтер, то к предложению добавляем знак перехода
                if (i < book.length()-2 && isEnterPressed(symbols,i+1)){
                    sentence.add(new PunctuationMark('\n'));
                    // убирается пробел, как первый символ слова, чтобы начало выводимой строки не начиналось с пробела
                    word.removeStartSymbol();
                    i+=2;
                }
                paragraph.add(sentence);
                sentence = new Sentence();
            }

            if (isTheEndOfParagraph(symbols,i)){
                i += 3; // т.к таких симоволов 4 подряд, а проверяется только первые 2
                text.add(paragraph);
                word.removeStartSymbol();
                paragraph = new Paragraph();
            }
        }
        text.add(paragraph);
        return text;
    }

    private boolean isNotPunctuation(char symbol){
        return !PUNCTUATION_MARKS.contains(String.valueOf(symbol)) &&
                !END_OF_SENTENCE_MARKS.contains(String.valueOf(symbol)) &&
                symbol != ' ' &&
                symbol != '\r';
    }

    private boolean isEnterPressed(char[] symbols, int i){
        return symbols[i] == '\r' && symbols[i + 1] == '\n' && symbols[i+2] != '\r';
    }

    private boolean isTheEndOfParagraph(char[] symbols , int i){
        return symbols[i] == '\r' && symbols[i+1]=='\n' && symbols[i+2]=='\r';
    }

    @Override
    public String toString(){
        return book;
    }
}
