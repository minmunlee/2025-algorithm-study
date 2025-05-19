import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

class Min {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashMap<String, Integer> files = new HashMap<>();

        for(int i = 0; i < N; i++){
            String[] file = br.readLine().split("\\.");
            files.put(file[1], files.getOrDefault(file[1], 0) + 1);
        }
        List<String> list = new ArrayList<>(files.keySet());
        Collections.sort(list);
        for(String s : list){
            System.out.println(s + " " + files.get(s));
        }
    }
}