#include <iostream>
#include <stack>

using namespace std;

int main(void) {
    int answer;
    stack<char> stck;
    int n;
    cin>>n;
    cin.ignore();
    for(int t=0;t<n;t++){
        string a;
        getline(cin,a);
        
        for(auto c:a){
            if(c == ' '){
                while(stck.size() != 0){
                    cout<<stck.top();
                    stck.pop();
                }
                cout<<" ";
                continue;
            }
            stck.push(c);
        }
        while(stck.size() != 0){
            cout<<stck.top();
            stck.pop();
        }
        cout<<"\n";
   
        
    }
    return 0;
}