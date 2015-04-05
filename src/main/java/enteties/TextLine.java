package main.java.enteties;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextLine {
  public String text = "";

  public boolean isEmpty(){
    return text.isEmpty();
  }

  public boolean startsWith(String string) {
    return text.startsWith(string);
  }
  public String matchingPattern(String input) {
    Pattern pattern = Pattern.compile(input);

    Matcher matcher = pattern.matcher(text);
    if (matcher.find())
    {
      text = matcher.group(0);
    }
    return text;
  }
}
