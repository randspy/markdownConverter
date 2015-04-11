package main.java;

import main.java.enteties.ParsedText;
import main.java.enteties.Text;
import main.java.parsers.h1.H1Matcher;
import main.java.parsers.h1.H1Parser;
import main.java.parsers.plainText.PlainTextParser;

public class MarkdownConverter {
  private Text text;
  private String content;

  public String toHtml(String markdown) {

    String header = "<html>\n<body>\n";
    String footer = "</body>\n</html>";

    initContent();
    setContentWith(markdown);

    while (!text.isEmpty()) {
      headerH1();
      plainText();
    }

    return header + content + footer;
  }

  private void initContent() {
    content = "";
  }

  private void headerH1() {
    H1Matcher h1Matcher = new H1Matcher();

    if (h1Matcher.startsWith(text)) {
      H1Parser h1Parser = new H1Parser();
      ParsedText parsedText = h1Parser.parse(text);
      content += parsedText.htmlTag + "\n";
      setContentWith(parsedText.restOfText);
    }
  }

  private void plainText() {
    if (!text.isEmpty()) {
      PlainTextParser plainTextParser = new PlainTextParser();
      ParsedText parsedText = plainTextParser.parse(text);
      content += parsedText.htmlTag + "\n";
      setContentWith(parsedText.restOfText);
    }
  }

  private void setContentWith(String markdown) {
    text = new Text(markdown);
  }
}
