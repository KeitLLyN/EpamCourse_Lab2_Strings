import TextFragments.Text;


public class Main {
    public static void main(String[] args) {
        TextParser textParser = new TextParser("src/main/Text ENG.txt");
        Text text;
        text = textParser.parse();
        System.out.println(text);
        System.out.println(text.sortByCountingSymbols(Input.getChar()));
    }
}
