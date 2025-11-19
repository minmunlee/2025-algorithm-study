import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class Node {
    String left;
    String right;

    Node(String left, String right) {
        this.left = left;
        this.right = right;
    }
}

public class Min {
    static Map<String, Node> tree;
    static String[] answer;
    static String s;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        tree = new HashMap<>();
        answer = new String[3];

        for(int i = 0; i < N; i++) {
            StringTokenizer str = new StringTokenizer(br.readLine());
            String root = str.nextToken();
            String left = str.nextToken();
            String right = str.nextToken();
            tree.put(root, new Node(left, right));
        }
        
        s = "";
        preorder("A");
        answer[0] = s;

        s = "";
        inorder("A");
        answer[1] = s;

        s = "";
        postorder("A");
        answer[2] = s;
        
        for(String ans : answer) {
            System.out.println(ans);
        }
    }
    
    private static void preorder(String n) {
        if(n.equals(".")) return;
        s += n;
        Node node = tree.get(n);
        preorder(node.left);
        preorder(node.right);
    }

    private static void inorder(String n) {
        if(n.equals(".")) return;
        Node node = tree.get(n);
        inorder(node.left);
        s += n;
        inorder(node.right);
    }

    private static void postorder(String n) {
        if(n.equals(".")) return;

        Node node = tree.get(n);
        postorder(node.left);
        postorder(node.right);
        s += n;
    }
}
