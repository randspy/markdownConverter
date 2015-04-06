package main.java.enteties;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextLine {
  private String text;

  public TextLine(String text) {
    this.text = text;
  }

  public boolean isEmpty(){
    return text.isEmpty();
  }

  public boolean startsWith(String string) {
    return text.startsWith(string);
  }

  public String substring(Pattern pattern) {

    Matcher matcher = pattern.matcher(text);
    if (matcher.find())
    {
      return matcher.group(0);
    }
    return "";
  }
}
