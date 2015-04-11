package test.java.parsers.h1;

import main.java.enteties.ParsedText;
import main.java.enteties.Text;
import main.java.parsers.h1.H1Parser;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class H1ParserTest {

  private ParsedText getText(String htmlTag, String restOfText) {
    ParsedText expectedText = new ParsedText();
    expectedText.htmlTag = htmlTag;
    expectedText.restOfText = restOfText;
    return expectedText;
  }

  private void assertParser(ParsedText expectedText, String inputText) {
    H1Parser parser = new H1Parser();
    Text text = new Text(inputText);
    ParsedText receivedText = parser.parse(text);
    assertEquals(expectedText.htmlTag, receivedText.htmlTag);
    assertEquals(expectedText.restOfText, receivedText.restOfText);
  }

  @Test
  public void
  oneLineText() {

    assertParser(getText("<h1>header</h1>", ""), "#header");
    assertParser(getText("<h1>header</h1>", ""), "#  header");
  }


  @Test
  public void
  oneLineTextFollowedByText() {

    assertParser(getText("<h1>header</h1>", "text"), "#header\ntext");
  }

  @Test
  public void
  twoLineText() {

    assertParser(getText("<h1>header</h1>", ""), "header\n==============");
  }


  @Test
  public void
  manyLineText() {

    assertParser(getText("<h1>header</h1>", "text"), "header\n==============\ntext");
  }


}