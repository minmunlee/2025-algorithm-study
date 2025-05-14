import java.util.*;

class Min {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static String[][] arr;
    static boolean[][] visited;
    static int sum;
    
    public int[] solution(String[] maps) {
        arr = new String[maps.length][maps[0].length()];
        visited = new boolean[maps.length][maps[0].length()];
        sum = 0;
        List<Integer> list = new LinkedList<>();
        
        for(int i = 0; i < maps.length; i++){
            arr[i] = maps[i].split("");
        }
        
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[i].length; j++){
                if(!visited[i][j] && !arr[i][j].equals("X")){
                    sum += Integer.parseInt(arr[i][j]);
                    dfs(i, j);
                    list.add(sum);
                    sum = 0;
                }
            }
        }
        if(list.isEmpty()){
            list.add(-1);
        }else{
            Collections.sort(list);
        }
        
        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
    
    public static void dfs(int x, int y){
        visited[x][y] = true;
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if(nx < arr.length && nx >= 0 && ny < arr[0].length && ny >= 0){
                if(!visited[nx][ny] && !arr[nx][ny].equals("X")){
                    visited[nx][ny] = true;
                    sum += Integer.parseInt(arr[nx][ny]);
                    dfs(nx, ny);
                }
            }
            
        }
    }
}