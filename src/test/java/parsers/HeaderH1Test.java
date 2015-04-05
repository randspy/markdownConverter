package test.java.parsers;

import main.java.enteties.TextLine;
import main.java.parsers.HeaderH1;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HeaderH1Test {

  private HeaderH1 parser;

  @Before
  public void setUp(){
    parser = new HeaderH1();
  }

  @Test
  public void
  noSpaces() {

    TextLine line = new TextLine();
    line.text = "#header";
    assertEquals("<h1>header</h1>\n", parser.parse(line).htmlValue);
  }

  @Test
  public void
  Spaces() {

    TextLine line = new TextLine();
    line.text = "#  header";
    assertEquals("<h1>header</h1>\n", parser.parse(line).htmlValue);
  }

}