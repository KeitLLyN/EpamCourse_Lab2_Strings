import TextFragments.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) {
        TextParser textParser = new TextParser("src/main/Text.txt");
        Text text;
        text = textParser.parse();
        System.out.println(text.sortTextByCountingSymbols(getInput()));
    }

    private static char getInput() {
        String inputChar;
        while (true) {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                inputChar = reader.readLine();
                return inputChar.charAt(0);
            } catch (IOException ex){
                System.out.println(ex.getMessage());
            }

        }
    }
}
