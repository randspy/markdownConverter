package main.java;

public class MarkdownConverter {
  public String toHtml(String markdown) {

    String header = "<html>\n<body>\n";
    String footer = "</body>\n</html>";
    String content = "";

    if (!markdown.isEmpty()) {
      content += "<p>" + markdown + "</p>\n";
    }

    return header + content + footer;
  }
}
