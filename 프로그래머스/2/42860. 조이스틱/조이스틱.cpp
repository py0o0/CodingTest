#include <string>
#include <vector>

using namespace std;

int solution(string name) {
    int answer = 0;
    int array[] = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,12,11,10,9,8,7,6,5,4,3,2,1};
    
    for(auto c: name)
        answer += array[c - 'A'];
    
    int move = name.size()-1;
    int n = name.size();
    
    for(int i=0;i<name.size();i++){
        
        int j= i+1;
        while(j<name.size() and name[j] == 'A')
            j++;
        
        move = min(move,min(i + i + n-j , n-j + n-j + i));
    }
    
    answer += move;
    
    return answer;
}