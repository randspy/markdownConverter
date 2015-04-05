package main.java.parsers;

import main.java.enteties.ParsedText;
import main.java.enteties.TextLine;

public class HeaderH1 {

  public ParsedText parse(TextLine line) {

    ParsedText text = new ParsedText();

    if (line.startsWith("#"))
    {
        text.htmlValue += "<h1>" + line.matchingPattern("[^#^\\s].*") + "</h1>\n";
    }

    return text;
  }


}
