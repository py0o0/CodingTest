#include <iostream>
#include <vector>
#include <algorithm>
#include <climits>
#include <queue>
#include <cstring>
#include <stack>
using namespace std;

struct cmp1 {
	bool operator()(int& n1, int& n2) {
		return n1 < n2;
	}
};
struct cmp2 {
	bool operator()(int& n1, int& n2) {
		return n1 > n2;
	}
};

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	priority_queue<int ,vector<int>, cmp1> sq;        //오름차
	priority_queue<int, vector<int>, cmp2> bq;        //내립차

	int n;
	cin >> n;
	for (int i = 1; i <= n; i++) {
		int a;
		cin >> a;
		if (bq.size() == 0)
			bq.push(a);
		else {
			if (bq.top() <= a) {
				bq.push(a);
			}
			else {
				sq.push(a);
			}
		}

		//bq의 size는 항상 i/2 +1

		if (bq.size() < i / 2 + 1) {                   //홀수 
			while (bq.size()!= i / 2 + 1) {
				bq.push(sq.top());
				sq.pop();
			}
		}
		else {
			while (bq.size() != i / 2 + 1) {
				sq.push(bq.top());
				bq.pop();
			}
		}

		cout << bq.top() << "\n";

	}
	
	return 0;
}
