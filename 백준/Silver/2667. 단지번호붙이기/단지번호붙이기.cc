#include <iostream>
#include <algorithm>
using namespace std;

int visit[26][26];
int cnt;
int dx[] = {1,-1,0,0};
int dy[] = {0,0,1,-1};

void dfs(vector<string> v, int i, int j){
    if(i<0 or i>= v.size() or j<0 or j>= v[0].size())
        return;
    if(visit[i][j] or v[i][j] == '0')
        return;
    
    visit[i][j] = 1;
    cnt++;
    
    for(int k=0;k<4;k++)
        dfs(v, i + dx[k], j+dy[k]);
}

int main(void) {
    
    int n;
    cin>>n;
    vector<string> v(n);
    
    for(int i=0;i<n;i++)
        cin>>v[i];
    
    vector<int> an;
    for(int i=0;i<n;i++)
        for(int j=0;j<n;j++){
            if(!visit[i][j] and v[i][j] == '1'){
                cnt = 0;
                dfs(v,i ,j);
                an.push_back(cnt);
            }
        }
    
    cout<<an.size()<<"\n";
    
    sort(an.begin(),an.end());
    
    for(auto c:an)
        cout<<c<<"\n";
    
    return 0;
}