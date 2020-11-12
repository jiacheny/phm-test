import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by UC196987 Jiachen Yan on 3/20/2019
 */

public class Node {

  private int input;

  private char output;

  private List<Node> children;

  public Node(int input, char output) {
    this.input = input;
    this.output = output;
    children = new ArrayList<Node>();
  }

  public int getInput() {
    return input;
  }

  public char getOutput() {
    return output;
  }

  public List<Node> getChildren() {
    return children;
  }

  public void addChild (Node newNode) {
    children.add(newNode);
  }
}
