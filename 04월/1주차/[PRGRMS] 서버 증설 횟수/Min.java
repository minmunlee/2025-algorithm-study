class Min {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        
        int[] servers = new int[players.length]; // 현재 서버 개수
        for (int i = 0; i < players.length; i++) {
            int player = players[i];
            int server = player / m; // 필요한 서버 개수
            
            if (server > 0) {
                if (servers[i] < server) {
                    int diff = server - servers[i]; // 추가로 필요한 서버 개수
                    answer += diff;
                    int endTime = Math.min(i + k, servers.length);
                    for (int j = i; j < endTime; j++) {
                        servers[j] += diff;
                    }
                }
            }
        }

        return answer;
    }
}