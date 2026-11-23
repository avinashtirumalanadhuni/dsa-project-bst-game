import java.util.*;

class Node {
    int val;
    Node left, right;
    public Node(int v) { this.val = v; }
}

public class SimpleGame {
    static Node root = new Node(50);
    static int score = 0;
    static Scanner sc = new Scanner(System.in);
    static Random rand = new Random();

    static List<Integer> getAllValues(Node node) {
        List<Integer> list = new ArrayList<>();
        if (node == null) return list;
        list.addAll(getAllValues(node.left));
        list.add(node.val);
        list.addAll(getAllValues(node.right));
        return list;
    }

    static void printTree(Node node, String prefix, boolean isLeft) {
        if (node == null) return;
        System.out.println(prefix + (isLeft ? "|-- (L) " : "`-- (R) ") + node.val);
        printTree(node.left, prefix + (isLeft ? "|   " : "    "), true);
        printTree(node.right, prefix + (isLeft ? "|   " : "    "), false);
    }

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("      SUPER SIMPLE BST (BINARY SEARCH TREE) GAME");
        System.out.println("==================================================");
        System.out.println("Rule:");
        System.out.println("  - If new number < current node  --> Type 'L' (Left)");
        System.out.println("  - If new number > current node  --> Type 'R' (Right)");
        System.out.println("==================================================");

        while (true) {
            List<Integer> existing = getAllValues(root);
            int newVal;
            do {
                newVal = 10 + rand.nextInt(90);
            } while (existing.contains(newVal));

            System.out.println("\n--------------------------------------------------");
            System.out.println("⭐ SCORE: " + score);
            System.out.println("CURRENT TREE:");
            System.out.println(" ROOT: " + root.val);
            printTree(root.left, " ", true);
            printTree(root.right, " ", false);
            System.out.println("\n👉 INCOMING NUMBER: " + newVal);
            System.out.println("--------------------------------------------------");

            Node curr = root;
            boolean success = true;

            while (true) {
                System.out.print("At node [" + curr.val + "], which way does " + newVal + " go? (L/R) [Q to quit]: ");
                String choice = sc.nextLine().trim().toUpperCase();

                if (choice.equals("Q")) {
                    System.out.println("\nGame Over! Final Score: " + score);
                    return;
                }

                String correct = (newVal < curr.val) ? "L" : "R";

                if (!choice.equals(correct)) {
                    String reason = correct.equals("L") ? "smaller" : "bigger";
                    System.out.println("❌ Oops! " + newVal + " is " + reason + " than " + curr.val + ", so it must go " + correct + "!");
                    System.out.println("Try the next number!");
                    success = false;
                    break;
                } else {
                    System.out.println("✅ Correct! Moving " + correct + "...");
                    if (correct.equals("L")) {
                        if (curr.left == null) {
                            curr.left = new Node(newVal);
                            System.out.println("🎉 Empty slot found! Placed " + newVal + " in the tree!");
                            break;
                        } else {
                            curr = curr.left;
                        }
                    } else {
                        if (curr.right == null) {
                            curr.right = new Node(newVal);
                            System.out.println("🎉 Empty slot found! Placed " + newVal + " in the tree!");
                            break;
                        } else {
                            curr = curr.right;
                        }
                    }
                }
            }

            if (success) {
                score++;
                System.out.println("🌟 +1 Point! Total Score: " + score);
                System.out.println("📚 Sorted numbers in tree (In-Order): " + getAllValues(root));
            }
        }
    }
}
