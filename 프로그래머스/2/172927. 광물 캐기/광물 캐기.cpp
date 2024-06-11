#include <string>
#include <vector>
using namespace std;
int answer=1251;
void dfs(int a,int sum,vector<int> picks,vector<string> minerals){
    int Sum[3]={0,};
    int j=0;
    if(!picks[0]&&!picks[1]&&!picks[2]||a>=minerals.size()){
        if(sum<answer)
            answer=sum;
        return;
    }
    for(int i=a;i<a+5;i++){
        if(i>=minerals.size()){
            j=i;
            break;
        }
        if(minerals[i]=="diamond"){
            Sum[0]+=1;
            Sum[1]+=5;
            Sum[2]+=25;
        }
        else if(minerals[i]=="iron"){
            Sum[0]+=1;
            Sum[1]+=1;
            Sum[2]+=5;
        }
        else if(minerals[i]=="stone"){
            Sum[0]+=1;
            Sum[1]+=1;
            Sum[2]+=1;
        }
        j=i;
    }
    
    for(int i=0;i<3;i++){
        if(picks[i]){
            picks[i]--;
            dfs(j+1,sum+Sum[i],picks,minerals);
            picks[i]++;
        }
    }
}

int solution(vector<int> picks, vector<string> minerals) {

    dfs(0,0,picks,minerals);
    return answer;
}
