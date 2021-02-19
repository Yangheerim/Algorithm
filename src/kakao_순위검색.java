import java.util.ArrayList;

public class kakao_순위검색 {
    static class Applicant{
        String language;
        String job;
        String career;
        String food;
        int score;
        boolean pass;

        public Applicant(String language, String job, String career, String food, int score) {
            this.language = language;
            this.job = job;
            this.career = career;
            this.food = food;
            this.score = score;
            pass=true;
        }
    }
    public static void main(String[] args) {
        String[] info = {"java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
        int[] answers = solution(info, query);
        for (int i = 0; i < answers.length; i++) {
            System.out.println(answers[i]);
        }
    }

    public static int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        ArrayList<Applicant> applicants = new ArrayList<>();

        for(int i=0; i<info.length; i++){
            String[] now_info = info[i].split(" ");
            applicants.add(new Applicant(now_info[0], now_info[1], now_info[2], now_info[3], Integer.parseInt(now_info[4])));
        }

        for(int i=0; i<query.length; i++){
            String q = query[i].replaceAll(" and", "");
            String[] now_query = q.split(" ");
            // 쿼리의 각 항목에 맞는 지원자 찾기 - pass가 true이면 합격
            for(int j=0; j<5; j++) {
                for (int a = 0; a < applicants.size(); a++) { // applicants

                    if(!applicants.get(a).pass) continue;
                    switch (j){
                        case 0:
                            if(now_query[0].equals("-")) break;
                            if(!applicants.get(a).language.equals(now_query[0])){
                                applicants.get(a).pass = false;
                            }
                            break;
                        case 1:
                            if(now_query[1].equals("-")) break;
                            if(!applicants.get(a).job.equals(now_query[1])){
                                applicants.get(a).pass = false;
                            }
                            break;
                        case 2:
                            if(now_query[2].equals("-")) break;
                            if(!applicants.get(a).career.equals(now_query[2])){
                                applicants.get(a).pass = false;
                            }
                            break;
                        case 3:
                            if(now_query[3].equals("-")) break;
                            if(!applicants.get(a).food.equals(now_query[3])){
                                applicants.get(a).pass = false;
                            }
                            break;
                        case 4:
                            if(Integer.parseInt(String.valueOf(applicants.get(a).score))<Integer.parseInt(now_query[4])){
                                applicants.get(a).pass = false;
                            }
                            break;
                    }
                }
            }
            // 적합한 지원자의 수 찾기
            int count = 0;
            for(int j=0; j<applicants.size(); j++){
                if(applicants.get(j).pass) count ++;
            }
            answer[i] = count;

            // 지원자 합격여부 초기화
            for(int j=0; j<applicants.size(); j++){
                applicants.get(j).pass=true;
            }
        }
        return answer;
    }
}
