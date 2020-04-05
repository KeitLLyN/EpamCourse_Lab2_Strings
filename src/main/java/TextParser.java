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

    private final String PUNCTUATION_MARKS = ",:�";
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
            // ���� ������� ������ �������� ������ ����������
            if (PUNCTUATION_MARKS.contains(String.valueOf(symbols[i]))){
                sentence.add(new PunctuationMark(symbols[i]));
                if (isEnterPressed(symbols,i+1)){
                    sentence.add(new PunctuationMark('\n'));
                    word.removeStartSymbol();
                    i+=2;
                }
            }
            // ���� ������� ������ �������� ���������� �����������
            if (END_OF_SENTENCE_MARKS.contains(String.valueOf(symbols[i]))){
                sentence.add(new PunctuationMark(symbols[i]));
                // ���� ����� ����� ����� �����, �� � ����������� ��������� ���� ��������
                if (i < book.length()-2 && isEnterPressed(symbols,i+1)){
                    sentence.add(new PunctuationMark('\n'));
                    // ��������� ������, ��� ������ ������ �����, ����� ������ ��������� ������ �� ���������� � �������
                    word.removeStartSymbol();
                    i+=2;
                }
                paragraph.add(sentence);
                sentence = new Sentence();
            }

            if (isTheEndOfParagraph(symbols,i)){
                i += 3; // �.� ����� ��������� 4 ������, � ����������� ������ ������ 2
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
