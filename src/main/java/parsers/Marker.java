package main.java.parsers;

public class Marker {
  public String markdownTag;
  public String htmlTag;

  public Marker(String markdownTag, String htmlTag) {
    this.markdownTag = markdownTag;
    this.htmlTag = htmlTag;
  }

  public String openingHtmlTag() {
    return "<" + htmlTag + ">";
  }

  public String closingHtmlTag() {
    return "</" + htmlTag + ">";
  }


}
