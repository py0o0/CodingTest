#include <string>
#include <vector>
#include <sstream>
#include <iostream>
using namespace std;

struct xy{
    int x;
    int y;
    bool operator ==(xy a){
        return (x == a.x && y == a.y);
    }
};

xy link[51][51];
string map[51][51];
vector<string> solution(vector<string> commands) {
    vector<string> answer;

    for(int i = 1; i<= 50; i++)
        for(int j = 1; j<= 50; j++){
            link[i][j].x = i;
            link[i][j].y = j;
        }
    for(auto com : commands){
        string a,b,c,d,e;
        stringstream ss(com);
        
        ss >> a >> b >> c >> d >> e;
        
        if(a == "UPDATE"){
            if(d == ""){       
                for(int i = 1; i <= 50; i++)
                    for(int j = 1; j<=50; j++)
                        if(map[i][j] == b)
                            map[i][j] = c;               
            }
            else{
                int x = stoi(b);
                int y = stoi(c);
                map[x][y] = d;
                xy par = link[x][y];
                
                for(int i = 1; i<=50; i++)
                    for(int j = 1; j<=50; j++){
                        if(link[i][j] == par)
                            map[i][j] = d;
                    }
                
            }
        }
        else if(a == "MERGE"){
            int r1 = stoi(b);
            int c1 = stoi(c);
            int r2 = stoi(d);
            int c2 = stoi(e);
            
            string new_val = map[r1][c1];
            if(new_val == "")
                new_val = map[r2][c2];
            
            xy par1 = link[r1][c1];
            xy par2 = link[r2][c2];
            
            for(int i = 1; i<=50; i++)
                for(int j = 1; j<=50; j++){
                    if(link[i][j] == par2){
                        link[i][j] = par1;
                        map[i][j] = new_val;
                    }
                    else if(link[i][j] == par1)
                        map[i][j] = new_val;
                }
            
           
        }
        else if(a == "UNMERGE"){
            int x = stoi(b);
            int y = stoi(c);
            
            xy par = link[x][y];
            
            for(int i = 1; i<=50; i++)
                for(int j = 1; j<=50; j++)
                    if(par == link[i][j]){
                        link[i][j] = {i,j};
                        if(i != x || j != y)
                            map[i][j] = "";
                    }
                
            
        }
        else if(a == "PRINT"){
            int x = stoi(b);
            int y = stoi(c);
            string new_val = map[x][y];
            if(new_val == "")
                new_val = "EMPTY";
            answer.push_back(new_val);
        }
    }
    
    

    return answer;
}