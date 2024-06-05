#include <string>
#include <vector>
#include <climits>
#include <iostream>
using namespace std;

string solution(string number, int k) {
    string answer = "";
    
    int index = 0;
    for(int i=0;i<number.size();i++){
        int Max = INT_MIN;
        
        int max_cur = index;
        for(int j = index; j < index + k + 1; j++){
            if(Max < number[j] ){
                Max = number[j];
                max_cur = j;
            }
        }
        
        cout<<max_cur<<"\n";
        
        answer += number[max_cur];
        
        k = k - (max_cur - index);
        index = max_cur+1;
        i = max_cur;
        
        int remain = number.size() - index;
        
        if(k==0){
            for(int j=index;j<number.size();j++)
                answer += number[j];
            break;
        }
        else if(remain == k)
            break;
        
    }
    
    return answer;
}