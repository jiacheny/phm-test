import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.*;

/**
 * Created by UC196987 Jiachen Yan on 3/21/2019
 */

public class MainTest {

  private InputStream originalIn = System.in;
  private InputStream in;
  private OutputStream out = new ByteArrayOutputStream();
  private PrintStream originalOut = System.out;

  @Before
  public void setup() {
    System.setOut(new PrintStream(out));
  }

  @After
  public void tearDown() {
    in = null;
    System.setIn(originalIn);
    System.setOut(originalOut);
  }

  @Test
  public void firstNodeTest() throws Exception {
    String input = "1\n.";
    String expected = "Enter '.' to end.\r\n" +
        "Enter a integer: R\r\n" +
        "Enter a integer: ";
    test(expected, input);
  }

  @Test
  public void middleNodeTest() throws Exception {
    String input = "5\n.";
    String expected = "Enter '.' to end.\r\n" +
        "Enter a integer: Z\r\n" +
        "Enter a integer: ";
    test(expected, input);
  }

  @Test
  public void endNodeTest() throws Exception {
    String input = "12\n.";
    String expected = "Enter '.' to end.\r\n" +
        "Enter a integer: T\r\n" +
        "Enter a integer: ";
    test(expected, input);
  }

  @Test
  public void invalidNumberTest() throws Exception {
    String input = "t\n.";
    String expected = "Enter '.' to end.\r\n" +
        "Enter a integer: t is not a integer.\r\n" +
        "Enter a integer: ";
    test(expected, input);
  }

  @Test
  public void endTest() throws Exception {
    String input = ".";
    String expected = "Enter '.' to end.\r\nEnter a integer: ";
    test(expected, input);
  }

  private void test(String expected, String input) {
    in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);
    Main.main(null);
    assertEquals(expected, out.toString());
  }
}