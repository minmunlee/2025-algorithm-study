import java.util.*;

class Min {
    public String solution(String p) {
        String answer = getStr(p);
        return answer;
    }
    
    public static String getStr(String p) {
        if(p.equals("")) return "";
        
        int idx = getIdx(p);
        String u = p.substring(0, idx);
        String v = p.substring(idx);
        
        if(isCollectiveStr(u)) {
            return u + getStr(v);
        } else {
            return "(" + getStr(v) + ")" + getCollectiveStr(u);
        }
    }
    
    public static int getIdx(String p) {
        int o = 0;
        int c = 0;
        String[] str = p.split("");
        for(String s : str) {
            if(s.equals("(")) {
                o++;
            }else {
                c++;
            }
            if(o == c) return o + c;
        } 
        return 0;
    }
    
    public static boolean isCollectiveStr(String u) {
        List<String> list = new ArrayList<>();
        String[] str = u.split("");
        
        for(String s : str) {
            if(s.equals("(")) {
                list.add(s);
            }else {
                if(list.size() == 0) return false;
                list.remove(list.size() - 1);
            }
        }
        
        if(list.size() != 0) return false;
        
        return true;
    }
    
    public static String getCollectiveStr(String u) {
        String[] str = u.substring(1, u.length() - 1).split("");
        String collective = "";
        for(String s : str) {
            if(s.equals("(")) {
                collective += ")";
            }else if(s.equals(")")) {
                collective += "(";
            }
        }
        
        return collective;
    }
}