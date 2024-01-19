#include <iostream>
#include <vector>
#include <algorithm>
#include <climits>
#include <queue>

using namespace std;

struct xy {
	int i;
	int j;
};

int map[50][50];
int total = INT_MAX;

int ans(int n) {
	if (n >= 0)
		return n;
	return -n;
}

void piz(vector<xy> v,vector<int> c,int n,int m,int start) {
	if (c.size() > m)
		return;

	if (c.size() == m) {
		int score = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == 1) {
					int dis = INT_MAX;
					for (int k = 0; k < m; k++) {
						int sum = ans(v[c[k]].i - i) + ans(v[c[k]].j - j);
						dis = min(sum, dis);
					}
					score += dis;
				}
			}
		}

		total = min(score, total);

		return;
	}


	for (int i = start; i < v.size(); i++) {
		c.push_back(i);
		piz(v, c, n, m, i + 1);
		c.pop_back();
	}
}

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	
	int n, m;
	cin >> n >> m;

	vector<xy> v;
	
	for(int i=0;i<n;i++)
		for (int j = 0; j < n; j++) {
			cin >> map[i][j];
			if (map[i][j] == 2)
				v.push_back({ i,j });
		}
	
	vector<int> c;
	piz(v, c, n, m, 0);
	cout << total;	
	
}
