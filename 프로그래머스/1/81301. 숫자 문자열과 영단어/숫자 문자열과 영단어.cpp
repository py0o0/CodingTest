#include <string>
#include <vector>

using namespace std;

int solution(string s) {
    int answer = 0;
    string str[] = {"zero","one","two","three","four","five","six","seven","eight","nine"};
    
    
    string com = "";
    for(auto c : s){
        if(isdigit(c)){
            answer = answer * 10 + c - '0';
            continue;
        }
        com += c;
        for(int i = 0; i<10;i++){
            if(com == str[i]){
                com = "";
                answer = answer * 10 + i;
                break;
            }
        }
        
        
    }
    
    return answer;
}