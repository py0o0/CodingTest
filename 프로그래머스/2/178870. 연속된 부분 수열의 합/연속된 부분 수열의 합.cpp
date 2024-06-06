#include <string>
#include <vector>
#include <climits>
using namespace std;

vector<int> solution(vector<int> sequence, int k) {
    vector<int> answer;
    int start = 0;
    int sum = 0;
    int si = 0, ei = 0;
    int dis = INT_MAX;
    for(int i=0;i<sequence.size();i++){
        sum+= sequence[i];
        if(sum == k && i-start < dis){
            si = start;
            ei = i;
            dis = ei - si;
        }
        else if(sum >k){
            while(sum > k){
                sum -= sequence[start];
                start++;
            }
            if(sum == k && i-start < dis){
            si = start;
            ei = i;
            dis = ei - si;
            }
        }
    }
    answer.push_back(si);
    answer.push_back(ei);
    return answer;
}