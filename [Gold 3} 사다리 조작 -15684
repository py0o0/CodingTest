#include <iostream>
#include <vector>
#include <algorithm>
#include <climits>
#include <queue>

using namespace std;

int total = INT_MAX;
int cmp = 4;

int map[31][11];

struct xy {
	int s;
	int h;
};

int check(int n,int h) {
	for (int i = 0; i < n; i++) {
		int a = i;
		for (int j = 0; j < h; j++) {
			if (map[j][a] == 1)
				a++;

			else if (map[j][a] == 2)
				a--;
		}
		if (a != i) {
			return 0;
		}
	}
	return 1;
}

void pro_lad(vector<xy> v, int n, int h, int start, int cnt) {
	if (cnt >= cmp)             //cmp
		return;

	if (check(n, h)) {
		total = min(total, cnt);
		cmp = cnt;
		return;
	}
	
	for (int i = start; i < v.size(); i++) {
		if (map[v[i].h][v[i].s] == 0) {
			map[v[i].h][v[i].s] = 1;
			map[v[i].h][v[i].s + 1] = 2;

			pro_lad(v, n, h, i + 1, cnt + 1);

			map[v[i].h][v[i].s] = 0;
			map[v[i].h][v[i].s + 1] = 0;

			if (cnt >= cmp - 1)
				return;
		}
	}

}


int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	
	int n, k, h;
	cin >> n >> k >> h;

	for (int i = 0; i < k; i++) {
		int a, b;
		cin >> a >> b;
		map[a - 1][b - 1] = 1;
		map[a - 1][b ]= 2;
		
	}

	vector<xy> v;

	for (int i = 0; i < h; i++) {
		for (int j = 0; j < n - 1; j++)
			if (map[i][j] == 0) {
				if (map[i][j + 1] == 0)
					v.push_back({ j ,i });

			}
	}

	if (v.size() == 0) {
		if (check( n, h)) {
			cout << "0";
			return 0;
		}
		cout << "-1";
		return 0;
	}

	vector<int> an;
	pro_lad(v, n, h, 0, 0);

	if (total == INT_MAX)
		cout << -1;
	else
		cout << total;
}
