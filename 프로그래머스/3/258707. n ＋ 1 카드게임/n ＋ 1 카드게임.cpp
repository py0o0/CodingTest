#include <string>
#include <vector>
#include <queue>
#include <iostream>
using namespace std;

int N;

struct ST{
    int x;
    int y;
    int need;
    bool operator()(ST a, ST b){
        return a.need > b.need;
    }
};

struct xy{
    int val;
    int need_coin;
    bool operator()(xy x, xy y){
        return x.val > y.val;
    }
};

bool go( priority_queue<xy,vector<xy>,xy> pq,int& coin,int& x,int& y){
    vector<xy> v;
    priority_queue<ST,vector<ST>,ST> st;
    while(!pq.empty()){
        v.push_back(pq.top());
        pq.pop();
    }
    int start = 0;
    int end = v.size()-1;
    while(start < end){
        int val = v[start].val + v[end].val;
        if(val < N+1)
            start++;
        else if(val > N+1)
            end--;
        else if(val == N+1){
            int need_coin = v[start].need_coin + v[end].need_coin;
            if(need_coin <= coin){
                st.push({v[start].val, v[end].val, need_coin});
            }
            start++;
        }
    }
    if(st.size() == 0) return false;
    x = st.top().x;
    y = st.top().y;
    coin -= st.top().need;
    
    return true;
}

int solution(int coin, vector<int> cards) {
    int answer = 0;
    priority_queue<xy,vector<xy>,xy> pq;
    N = cards.size();
    
    for(int i = 0; i<N/3;i++)
        pq.push({cards[i],0});
    
    int x = 0;
    int y = 0;
    for(int i = N/3;i<N;i += 2){
        answer++;
        pq.push({cards[i],1});
        pq.push({cards[i + 1],1});
        if(go(pq,coin,x,y)){
            cout<<x <<" "<<y<<" "<<coin<<"\n";
            vector<xy> v;

            while(!pq.empty()){
                xy top = pq.top();
                if(top.val != x && top.val !=y)
                    v.push_back(top);
                pq.pop();
            }
            for(int i = 0; i<v.size();i++)
                pq.push(v[i]);
            if(i == N-2)
                answer++;
            continue;
        }
        break;
    }
  
    
    return answer;
}