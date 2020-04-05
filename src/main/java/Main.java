import TextFragments.*;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        TextParser textParser = new TextParser("src/main/Text.txt");
        Text text;
        text = textParser.parse();
        System.out.println(text);
    }
}
