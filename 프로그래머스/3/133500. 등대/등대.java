import java.io.*;
import java.util.*;
class Solution {
    static ArrayList<Integer>[] tree;
    static int answer;
    public int solution(int n, int[][] lighthouse) {
        
        tree = new ArrayList[n + 1];
        for(int i = 0; i <= n; i++) tree[i] = new ArrayList<>();
        
        for(int i = 0; i < lighthouse.length; i++){
            int x = lighthouse[i][0];
            int y = lighthouse[i][1];
            tree[x].add(y);
            tree[y].add(x);
        }
        dfs(1, 0);
        
        return answer;
    }
    
    static int dfs(int node, int prev){
        if(tree[node].size() == 1 && tree[node].get(0) == prev) return 1; //리프 노드, 1= 나 불꺼져 있음
        
        int onLight = 0;
        for(int x : tree[node]){
            if(x == prev) continue;
            onLight += dfs(x, node);
        }
        if(onLight > 0){ //자식 노드 중 불 꺼진 놈이 존재
            answer ++;
            return 0; // 나 불켜짐
        }
        return 1; // 자식 노드 불 전부 켜져있기에 난 불끔
    }
}