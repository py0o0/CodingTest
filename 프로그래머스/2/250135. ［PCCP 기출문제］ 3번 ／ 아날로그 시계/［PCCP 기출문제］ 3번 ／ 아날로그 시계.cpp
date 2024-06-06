#include <string>
#include <vector>
#include <iostream>
using namespace std;

struct Time{
    double h;
    double m;
    double s;
    
    Time(int n){
        h = n/3600 % 12;
        m = n%3600/60;
        s = n%60;
        
        h = h* 30.0 + m* (30.0 / 60.0) + s* (30.0/ 3600.0);
        m = m * 6.0 + s * 0.1 ;
        s = s * 6.0;
    }
};

bool mi(Time t1, Time t2){
    if(t1.s < t1.m and t2.s >= t2.m or t1.s == 354 and t1.m > 354)
        return true;
    return false;
}

bool ho(Time t1, Time t2){
    if(t1.s < t1.h and t2.s >= t2.h or t1.s == 354 and t1.h > 354)
        return true;
    return false;
}


int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
    int answer = 0;
    
    int st = h1 * 3600 + m1 *60 +s1;
    int et = h2 * 3600 + m2 *60 +s2;
    
    Time t(st);
    if(t.s == t.m or t.s == t.h)
        answer++;
    
    
    for(int i=st;i<et;i++){
        Time t1(i);
        Time t2(i + 1);
        
        if(mi(t1,t2) and ho(t1,t2)){
            if(t2.m == t2.h)
                answer ++;
            else
                answer +=2;
        }
        else if(mi(t1,t2) or ho(t1,t2))
            answer++;
    }
    
    
    return answer;
}