import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Min {
    static String[] start, switchA, switchB;
    static int N;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        start = br.readLine().split("");
        String[] target = br.readLine().split("");

        switchA = new String[N];
        switchB = new String[N];

        initSwitch(true);
        initSwitch(false);

        int aCnt = 1;
        int bCnt = 0;

        for(int i = 1; i < N; i++) {
            if(!switchA[i - 1].equals(target[i - 1])) {
                changeStatus('A', i);
                aCnt += 1;
            }
            
            if(!switchB[i - 1].equals(target[i - 1])) {
                changeStatus('B', i);
                bCnt += 1;
            }
        }

        boolean compareA = Arrays.equals(switchA, target);
        boolean compareB = Arrays.equals(switchB, target);

        if(compareA && compareB) {
            System.out.println(Math.min(aCnt, bCnt));
        } else if(compareA) {
            System.out.println(aCnt);
        } else if(compareB) {
            System.out.println(bCnt);
        } else {
            System.out.println(-1);
        }
        
    }   
    
    private static void initSwitch(boolean onLight) {
        if(onLight) {
            switchA[0] = start[0].equals("0") ? "1" : "0";
            switchA[1] = start[1].equals("0") ? "1" : "0";

            for(int i = 2; i < N; i++) {
                switchA[i] = start[i];
            }
        } else {
            for(int i = 0; i < N; i++) {
                switchB[i] = start[i];
            }
        }
    }

    private static void changeStatus(char c, int idx) {
        if(c == 'A') {
            switchA[idx - 1] = switchA[idx - 1].equals("0") ? "1" : "0";
            switchA[idx] = switchA[idx].equals("0") ? "1" : "0";
            if(idx < N - 1) {
                switchA[idx + 1] = switchA[idx + 1].equals("0") ? "1" : "0";
            }
        } else {
            switchB[idx - 1] = switchB[idx - 1].equals("0") ? "1" : "0";
            switchB[idx] = switchB[idx].equals("0") ? "1" : "0";
            if(idx < N - 1) {
                switchB[idx + 1] = switchB[idx + 1].equals("0") ? "1" : "0";
            }
        }
    }
}
