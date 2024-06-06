    #include <string>
    #include <vector>

    using namespace std;

    int map[13];

    int cnt;

    bool possible(int x,int y){
        for(int i=0;i<y;i++){
            if(map[i] == x || abs(map[i] - x) == y - i)
                return false;
        }
        return true;
    }

    void dfs(int n,int a){
        if(a == n){
            cnt++;
            return;
        }
        for(int i=0;i<n;i++){
            if(possible(i,a)){
                map[a] = i;
                dfs(n,a+1);
                map[a] = 0;
            }
        }

    }

    int solution(int n) {
        int answer = 0;

        dfs(n,0);

        answer = cnt;
        return answer;
    }