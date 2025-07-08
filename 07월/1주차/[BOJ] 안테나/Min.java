import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Min {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer str = new StringTokenizer(br.readLine());
        int[] house = new int[N];
        for(int i = 0; i < N; i++) {
            house[i] = Integer.parseInt(str.nextToken());
        }
        Arrays.sort(house);
        int mid = house.length % 2 == 0 ? house.length / 2 - 1 : house.length / 2;

        System.out.println(house[mid]);
    }
}
