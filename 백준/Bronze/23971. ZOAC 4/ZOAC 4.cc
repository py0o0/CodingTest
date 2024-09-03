#include <iostream>

using namespace std;
int main(void){
    int h,w,n,m;
    
    cin>>h>>w>>n>>m;
    
    n++,m++;

    int wi = w/m;
    if(w%m!=0)
        wi++;

    int le = h/n;
    if(h%n!=0)
        le++;

    cout<<wi*le<<"\n";
} 