import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Min {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int r = Integer.parseInt(br.readLine());
        int[] arr = new int[r];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < r; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> photo = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < r; i++) {
            int num = arr[i];

            if (photo.contains(num)) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            } else {
                if (photo.size() == N) { // 이미 꽉 찬 경우
                    int min = 1001;
                    int idx = 0;
            
                    for (int j = 0; j < photo.size(); j++) {
                        int count = map.get(photo.get(j));
                        if (count < min) {
                            min = count;
                            idx = j;
                        }
                    }
                    map.remove(photo.get(idx));
                    photo.remove(idx);
                }
            
                photo.add(num);
                map.put(num, 1);
            }
        }

        Collections.sort(photo);
        for (int p : photo) {
            System.out.print(p + " ");
        }
    }
}