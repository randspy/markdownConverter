package main.java.parsers.h1;

import main.java.enteties.ParsedText;
import main.java.enteties.Text;

public class H1Parser {

  public ParsedText parse(Text text) {

    ParsedText parsedText = new ParsedText();

    if (text.isEmpty()) {
      return parsedText;
    }

    Text textFromNextLine = text.fromNextLine();

    if (textFromNextLine.subtextMatching("=+").isEmpty()) {
      parsedText.htmlTag = htmlTag(text.subtextMatching(hashTag()));
      parsedText.restOfText = textAfterHashTagLine(text);
    } else {
      parsedText.htmlTag = htmlTag(text.subtextMatching(fullLine()));
      parsedText.restOfText = textAfterEqualCharacterLine(textFromNextLine);
    }


    return parsedText;
  }

  private String hashTag() {
    return "[^#^\\s].*";
  }

  private String fullLine() {
    return ".*";
  }

  private String textAfterEqualCharacterLine(Text nextLine) {
    return nextLine.fromNextLine().subtextMatching(fullLine());
  }

  private String textAfterHashTagLine(Text text) {
    return text.length() > 1 ? textAfterEqualCharacterLine(text) : "";
  }

  private String htmlTag(String matched) {
    return  "<h1>" + matched + "</h1>";
  }
}
