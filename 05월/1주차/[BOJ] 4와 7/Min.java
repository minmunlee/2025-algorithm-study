import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Min {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        String n = Integer.toBinaryString(K + 1).replace("0", "4").replace("1", "7");
        n = n.substring(1);
        System.out.println(n);
    }
}