import java.util.ArrayList;

public class sol1 {

    public static void main(String[] args) {
        int[] gift_cards = {4, 5, 3, 2, 1};
        int[] wants = {2, 4, 4, 5, 1};

        solution(gift_cards,wants);
    }

    public static int solution(int[] gift_cards, int[] wants) {

        ArrayList<Integer> gift_cards_list = new ArrayList<>();
        ArrayList<Integer> wants_list = new ArrayList<>();

        for(int i=0; i<gift_cards.length; i++){
            if(gift_cards[i]!=wants[i]){
                gift_cards_list.add(gift_cards[i]);
                wants_list.add(wants[i]);
            }
        }


        int n = wants_list.size();
        for(int i=0; i<wants_list.size(); i++){
            if(gift_cards_list.contains(wants_list.get(i))){
                gift_cards_list.remove(wants_list.get(i));
                n--;
            }
        }

        System.out.println(n);
        return n;
    }


}
