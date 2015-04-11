package test.java.parsers.h1;

import main.java.enteties.Text;
import main.java.parsers.h1.H1Matcher;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class H1MatcherTest {

  private H1Matcher matcher;

  @Before
  public void setUp(){
    matcher = new H1Matcher();
  }

  @Test public void
  textDoesNotContainHeaderH1() {

    assertFalse(matcher.startsWith(new Text("")));
  }

  @Test public void
  textDoesNotStartsHeaderH1() {

    assertFalse(matcher.startsWith(new Text("fd#matcher")));
    assertFalse(matcher.startsWith(new Text("fd\n#matcher")));
  }


  @Test public void
  textStartsWithHeaderH1(){

    assertTrue(matcher.startsWith(new Text("#matcher")));
    assertTrue(matcher.startsWith(new Text("#\nmatcher")));
  }

  @Test public void
  textStartsWithTwoLineHeaderH1(){

    assertTrue(matcher.startsWith(new Text("matcher\n========")));
  }


}