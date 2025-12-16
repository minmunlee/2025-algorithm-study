import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Min {
    static int[][] block;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(str.nextToken());
        int P = Integer.parseInt(str.nextToken());
        int[] height = new int[C];
        str = new StringTokenizer(br.readLine());
        for(int i = 0; i < C; i++) {
            height[i] = Integer.parseInt(str.nextToken());
        }
        setBlock(P);
        int cnt = 0;

        for(int i = 0; i < height.length; i++) {
            for(int[] b : block) {
                if(i <= height.length - b.length){
                    int[] tmp = new int[b.length];
                    for(int j = 0; j < b.length; j++) {
                        tmp[j] = height[i + j] - b[j];   
                    }
                    if(canDrop(tmp)) cnt++;
                }
            }
        }
        System.out.println(cnt);
    }    

    private static void setBlock(int num) {
        switch (num) {
            case 1:
                block = new int[][]{{0}, {0, 0, 0, 0}};
                break;
            case 2:
                block = new int[][]{{0, 0}};
                break;
            case 3:
                block = new int[][]{{0, 0, 1}, {1, 0}};
                break;
            case 4:
                block = new int[][]{{1, 0, 0}, {0, 1}};
                break;
            case 5:
                block = new int[][]{{0, 0, 0}, {0, 1}, {1, 0, 1}, {1, 0}};
                break;
            case 6:
                block = new int[][]{{0, 0, 0}, {0, 0}, {0, 1, 1}, {2, 0}};
                break;
            case 7:
                block = new int[][]{{0, 0, 0}, {0, 2}, {1, 1, 0}, {0, 0}};
                break;
            default:
                break;
        }
    }

    private static boolean canDrop(int[] tmp) {
        int n = tmp[0];
        for(int i = 1; i < tmp.length; i++) {
            if(n != tmp[i]) return false;
        }
        return true;
    }
}
