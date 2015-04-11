package main.java.parsers.plainText;

import main.java.enteties.ParsedText;
import main.java.enteties.Text;

public class PlainTextParser {

  public ParsedText parse(Text text) {
    ParsedText parsedText = new ParsedText();
    parsedText.htmlTag = "<p>" + text.subtextMatching(".*") + "</p>";
    parsedText.restOfText = text.fromNextLine().subtextMatching(".*");
    return parsedText;
  }
}
