#include <string>
#include <vector>
#include <iostream>
using namespace std;
int Key[21][21][4];
int N;

void lotate(int index1,int index2){
    for(int i = 0;i < N; i++)
        for(int j = 0; j<N;j++)
            Key[j][N - 1 -i][index2] = Key[i][j][index1];
}
bool solution(vector<vector<int>> key, vector<vector<int>> lock) {
    bool answer = false;
    N = key.size();
    for(int i = 0; i<N;i++)
        for(int j = 0; j<N; j++)
            Key[i][j][0] = key[i][j];
    
    int m = lock.size();
    int target = 0;
    for(int i = 0;i<m;i++)
        for(int j = 0; j<m;j++)
            if(lock[i][j] == 0) target++;

    lotate(0,1);
    lotate(1,2);
    lotate(2,3);
    
    
    for(int i = -N; i< m+N; i++){
        for(int j = -N; j<m+N; j++){ //키 슬라이딩
            
            for(int mod = 0; mod<4;mod++){
                int cnt = 0;
                int flag = 0;
                for(int k = 0; k<N;k++ ){
                    for(int l = 0; l<N;l++){
                        
                        if(i+k<0 || i+k>=m || j+l<0 || j+l >= m) continue;
                        if(lock[i+k][j+l] == 0 && Key[k][l][mod] == 1) cnt++;
                        if(lock[i+k][j+l] == 1 && Key[k][l][mod] == 1){
                            flag = 1; break;
                        }
                        
                    }if(flag == 1) break;
                }
                if(flag == 0 and cnt == target) return true;
                
            }
        }
    }
    
    
    
    return answer;
}