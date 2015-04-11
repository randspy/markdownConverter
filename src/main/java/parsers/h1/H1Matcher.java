package main.java.parsers.h1;

import main.java.enteties.Text;

public class H1Matcher {

  public boolean startsWith(Text text) {
    if (text.startsWith("#"))
    {
      return true;
    }
    if (!text.fromNextLine().subtextMatching("=+").isEmpty())
    {
      return true;
    }
    return false;
  }
}
