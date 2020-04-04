import TextFragments.Paragraph;
import TextFragments.PunctuationMark;
import TextFragments.Sentence;
import TextFragments.Text;

import java.io.FileReader;
import java.io.IOException;

public class TextParser {
    private String path;
    private String book;

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
        if (path == null || book == null) return null;

        StringBuilder stringBuilder = new StringBuilder();
        Sentence sentence = new Sentence();
        Paragraph paragraph = new Paragraph();
        Text text = new Text();
        char[] symbols = book.toCharArray();
        String punctuationMarks = ".,?!:;–";

        for (int i = 0; i < book.length(); i++) {
            if(symbols[i] == '\r' && symbols[i + 1] == '\n') {
                i+=2; // т.к таких симоволов 4 подряд, а проверяется только первые 2
                text.add(paragraph);
                paragraph.clear();
            }
            if (punctuationMarks.contains(String.valueOf(symbols[i]))){
                sentence.add(new PunctuationMark(symbols[i]));
            }

        }
        return text;
    }

    @Override
    public String toString(){
        return book;
    }
}
