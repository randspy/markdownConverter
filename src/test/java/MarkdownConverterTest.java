package test.java;

import main.java.MarkdownConverter;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MarkdownConverterTest {

  private MarkdownConverter convert;

  private String wrappedWithHeader(String content) {
    return "<html>\n<body>\n" + content + "</body>\n</html>";
  }

  @Before
  public void setUp(){
    convert = new MarkdownConverter();
  }

  @Test
  public void
  empty() {
    String expectedHtml = wrappedWithHeader("");
    assertEquals(expectedHtml, convert.toHtml(""));
  }

  @Test
  public void
  text() {
    String expectedHtml = wrappedWithHeader("<p>text</p>\n");

    assertEquals(expectedHtml, convert.toHtml("text"));
  }

  @Test
  public void
  header() {
    String expectedHtml = wrappedWithHeader("<h1>header</h1>\n");

    assertEquals(expectedHtml, convert.toHtml("#header"));
  }

  @Test
  public void
  multiLineItems() {
    String expectedHtml = wrappedWithHeader(
           "<h1>header 1</h1>\n");

    assertEquals(expectedHtml,
        convert.toHtml(
            "header 1\n" +
            "====================\n"));
  }

}