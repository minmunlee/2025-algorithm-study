import java.io.*;
import java.util.*;

public class Mun {
    static class Node {
        Character root;
        Character left;
        Character right;
        
        public Node(Character root) {
            this.root = root;
        }
        
        public void setChild(char left, char right) {
            this.left = convert(left);
            this.right = convert(right);
        }

    }
    
    public static Character convert(Character c) {
        return (c == '.') ? null : c;
    }
    
    static HashMap<Character, Node> map = new HashMap<>();
    static StringBuilder sb = new StringBuilder("");
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int N = Integer.parseInt(br.readLine());
	    map.put('A', new Node(null));
	    for(int i=0;i<N;i++) {
	        String info = br.readLine();
	        char node = info.charAt(0);
	        char left = info.charAt(2);
	        char right = info.charAt(4);
	        map.get(node).setChild(left, right);
	        map.put(left, new Node(node));
	        map.put(right, new Node(node));
	    }
	    before('A', map.get('A'));
	    System.out.println(sb.toString());
	    sb = new StringBuilder("");
	    middle('A', map.get('A'));
	    System.out.println(sb.toString());
	    sb = new StringBuilder("");
	    after('A', map.get('A'));
	    System.out.print(sb.toString());
	}
	
	private static void before(char now, Node N) {
	    sb.append(now);
	    if(N.left != null) {
	        before(N.left, map.get(N.left));
	    }
	    if(N.right != null) {
	        before(N.right, map.get(N.right));
	    }
	}
	
	private static void middle(char now, Node N) {
	    if(N.left == null) {
	        sb.append(now);
	    } else {
	        middle(N.left, map.get(N.left));
	        sb.append(now);
	    }
	    if(N.right != null) {
	        middle(N.right, map.get(N.right));
	    }
	}
	
	private static void after(char now, Node N) {
	    if(N.left == null && N.right == null) {
	        sb.append(now);
	        return;
	    }
	    if(N.left != null) {
	        after(N.left, map.get(N.left));
	    }
	    if(N.right != null) {
	        after(N.right, map.get(N.right));
	    }
	    sb.append(now);
	}
}