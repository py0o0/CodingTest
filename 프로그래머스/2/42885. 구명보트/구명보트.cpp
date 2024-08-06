#include <string>
#include <vector>
#include <algorithm>
using namespace std;

bool cmp(int a,int b){
    return a>b;
}

int solution(vector<int> people, int limit) {
    int answer = 0;
    sort(people.begin(),people.end(),cmp);
    int start = 0, end = people.size()-1;
    while(start <= end){
        if(people[start] + people[end] <=limit)
            start++,end--;
        else if(people[start] + people[end] >limit)
            start++;
        answer++;
    }
        
    
    return answer;
}