import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class p5052 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tcase = Integer.parseInt(br.readLine());

        for (int t = 0; t < tcase; t++) {
            int n = Integer.parseInt(br.readLine());
            String[] list = new String[n];
            Trie trie = new Trie();
            boolean result = true;

            for (int i = 0; i < n; i++)
                list[i] = br.readLine();

            Arrays.sort(list);  //sorting

            for (int i = 0; i < n; i++) {
                if (!trie.insert(list[i])) {
                    result = false;
                    break;
                }
            }

            System.out.println(result ? "YES" : "NO");
        }
    }
}

class Trie {
    private TrieNode root;

    Trie() {
        root = new TrieNode();
    }

    boolean insert(String key) {
        TrieNode curNode = root;
        int length = key.length();

        for (int i = 0; i < length; i++) {
            char c = key.charAt(i);
            int index = c - '0';

            if (curNode.children[index] == null) {
                curNode.children[index] = new TrieNode();
            }

            curNode = curNode.children[index];

            if (curNode.isEnd && i + 1 < length)
                return false;
        }

        curNode.isEnd = true;
        return true;
    }
}

class TrieNode {
    TrieNode[] children = new TrieNode[10];
    boolean isEnd;

    TrieNode() {
        isEnd = false;
    }
}