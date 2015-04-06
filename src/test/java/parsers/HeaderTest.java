package test.java.parsers;

import main.java.enteties.TextLine;
import main.java.parsers.Header;
import main.java.parsers.Marker;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HeaderTest {

  private Header parser;
  private Marker marker;

  @Before
  public void setUp(){

    parser = new Header();
    marker = new Marker("#", "h1");
  }

  @Test
  public void
  noSpaces() {

    TextLine line = new TextLine("#header");
    assertEquals("<h1>header</h1>\n", parser.parse(line, marker).htmlValue);
  }

  @Test
  public void
  Spaces() {

    TextLine line = new TextLine("#  header");
    assertEquals("<h1>header</h1>\n", parser.parse(line, marker).htmlValue);
  }

}