class Solution {
    static int N;
    static int[][] v;
    static int[] an;
    static int[] a;
    static int answer;
    public int solution(int n, int[][] q, int[] ans) {
        N = n;
        v = q;
        an = ans;
        
        a = new int[5];
        com(0, 0);
        return answer;
    }
    static void com(int x, int size){
        if(size == 5){
            if(check()) answer++;
            return;
        }
        for(int i = x + 1; i <= N; i++){
            a[size] = i;
            com(i, size + 1);
        }
        
    }
    static boolean check(){
        for(int i = 0; i < v.length; i++){
            int index1 = 0;
            int index2 = 0;
            int cnt = 0;
            while(index1 < 5 && index2 < 5){
                if(a[index1] == v[i][index2]){
                    cnt++;
                    index1++; index2++;
                }
                else if(a[index1] > v[i][index2])
                    index2++;
                else index1++;
            }
            if(cnt != an[i]) return false;
        }
        return true;
    }
    
}