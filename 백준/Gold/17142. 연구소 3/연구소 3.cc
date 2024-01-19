#include <iostream>
#include <vector>
#include <algorithm>
#include <climits>
#include <queue>

using namespace std;


struct dir {
	int i;
	int j;
	int cnt;
};

int MAX = INT_MIN;
int MIN = INT_MAX;

int dx[4] = { 1,-1,0,0 };
int dy[4] = { 0,0,1,-1 };

void birus(vector<vector<int>> map, vector<dir> bi,vector<int> C,int i,int n,int k,int cmp) {
	if (C.size() == k) {
		queue<dir> q;
		for (int j = 0; j < k; j++)
			q.push({ bi[C[j]].i,bi[C[j]].j ,0 });

		vector<vector<int>> visit(n, vector<int>(n));
		int zero_cnt = 0;
		while (q.size() != 0) {
			int x = q.front().i;
			int y = q.front().j;
			int cnt = q.front().cnt;
			q.pop();
			for (int j = 0; j < 4; j++) {
				int nx = x + dx[j];
				int ny = y + dy[j];

				if (nx < 0 || nx >= n || ny < 0 || ny >= n)
					continue;

				if (visit[nx][ny] == 0) {
					visit[nx][ny] = 1;
					if (map[nx][ny] == 0) {
						map[nx][ny] = cnt + 1;
						q.push({ nx,ny,cnt + 1 });
						zero_cnt++;
						MAX = max(MAX, cnt + 1);
					}
					else if (map[nx][ny] == 2501) {
						//map[nx][ny] = cnt + 1;
						q.push({ nx,ny,cnt + 1 });
					}
				}

				if (zero_cnt == cmp)
					break;
			}
			if (zero_cnt == cmp)
				break;
		}

		int fail = 0;
		for (int j = 0; j < n; j++)
			for (int o = 0; o < n; o++)
				if (map[j][o] == 0&&visit[j][o]==0)
					fail = 1;

		if (fail == 0)
			MIN = min(MAX, MIN);
		MAX = INT_MIN;

		/*cout << "\n";
		for (int j = 0; j < n; j++) {
			for (int o = 0; o < n; o++)
				cout << map[j][o] << " ";
			cout << "\n";
		}*/

		return;
	}
	
	if (i < 0 || i >= n)
		return;

	for (int j = i; j < bi.size(); j++) {
		C.push_back(j);
		birus(map, bi, C, j + 1, n, k, cmp);
		C.pop_back();
	}
}

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int n, k;
	cin >> n >> k;
	vector<vector<int>> map(n, vector<int>(n));

	vector<dir>bi;
	int zero_cnt=0;
	for (int i = 0; i < n; i++)
		for (int j = 0; j < n; j++) {
			cin >> map[i][j];
			if (map[i][j] == 0) {
				zero_cnt++;
			}
			else if (map[i][j] == 2) {
				map[i][j] = 2501;
				bi.push_back({ i,j,0 });
			}
		}

	if (zero_cnt == 0) {
		cout << 0;
		return 0;
	}

	birus(map, bi, vector<int>(0), 0, n, k,zero_cnt);
	if (MIN != INT_MAX)
		cout << MIN;
	else
		cout << -1;
}
