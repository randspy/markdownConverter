package main.java;

import main.java.enteties.TextLine;
import main.java.parsers.HeaderH1;

public class MarkdownConverter {
  public String toHtml(String markdown) {

    String header = "<html>\n<body>\n";
    String footer = "</body>\n</html>";
    String content = "";

    String[] lines = markdown.split("\n");

    for (String line : lines) {
      TextLine text = new TextLine();
      text.text = line;
      content += lineToHtml(text);
    }

    return header + content + footer;
  }

  private String lineToHtml(TextLine line) {
    HeaderH1 h1 = new HeaderH1();

    String content = h1.parse(line).htmlValue;

    if (content.isEmpty() && !line.isEmpty()) {
      content += "<p>" + line.text + "</p>\n";
    }
    return content;
  }
}
