import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Min {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split("");
        Stack<String> stack = new Stack<>();
        for(int i = 0; i < s.length; i ++){
            if(s[i].equals("P")) {
                stack.push(s[i]);
            }else {
                if(i + 1 < s.length && s[i + 1].equals("P") && stack.size() >= 2) {
                    stack.pop();
                    stack.pop();
                    i += 1;
                    stack.push("P");
                }else{
                    System.out.println("NP");
                    return;
                }
            }
        }

        if(stack.size() == 1 && stack.peek().equals("P")){
            System.out.println("PPAP");
        }else {
            System.out.println("NP");
        }
    }
}
