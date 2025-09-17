import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Min {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringBuilder sb = new StringBuilder();
        
        if(isError(s)) {
            System.out.println("Error!");
            return;
        }

        if(s.contains("_")) {
            for(int i = 0; i < s.length(); i++) {
                if(s.charAt(i) == '_') {
                    i += 1;
                    if(i < s.length()) {
                        sb.append(Character.toUpperCase(s.charAt(i)));
                    }
                } else {
                    sb.append(s.charAt(i));
                }
            }
        } else {
            for(int i = 0; i < s.length(); i++) {
                if(s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
                    sb.append("_").append(Character.toLowerCase(s.charAt(i)));
                } else {
                    sb.append(s.charAt(i));
                }
            }
        }

        System.out.println(sb);

    }

    private static boolean isError(String s) {
        if(s.length() == 0) return true;
        if((s.charAt(0) >= 'A' && s.charAt(0) <= 'Z')) {
            return true;
        }

        if(s.charAt(0) == '_' || s.charAt(s.length() - 1) == '_') return true;

        if(s.contains("_")) {
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);

                if (c >= 'A' && c <= 'Z') return true;

                if (c == '_') {
                    if (i + 1 < s.length() && s.charAt(i + 1) == '_') return true;
                }
                if (!((c >= 'a' && c <= 'z') || c == '_')) return true;
            }
        } else {
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'))) return true;
            }
        }
        return false;
    }
}