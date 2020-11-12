import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    Node root = createTree();

    System.out.println("Enter '.' to end.");
    Scanner scanner = new Scanner(System.in);
    String s = "";

    while (!".".equals(s)) {
      System.out.print("Enter a integer: ");
      s = scanner.next();
      try {
        if (!".".equals(s)) {
          Character output = search(root, Integer.valueOf(s));
          if (output != null)
            System.out.println(output);
        }
      } catch (NumberFormatException e) {
        System.out.println(s + " is not a integer.");
      }
    }

  }

  public static Character search(Node node, int input) {
    if (node.getInput() == input)
      return node.getOutput();
    else {
      Character c;
      for (Node child : node.getChildren()) {
        c = search(child, input);
        if (c != null)
          return c;
      }
    }
    return null;
  }

  public static Node createTree() {
    Node node1 = new Node(1, 'R');
    Node node2 = new Node(2, 'F');
    Node node3 = new Node(3, 'X');
    Node node4 = new Node(4, 'G');
    Node node5 = new Node(5, 'Z');
    Node node6 = new Node(6, 'H');
    Node node7 = new Node(7, 'P');
    Node node8 = new Node(8, 'Q');
    Node node9 = new Node(9, 'U');
    Node node10 = new Node(10, 'E');
    Node node11 = new Node(11, 'L');
    Node node12 = new Node(12, 'T');
    Node node13 = new Node(13, 'D');

    node1.addChild(node4);
    node1.addChild(node2);
    node1.addChild(node8);

    node4.addChild(node6);
    node4.addChild(node10);

    node2.addChild(node5);
    node2.addChild(node7);
    node2.addChild(node11);

    node8.addChild(node9);

    node5.addChild(node3);

    node9.addChild(node12);
    node9.addChild(node13);

    return node1;
  }


}
