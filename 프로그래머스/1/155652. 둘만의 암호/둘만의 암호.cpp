#include <string>
#include <vector>

using namespace std;

string solution(string s, string skip, int index) {
    string answer = "";
    
    for(auto c:s){
        int i=0;
        while(i<index){
            c +=1;
            if(c == 'z' + 1)
                c = 'a';
            
            int fail =0;
            for(auto t:skip){
                if(c==t){
                    fail = 1;
                    break;
                }
            }
            
            if(fail)
                continue;
            i++;
        }
        answer+= c;
    }
    
    return answer;
}