import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.*;

/**
 * Created by UC196987 Jiachen Yan on 3/19/2019
 */

public class MainTest {

  private OutputStream out = new ByteArrayOutputStream();
  private PrintStream originalOut = System.out;

  @Before
  public void setUp() throws Exception {
    System.setOut(new PrintStream(out));
  }

  @After
  public void tearDown() throws Exception {
    System.setOut(originalOut);
  }


  @Test
  public void main() {
    Main.main(null);
    assertEquals("A SQL query goes into a bar, walks up to two tables and asks…\r\n“Can I join you?”\r\n", out.toString());
  }
}