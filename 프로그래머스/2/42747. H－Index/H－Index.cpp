#include <string>
#include <vector>
using namespace std;

int solution(vector<int> citations) {
    int answer = 0;
    int index = 0;
    while(index <= 10000){
        int co = 0, nco = 0;
        for(int j=0;j<citations.size();j++){
            if(index <= citations[j])
                co++;
            else
                nco++;
        }
        if(co >= index and nco <= index)
            answer = index;
        else
            break;
        
        index++;
    }
    
    return answer;
}