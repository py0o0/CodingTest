#include <iostream>
#include <vector>
#include <algorithm>
#include <string>
#include <cmath>
#include <climits>

using namespace std;

int MAX, MIN;

void dfs(vector<int> v, vector<char> Oper,vector<int> sq, vector<int> ch,int n) {
	if (sq.size() == n - 1) {
		int sum = v[0];
		int j = 1;
		for (int i = 0; i < sq.size(); i++,j++) {
			if (Oper[sq[i]] == '+') {
				sum += v[j];
			}
			else if (Oper[sq[i]] == '-') {
				sum -= v[j];
			}
			else if (Oper[sq[i]] == '*') {
				sum *= v[j];
			}
			else if (Oper[sq[i]] == '/') {
				sum /= v[j];
			}

		}

		MAX = max(sum, MAX);
		MIN = min(sum, MIN);
		return;
	}

	for (int i = 1; i < n; i++) {
		if (ch[i] == 0) {
			ch[i] = 1;
			sq.push_back(i);
			dfs(v, Oper, sq, ch, n);
			ch[i] = 0;
			sq.pop_back();
		}
	}
}

int main(void) {

	int n;
	cin >> n;
	vector<int> v(n);
	for (int i = 0; i < n; i++)
		cin >> v[i];

	vector<char> Oper;
	Oper.push_back('0');
	for (int i = 1; i < 5; i++) {
		int m;
		cin >> m;
		for (int j = 0; j < m; j++) {
			if (i == 1)
				Oper.push_back('+');
			else if (i == 2)
				Oper.push_back('-');
			else if (i == 3)
				Oper.push_back('*');
			else if (i == 4)
				Oper.push_back('/');
		}
	}
	MAX = INT_MIN;
	MIN = INT_MAX;

	vector<int> sq;
	vector<int> ch(n);
	dfs(v, Oper, sq, ch, n);

	cout << MAX << "\n" << MIN;

}
