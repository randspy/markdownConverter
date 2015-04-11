package main.java;

import main.java.enteties.ParsedText;
import main.java.enteties.Text;
import main.java.parsers.h1.H1Matcher;
import main.java.parsers.h1.H1Parser;
import main.java.parsers.plainText.PlainTextParser;

public class MarkdownConverter {
  public String toHtml(String markdown) {

    String header = "<html>\n<body>\n";
    String footer = "</body>\n</html>";
    String content = "";

    Text text = new Text(markdown);

    while(!text.isEmpty())
    {
      H1Matcher h1Matcher = new H1Matcher();
      H1Parser hiParser = new H1Parser();

      if (h1Matcher.startsWith(text)) {
        ParsedText parsedText = hiParser.parse(text);
        content += parsedText.htmlTag + "\n";
        text = new Text(parsedText.restOfText);
        continue;
      }

      PlainTextParser plainTextParser = new PlainTextParser();
      ParsedText parsedText = plainTextParser.parse(text);
      content += parsedText.htmlTag + "\n";
      text = new Text(parsedText.restOfText);
    }

    return header + content + footer;
  }

}
