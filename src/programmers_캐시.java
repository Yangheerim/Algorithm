package programmers;

// LRU 알고리즘 : 가장 오랫동안 참조되지 않은 페이지를 교체하는 기법
public class programmers_캐시 {

    public static void main(String[] args) {
        String[] cities = {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"};
        String[] cities2 = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
        solution(3, cities);
        solution(0, cities2);

    }

    public static int solution(int cacheSize, String[] cities) {

        for (int i = 0; i < cities.length; i++) { // 대소문자 구분이 없으므로 모두 소문자로 변경
            cities[i] = cities[i].toLowerCase();
        }

        String[] cache = new String[cacheSize];
        int[] cache_access_time = new int[cacheSize];

        // initialize
        for (int i = 0; i < cacheSize; i++) {
            cache[i] = "";
        }

        int time = 0;

        if(cacheSize==0){ // 캐시 용량이 0이면 예외처리
            return 5 * cities.length;
        }

        int cnt = 0;
        for (int i = 0; i < cities.length; i++) {
            String now = cities[i];
            boolean cached = false;
            // 캐시에 now가 존재하는지 확인
            for (int j = 0; j < cacheSize; j++) {
                if (cache[j].equals(now)) { // 캐시에 있으면 접근 시간 업데이트
                    time ++;
                    cache_access_time[j] = time;
                    cached = true;
                    break;
                }
            }
            if(!cached){ // 캐시 안에 now가 없으면 DB에서 가져온다 (실행시간 +5)
                time += 5;
                if(cnt<cacheSize){ // 캐시 안에 빈공간이 있으면 가장 마지막 위치에 넣는다.
                    cache[cnt] = now;
                    cache_access_time[cnt++] = time;
                }else{ // 빈 공간이 없다면 가장 오랫동안 참조되지 않은 city를 찾아 변경한다
                    int min_idx = 0;
                    int min = time;
                    for (int j = 0; j < cacheSize; j++) {
                        if(min>cache_access_time[j]){
                            min = cache_access_time[j];
                            min_idx = j;
                        }
                    }
                    cache[min_idx] = now;
                    cache_access_time[min_idx] = time;
                }
            }
        }

        return time;
    }
}
