package main.java.enteties;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Text {
  private String[] text;

  public Text(String text) {

    this.text = text.split("\n");
  }

  public boolean isEmpty() {

    boolean isEmpty = true;

    for(int index = 0; index < text.length; index++) {
        isEmpty = text[index].isEmpty() ? isEmpty : false;
    }

    return isEmpty;
  }

  public String subtextMatching(String pattern) {

    Matcher matcher = Pattern.compile(pattern).matcher(text[0]);
    return matcher.find() ? matcher.group(0) : "";
  }

  public int indexOf(String substring) {
    return text[0].indexOf(substring);
  }

  public int length() {
    return text[0].length();
  }

  public String substring(int index) {
    return text[0].substring(index);
  }

  public boolean startsWith(String substring) {
    return text[0].startsWith(substring);
  }

  public Text fromNextLine()
  {
    StringBuilder stringBuilder = new StringBuilder();
    for (int index = 1 ; index < text.length; index++) {
      stringBuilder.append(text[index]);
      stringBuilder.append(newLine(index, text.length));
    }

    return new Text(stringBuilder.toString());
  }

  private String newLine(int index, int size) {
    String newLine = "";
    if (index != size - 1) {
      newLine = "\n";
    }

    return newLine;
  }
}
