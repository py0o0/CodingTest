#include <string>
#include <vector>
#include <iostream>
using namespace std;

vector<int> solution(int brown, int yellow) {
    vector<int> answer;
    int a = 1;
    while(1){
        if(yellow % a == 0){
            int b = yellow / a;
            if((a + 2 + b ) * 2 == brown){
                answer.push_back(b + 2);
                answer.push_back(a + 2);
                break;
            }
        }
        a++;
    }
    return answer;
}