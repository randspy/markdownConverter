package main.java.parsers;

import main.java.enteties.ParsedText;
import main.java.enteties.TextLine;

import java.util.regex.Pattern;

public class Header {
  public ParsedText parse(TextLine line, Marker marker) {

    ParsedText text = new ParsedText();

    if (line.startsWith(marker.markdownTag)) {
      text.htmlValue +=
          marker.openingHtmlTag() +
          line.substring(Pattern.compile("[^#" + marker.markdownTag + "^\\s].*")) +
          marker.closingHtmlTag() + "\n";
    }

    return text;
  }

}
