import java.io.*;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.stream.Collectors;

/*

example 1:

+ (1) + (2) + (3) + (4)
- (1 x 2) – (1 x 3) – (1 x 4) – (2 x 3) – (2 x 4) – (3 x 4)
+ (1 x 2 x 3) + (1 x 2 x 4) + (1 x 3 x 4) + (2 x 3 x 4)
- ( 1 x 2 x 3 x 4 )
= 1

example 2:

(2.0) + (4.0) + (6.0)
- (2.0 * 4.0) - (2.0 * 6.0) - (4.0 * 6.0)
+ (2.0 * 4.0 * 6.0)
= 16

*/

public class Main {

  private static Logger logger;

  public static void main(String[] args) throws IOException {

    initializeLogger();

    List<Double> inputs = Arrays.asList(2.0, 4.0, 6.0);
    File file = new File("equation.txt");

    initializeFile(file, inputs);
    BigDecimal result = calculate(inputs, file);

    logger.info(String.join("", Files.readAllLines(Paths.get(file.getCanonicalPath()))));
    System.out.println(result);
  }

  public static BigDecimal calculate(List<Double> inputs, File file) throws IOException {
    List<Double> subset = new ArrayList<>();
    return find(inputs, file, BigDecimal.ZERO, subset, 0);
  }

  private static BigDecimal find(List<Double> inputs, File file, BigDecimal result, List<Double> subset, int startIndex) throws IOException {

    for (int i = startIndex; i < inputs.size(); i++) {
      subset.add(inputs.get(i));
      result = find(inputs, file, result, subset, i + 1);
      subset.remove(subset.size() - 1);
    }

    if (subset.size() > 0) {
      BigDecimal subsetResult = multiple(subset);
      String sign = (subsetResult.compareTo(BigDecimal.ZERO) >= 0 ? "+" : "-");
      appendSubEquationTo(file, subset, sign);
      result = result.add(subsetResult);
    }

    return result;
  }

  private static void initializeLogger() throws IOException {
    FileHandler handler = new FileHandler("default.log", true);
    handler.setFormatter(new SimpleFormatter());
    logger = Logger.getLogger("Main");
    logger.addHandler(handler);
  }

  public static void initializeFile(File file, List<Double> inputs) throws FileNotFoundException {
    PrintWriter writer = new PrintWriter(file);
    writer.print("");
    for (int i = 0; i < inputs.size(); i++)
      writer.println();
    writer.close();
  }

  private static void appendSubEquationTo(File file, List<Double> subset, String sign) throws IOException {
    int lineNumber = subset.size();
    String subEquation = "(" + subset.stream().map(Object::toString).collect(Collectors.joining(" × ")) + ")";

    Path path = Paths.get(file.getCanonicalPath());
    List<String> lines = Files.readAllLines(path);
    String existingLine = lines.get(lineNumber - 1);
    lines.set(lineNumber - 1, existingLine + sign + subEquation);
    Files.write(path, lines);
  }

  private static BigDecimal multiple(List<Double> subset) {
    if (subset.size() > 0) {
      BigDecimal product = subset.stream().map(BigDecimal::valueOf).reduce(BigDecimal::multiply).get();
      return subset.size() % 2 == 0 ? (product.multiply(new BigDecimal(-1))) : product;
    } else {
      return new BigDecimal(0.0);
    }
  }

}
