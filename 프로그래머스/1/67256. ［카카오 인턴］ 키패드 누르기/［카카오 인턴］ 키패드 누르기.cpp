#include <string>
#include <vector>
#include <cmath>
using namespace std;
struct xy{
    int x;
    int y;
};
int cal(xy a, xy b){
    return abs(a.x - b.x) + abs(a.y - b.y);
}

xy map[10] = {{3,1},{0,0},{0,1},{0,2},{1,0},{1,1},{1,2},{2,0},{2,1},{2,2}};
string solution(vector<int> numbers, string hand) {
    string answer = "";
    xy left = {3,0};
    xy right = {3,2};
    
    for(auto n:numbers){
        if(n == 1|| n== 4|| n==7){
            left = map[n];
            answer += 'L';
        }
        else if(n == 3|| n== 6|| n==9){
            right = map[n];
            answer += 'R';
        }
        else{
            int left_dis = cal(left,map[n]);
            int right_dis = cal(right,map[n]);
            
            if(left_dis < right_dis){
                left = map[n];
                answer += 'L';
            }
            else if(left_dis > right_dis){
                right = map[n];
                answer += 'R';
            }
            else{
                if(hand == "right"){
                    right = map[n];
                    answer += 'R';
                }
                else{
                    left = map[n];
                    answer += 'L';
                }
            }
            
        }
    }
    
    return answer;
}