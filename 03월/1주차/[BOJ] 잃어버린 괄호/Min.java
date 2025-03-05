import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Min {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] minus = br.readLine().split("-");
        int answer = 0;
        
        for(int i = 0;i < minus.length; i++){
            int tmp = 0;
            
            String[] plus = minus[i].split("\\+");
            
            for(int j = 0;j < plus.length; j++){
                tmp += Integer.parseInt(plus[j]);
            }
            if(i==0){
                answer += tmp;
            }else{
                answer -= tmp;
            }
        }
        System.out.println(answer);
    }
}

