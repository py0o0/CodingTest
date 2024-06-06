#include <string>
#include <vector>
#include <iostream>
using namespace std;

long long solution(int cap, int n, vector<int> deliveries, vector<int> pickups) {
    long long answer = 0;
    
    int di = 0, pi =0;
    
    for(int i=0;i<pickups.size();i++){
        if(deliveries[i] > 0)
            di = i;
        if(pickups[i] > 0)
            pi = i;
    }
    
    while(1){
        
        if(di==0 and pi == 0 and deliveries[di]==0 and pickups[pi] == 0)
            break;
        
        answer +=max(di +1,pi +1)*2;
        
        int i = 0;
        while(i<cap){
            if(di == 0 and deliveries[di]==0)
                break;
            
            deliveries[di]--;
            
            if(deliveries[di]==0){
                for(int j=di;j>-1;j--){
                    di = j;
                    if(deliveries[j]>0)
                        break;
                }
            }
            i++;
        }
        
        i = 0;
        while(i<cap){
            if(pi == 0 and pickups[pi]==0)
                break;
            
            pickups[pi]--;
            
            if(pickups[pi]==0){
                for(int j=pi;j>-1;j--){
                    pi = j;
                    if(pickups[j]>0)
                        break;
                }
            }
            i++;
        }
        
        
        
        
    }
    
    return answer;
}