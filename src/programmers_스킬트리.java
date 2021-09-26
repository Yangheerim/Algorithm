package programmers;

public class programmers_스킬트리 {
    public static void main(String[] args) {
        String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};
        solution("CBD", skill_trees);

    }


    public static int solution(String skill, String[] skill_trees) {

        int cnt = 0;


        for (int i = 0; i < skill_trees.length; i++) {
            String tree = skill_trees[i];
            for (char c = 'A'; c <= 'Z'; c++) {
                if(skill.contains(c+"")) continue;
                tree = tree.replaceAll(c+"", "");
            }


            if(skill.indexOf(tree)==0) cnt++;
        }

        return cnt;
    }


}
