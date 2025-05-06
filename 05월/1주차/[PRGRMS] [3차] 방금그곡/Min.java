import java.util.*;
import java.text.*;

class Min {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        int maxTime = -1;

        for (int i = 0; i < musicinfos.length; i++) {
            String[] music = musicinfos[i].split(",");
            int playTime = getPlayTime(music[0], music[1]);
            String[] str = getMusicArr(music[3]);
            String playMelody = makePlayMelody(str, playTime);

            if (isSameMusic(m, playMelody)) {
                if (playTime > maxTime) {
                    maxTime = playTime;
                    answer = music[2];
                }
            }
        }
        return answer;
    }

    public static int getPlayTime(String start, String end) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("HH:mm");
            Date sTime = format.parse(start);
            Date eTime = format.parse(end);
            long diff = eTime.getTime() - sTime.getTime();
            return (int)(diff / (1000 * 60));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return 0;
    }

    public static String makePlayMelody(String[] str, int playTime) {
        String melody = "";
        for (int i = 0; i < playTime; i++) {
            melody += str[i % str.length];
        }
        return melody;
    }

    public static boolean isSameMusic(String m, String melody){
        String[] target = getMusicArr(m);
        String[] played = getMusicArr(melody);

        for (int i = 0; i <= played.length - target.length; i++) {
            boolean match = true;
            for (int j = 0; j < target.length; j++) {
                if (!played[i + j].equals(target[j])) {
                    match = false;
                    break;
                }
            }
            if (match) return true;
        }
        return false;
    }

    public static String[] getMusicArr(String music) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < music.length(); i++) {
            char c = music.charAt(i);
            if (i + 1 < music.length() && music.charAt(i + 1) == '#') {
                list.add("" + c + "#");
                i++;
            } else {
                list.add("" + c);
            }
        }

        return list.toArray(new String[0]);
    }
}