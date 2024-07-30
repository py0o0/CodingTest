#include <string>
#include <vector>
#include <iostream>
using namespace std;
vector<int> in;
vector<int> an;
int Max;
void dfs(vector<int> v,int n,int index, int Asco, int Bsco){
    if(index > 9){
        if(Bsco > Asco and Max <= Bsco - Asco){
            v.push_back(n);
            if(Max < Bsco - Asco){
                Max = Bsco - Asco;
                an = v;
                return;
            }
            
            if(an.size() == 0)
                an = v;
            else{
                int i = 10;
                while(v[i] == an[i])
                    i--;
                if(v[i] > an[i])
                    an = v;
            }
        }
        return;
    }
    
    if(n > in[index]){
        v.push_back(in[index] + 1);
        dfs(v, n - (in[index] + 1), index+1, Asco, Bsco + (10 - index));
        v.pop_back();
    }
 
    v.push_back(0);
        
    if(in[index] != 0)
        dfs(v, n , index+1, Asco + (10 - index), Bsco);
    else
        dfs(v, n , index+1, Asco , Bsco);
        
    v.pop_back();
    
}

vector<int> solution(int n, vector<int> info) {
    vector<int> answer;
    in = info;
    vector<int> v;
    dfs(v,n,0,0,0);
    answer = an;
    if(answer.size()==0)
        answer.push_back(-1);
    return answer;
}