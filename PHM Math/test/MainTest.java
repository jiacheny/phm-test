import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

/**
 * Created by UC196987 Jiachen Yan on 3/21/2019
 */

public class MainTest {

  @Test
  public void set1Test() throws IOException {
    List<Double> inputs = Arrays.asList(2.0, 4.0, 6.0);
    BigDecimal expectedOutput = BigDecimal.valueOf(16);
    File expectedFile = new File("test/set1Test.txt");
    test(inputs, expectedOutput, expectedFile);
  }

  @Test
  public void set2Test() throws IOException {
    List<Double> inputs = Arrays.asList(1.0, 2.0, 3.0, 4.0);
    BigDecimal expectedOutput = BigDecimal.ONE;
    File expectedFile = new File("test/set2Test.txt");
    test(inputs, expectedOutput, expectedFile);
  }

  private void test(List<Double> inputs, BigDecimal expectedOutput, File expectedFile) throws IOException {
    File testingFile = new File("test/test.txt");
    Main.initializeFile(testingFile, inputs);
    BigDecimal testResult = Main.calculate(inputs, testingFile);
    String testEquation = String.join("", Files.readAllLines(Paths.get("test/test.txt")));
    String expectedEquation = String.join("", Files.readAllLines(Paths.get(expectedFile.getCanonicalPath())));

    assertTrue(expectedOutput.compareTo(testResult) == 0);
    assertEquals(expectedEquation, testEquation);
  }

}