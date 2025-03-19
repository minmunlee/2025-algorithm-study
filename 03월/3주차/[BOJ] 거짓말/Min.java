import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Min {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(str.nextToken()); // 사람 수
        int M = Integer.parseInt(str.nextToken()); // 파티 수

        str = new StringTokenizer(br.readLine());
        int truth = Integer.parseInt(str.nextToken()); // 진실을 아는 사람 수
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>(); // 파티 별 오는 사람 정보
        boolean[] knowTruth = new boolean[N + 1]; // 진실 아는 사람 여부
        Queue<Integer> truthMem = new LinkedList<>();

        for (int i = 0; i < truth; i++) {
            int person = Integer.parseInt(str.nextToken());
            truthMem.add(person);
            knowTruth[person] = true;
        }

        for (int i = 0; i < M; i++) {
            str = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(str.nextToken()); // 파티 오는 사람 수
            ArrayList<Integer> arr = new ArrayList<>(); // 파티 오는 사람
            for (int j = 0; j < n; j++) {
                arr.add(Integer.parseInt(str.nextToken()));
            }
            graph.add(arr);
        }

        while (!truthMem.isEmpty()) {
            int current = truthMem.poll();

            for (ArrayList<Integer> party : graph) {
                if (party.contains(current)) {
                    for (int person : party) {
                        if (!knowTruth[person]) {
                            knowTruth[person] = true;
                            truthMem.add(person);
                        }
                    }
                }
            }
        }

        int cnt = 0;
        for (ArrayList<Integer> party : graph) {
            boolean canLie = true;
            for (int person : party) {
                if (knowTruth[person]) {
                    canLie = false;
                    break;
                }
            }
            if (canLie) cnt++;
        }

        System.out.println(cnt);
    }
}