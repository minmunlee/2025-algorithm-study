import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

class Min {
    static int sum1, sum2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];
        for(int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }

        Arrays.sort(arr, new Comparator<String>() {
            public int compare(String s1, String s2) {
                if(s1.length() == s2.length()) {
                    if(isSameSum(s1, s2)){
                        return s1.compareTo(s2);
                    } else {
                        return sum1 - sum2;
                    }
                } else {
                    return s1.length() - s2.length();
                }
            }
        });
        
        for(String s : arr) {
            System.out.println(s);
        }
    }

    private static boolean isSameSum(String s1, String s2) {
        sum1 = 0;
        sum2 = 0;
        for(int i = 0; i < s1.length(); i++) {
            if(Character.isDigit(s1.charAt(i))) {
                sum1 += s1.charAt(i) - '0';
            }
            if(Character.isDigit(s2.charAt(i))) {
                sum2 += s2.charAt(i) - '0';
            }
        }
        return sum1 == sum2 ? true : false;
    }
}