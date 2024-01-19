#include <iostream>
#include <vector>
#include <algorithm>
#include <climits>
#include <queue>

using namespace std;

int total;

int ans(int n) {
	if (n > 0)
		return n;
	else if (n == 0)
		return 0;
	return -n;
}

void row(vector<vector<int>> map,int n,int l,int x) {
	int fail = 0;
	int cnt = 0;
	int a = map[x][0];
	for (int j = 0; j < n; j++) {
		if (ans(a - map[x][j]) > 1) {
			fail = 1;
			break;
		}
		else if (map[x][j] != a) {
			if (map[x][j] < a) {

				int b = map[x][j];
				int size = j + l;
				for (int i = j; i < size; i++) {
					if (i >= n) {
						fail = 1;
						break;
					}
					if (map[x][i] != b) {
						fail = 1;
						break;
					}
					j = i;
				}
				if (fail == 1)
					break;
				cnt = -1;
				a = b;

			}
			else {
				if (cnt < l) {
					fail = 1;
					break;
				}

				a = map[x][j];
				cnt = 0;
			}
		}
		cnt++;
	}
	if (fail == 0)
		total++;

	else
		return;
}

void col(vector<vector<int>> map, int n, int l, int x) {
	int fail = 0;
	int cnt = 0;
	int a = map[0][x];
	for (int j = 0; j < n; j++) {
		if (ans(a - map[j][x]) > 1) {
			fail = 1;
			break;
		}
		else if (map[j][x] != a) {
			if (map[j][x] < a) {

				int b = map[j][x];
				int size = j + l;
				for (int i = j; i < size; i++) {
					if (i >= n) {
						fail = 1;
						break;
					}
					if (map[i][x] != b) {
						fail = 1;
						break;
					}
					j = i;
				}

				if (fail == 1)
					break;
				a = b;
				cnt = -1;

			}
			else {
				if (cnt < l) {
					fail = 1;
					break;
				}

				a = map[j][x];
				cnt = 0;
			}
		}
		cnt++;
	}
	if (fail == 0)
		total++;

}

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	
	int n, l;
	cin >> n >> l;
	vector<vector<int>> map(n, vector<int>(n));

	int k = 0;
	for (int i = 0; i < n; i++)
		for (int j = 0; j < n; j++)
			cin >> map[i][j];
			

	for(int i=0;i<n;i++){
		row(map,n,l,i);
		col(map,n,l,i);
	}

	cout << total;
}
