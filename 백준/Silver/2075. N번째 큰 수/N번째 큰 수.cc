#include <iostream>
#include <string>
#include <queue>
using namespace std;

struct cmp {
    bool operator()(int n1, int n2) {
        return n1 > n2;
    }
};

int main(void) {

    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;
    cin >> n;

    priority_queue<int, vector<int>, cmp> pq;


    for (int i = 0; i < n * n; i++) {
        int x;
        cin >> x;

        if(pq.size() < n)
            pq.push(x);
        else {
            if (pq.top() < x) {
                pq.pop();
                pq.push(x);
            }
        }
    }


    cout << pq.top() << "\n";
}

