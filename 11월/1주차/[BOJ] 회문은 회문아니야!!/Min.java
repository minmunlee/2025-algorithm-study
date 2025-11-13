import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Min {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split("");
        int cnt = s.length;
        boolean check = false;
        boolean allSame = true;

        for(int i = 1; i < s.length; i++) {
            if(!s[0].equals(s[i])) {
                allSame =false;
                break;
            }
        }

        if(allSame) {
            System.out.println(-1);
            return;
        }

        for(int i = 0; i < s.length / 2; i++) {
            for(int j = 0; j < s.length / 2; j++) {
                if(!s[j + i].equals(s[s.length - 1 - j])) {
                    check = true;
                    break;
                }
            }

            if(check) {
                System.out.println(cnt);
                return;
            }
            cnt -= 1;
        }

        System.out.println(cnt);

    }
}