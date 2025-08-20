import java.io.*;
import java.util.*;

public class Min {
    static List<int[]> arr = new ArrayList<>();
    static int W, H, N, sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int dir = Integer.parseInt(st.nextToken());
            int location = Integer.parseInt(st.nextToken());
            arr.add(getPosition(dir, location));
        }

        getDistance();
        System.out.println(sum);
    }

    private static int[] getPosition(int dir, int location) {
        if (dir == 1) return new int[] { 0, location };
        if (dir == 2) return new int[] { H, location };
        if (dir == 3) return new int[] { location, 0 };
        if (dir == 4) return new int[] { location, W };
        return new int[] { 0, 0 };
    }

    private static void getDistance() {
        int[] guard = arr.get(N);

        for (int i = 0; i < N; i++) {
            int[] shop = arr.get(i);

            if (Math.abs(guard[0] - shop[0]) == H) {
                sum += H + Math.min(guard[1] + shop[1], 2 * W - guard[1] - shop[1]);
            }
            else if (Math.abs(guard[1] - shop[1]) == W) {
                sum += W + Math.min(guard[0] + shop[0], 2 * H - guard[0] - shop[0]);
            }
            else {
                sum += Math.abs(guard[0] - shop[0]) + Math.abs(guard[1] - shop[1]);
            }
        }
    }
}