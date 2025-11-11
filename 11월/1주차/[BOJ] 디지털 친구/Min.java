import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Min {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str;

        for(int i = 0; i < 3; i++) {
            str = new StringTokenizer(br.readLine());
            String a = str.nextToken();
            String b = str.nextToken();

            if(isFriend(a, b)){
                System.out.println("friends");
            } else if(isAlmostFriend(a, b) || isAlmostFriend(b, a)) {
                System.out.println("almost friends");
            } else{
                System.out.println("nothing");
            }
        }
    }

    private static boolean isFriend(String a, String b) {
        for(char c : a.toCharArray()) {
            if(!b.contains(String.valueOf(c))) return false;
        }
        for(char c : b.toCharArray()) {
            if(!a.contains(String.valueOf(c))) return false;
        }
        return true;
    }

    private static boolean isAlmostFriend(String a, String b) {
        if (a.length() < 2) return false;

        for(int i = 0; i < a.length() - 1; i++) {
            int n1 = a.charAt(i) - '0';
            int n2 = a.charAt(i + 1) - '0';

            if(n1 - 1 >= 0 && n2 + 1 < 10) {
                char[] arr = a.toCharArray();
                arr[i] = (char)(n1 - 1 + '0');
                arr[i + 1] = (char)(n2 + 1 + '0');
                if(arr.length > 0 && arr[0] != '0' && isFriend(String.valueOf(arr), b)) 
                    return true;
            }

            if(n1 + 1 < 10 && n2 - 1 >= 0) {
                char[] arr = a.toCharArray();
                arr[i] = (char)(n1 + 1 + '0');
                arr[i + 1] = (char)(n2 - 1 + '0');
                if(arr.length > 0 && arr[0] != '0' && isFriend(String.valueOf(arr), b)) 
                    return true;
            }
        }

        return false;
    }
}