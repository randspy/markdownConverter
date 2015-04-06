package main.java;

import main.java.enteties.TextLine;
import main.java.parsers.Header;
import main.java.parsers.Marker;

import java.util.regex.Pattern;

public class MarkdownConverter {
  public String toHtml(String markdown) {

    String header = "<html>\n<body>\n";
    String footer = "</body>\n</html>";
    String content = "";

    String[] lines = markdown.split("\n");

    for (String line : lines) {
      TextLine text = new TextLine(line);
      content += lineToHtml(text);
    }

    return header + content + footer;
  }

  private String lineToHtml(TextLine line) {
    Header header = new Header();

    String content = header.parse(line, new Marker("###", "h3")).htmlValue;
    if (content.isEmpty() && !line.isEmpty()) {
      content += header.parse(line, new Marker("##", "h2")).htmlValue;
    }
    if (content.isEmpty() && !line.isEmpty()) {
      content += header.parse(line, new Marker("#", "h1")).htmlValue;
    }

    if (content.isEmpty() && !line.isEmpty()) {
      content += "<p>" + line.substring(Pattern.compile(".*")) + "</p>\n";
    }
    return content;
  }
}
