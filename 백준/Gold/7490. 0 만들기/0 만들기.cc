#include <iostream>
#include <string>
using namespace std;

bool zero(string s) {
    int sum = 0;
    int cur = 0;
    char c = '+';

    for (int i = 0; i < s.size(); i++) {
        if (isdigit(s[i]))
            cur = cur * 10 + (s[i] - '0');
        else if (s[i] == '+' or s[i] == '-') {
            if (c == '+')
                sum += cur;
            else if (c == '-')
                sum -= cur;

            if (s[i] == '+')
                c = '+';
            else if (s[i] == '-')
                c = '-';
            cur = 0;
        }

    }
    if (c == '+')
        sum += cur;
    else if (c == '-')
        sum -= cur;
    
    return (sum == 0);
}

char cal[3] = {' ' ,'+', '-'};
void dfs(int n, int cur, string s) {

    s += cur + '0';

    if (n <= cur) {
        if (zero(s))
            cout << s << "\n";
        return;
    }

    for (int i = 0; i < 3; i++) 
        dfs(n, cur + 1, s + cal[i]);

    
}


int main(void) {
    int t;
    cin >> t;
    while (t-- > 0) {
        int n;
        cin >> n;
        string s;
        dfs(n, 1, s);
        cout << "\n";
    }

}

