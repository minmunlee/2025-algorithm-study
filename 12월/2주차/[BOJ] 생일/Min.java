import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Min {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer str;
        Integer young = 19891231;
        String youngName = "";
        Integer old = 20110101;
        String oldName = "";
        for(int i = 0; i < N; i++) {
            str = new StringTokenizer(br.readLine());
            String name = str.nextToken();
            String date = str.nextToken();
            if(date.length() == 1) date = "0" + date;
            String month = str.nextToken();
            
            if(month.length() == 1) month = "0" + month;
            String year = str.nextToken();
            Integer birth = Integer.parseInt(year + month + date);
            if(young < birth) {
                youngName = name;
                young = birth;
            }
            if(old > birth) {
                oldName = name;
                old = birth;
            }
        }
        System.out.println(youngName);
        System.out.println(oldName);
    }
}
