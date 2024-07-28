#include <string>
#include <vector>
#include <algorithm>
#include <iostream>
using namespace std;
int cols;
bool cmp(vector<int> a,vector<int> b){
    if(a[cols]<b[cols])
        return true;
    if(a[cols]==b[cols]){
        if(a[0]>b[0])
            return true;
    }
    return false;
}

int solution(vector<vector<int>> data, int col, int row_begin, int row_end) {
    int answer = 0;
    
    cols=col-1;
    sort(data.begin(),data.end(),cmp);
    
    int flag=0;
    int bn;
    for(int i=row_begin-1;i<row_end;i++){
        int an=0;
        for(int j=0;j<data[0].size();j++)
            an+=(data[i][j]%(i+1));
        if(flag==0)
            bn=an;
        else{
            answer=an^bn;
            bn=answer;
        }
        flag=1;
    }
    
    
    return answer;
}