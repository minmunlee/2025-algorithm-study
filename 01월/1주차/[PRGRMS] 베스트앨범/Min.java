import java.util.*;

class Min {
    public int[] solution(String[] genres, int[] plays) {

        // 장르별 재생 횟수
        HashMap<String, Integer> genreCnt = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            genreCnt.put(genres[i], genreCnt.getOrDefault(genres[i], 0) + plays[i]);
        }

        List<String> sortedGenres = new ArrayList<>(genreCnt.keySet());
        sortedGenres.sort((g1, g2) -> genreCnt.get(g2) - genreCnt.get(g1)); 

        // 장르별 곡 정보
        HashMap<String, List<int[]>> saveInfo = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            saveInfo.putIfAbsent(genres[i], new ArrayList<>());
            saveInfo.get(genres[i]).add(new int[]{plays[i], i});
        }

        // 곡 정렬
        for (String genre : saveInfo.keySet()) {
            saveInfo.get(genre).sort((s1, s2) -> {
                if (s2[0] != s1[0]) return s2[0] - s1[0];
                return s1[1] - s2[1]; 
            });
        }

        // 2곡씩 선택
        List<Integer> result = new ArrayList<>();
        for (String genre : sortedGenres) {
            List<int[]> songs = saveInfo.get(genre);
            int size = Math.min(2, songs.size());
            for (int i = 0; i < size; i++) {
                result.add(songs.get(i)[1]);
            }
        }

        int[] answer = result.stream().mapToInt(i -> i).toArray();
        
        return answer;
    }
}