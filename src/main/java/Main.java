import TextFragments.Text;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Main {
    private static final Logger LOG = LogManager.getLogger(Main.class);


    public static void main(String[] args) {
        LOG.info("Main started");

        TextParser textParser = new TextParser("src/main/Text ENG.txt");
        Text text;
        text = textParser.parse();
        System.out.println(text);
        System.out.println(text.sortByCountingSymbols(Input.getChar()));

        LOG.info("Main finished");
    }
}
