class Min {
    public int solution(String s) {
        int answer = s.length();
        for(int i = s.length() / 2; i >= 1; i--) {
            String str = "";
            String s1 = s.substring(0, i);
            int cnt = 1;
            
            for(int j = i; j < s.length(); j += i) {
                String s2;
                if(j + i <= s.length()) {
                    s2 = s.substring(j, j + i);
                } else {
                    s2 = s.substring(j);
                }
                
                if(s1.equals(s2)) {
                    cnt++;
                } else {
                    if(cnt > 1) {
                        str += cnt;
                        cnt = 1;
                    }
                    str += s1;
                    s1 = s2;
                }
            }
            
            if(cnt > 1) {
                str += cnt;
            }
            str += s1;
            
            answer = Math.min(answer, str.length());
        }
        
        return answer;
    }
}