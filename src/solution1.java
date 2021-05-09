import java.util.ArrayList;
import java.util.Collections;

public class solution1 {
    public static void main(String[] args) {

    }

    static class Stock{
        int price;
        int time;

        public Stock(int price, int time) {
            this.price = price;
            this.time = time;
        }
    }

    public int[] solution(String code, String day, String[] data) {


        ArrayList<Stock> prices = new ArrayList<>();

        for(int i=0; i<data.length; i++){
            String[] info = data[i].split(" ");
            String info_code = info[1].split("=")[1];
            String info_time = info[2].split("=")[1];
            System.out.println(info_code+", "+info_time);
            if (info_code.equals(code) && info_time.substring(0, 8).equals(day)) {
                prices.add(new Stock(Integer.parseInt(info[0].split("=")[1]), Integer.parseInt(info_time)));
            }
        }
        Collections.sort(prices, (p1, p2)->Integer.compare(p1.time, p2.time));
        int[] answer = new int[prices.size()];
        for(int i=0; i<prices.size(); i++){
            answer[i] = prices.get(i).price;
        }
        return answer;
    }


}
