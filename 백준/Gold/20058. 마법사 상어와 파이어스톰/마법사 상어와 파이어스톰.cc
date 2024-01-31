#include <iostream>
#include <vector>
#include <algorithm>
#include <climits>
#include <queue>
#include <cstring>

using namespace std;

int map[64][64];
int visit[64][64];
int decrea[64][64];
int dx[] = { 0,0,-1,1 };
int dy[] = { 1,-1,0,0 };
int Max;
	
struct tone {
	int x;
	int y;
	int dir;
};

void lotate(int x, int y, int l) {
	int temp[64][64] = { 0 };
	int sizeX = x + l;
	int sizeY = y + l;
	int ii = 0;
	int jj = 0;
	for (int i = x; i < sizeX; i++) {
		for (int j = y; j < sizeY; j++) {
			visit[i][j] = 1;
			temp[jj][l - 1 - ii] = map[i][j];
			jj++;
		}
		ii++;
		jj = 0;
	}


	ii = 0; jj = 0;
	for (int i = x; i < sizeX; i++) {
		for (int j = y; j < sizeY; j++) {
			map[i][j] = temp[ii][jj];
			jj++;
		}
		ii++; jj = 0;
	}
}

void dfs(int i, int j, int n,int &cnt) {
	if (i < 0 || i >= n || j < 0 || j >= n)
		return;
	if (visit[i][j] == 1)
		return;
	visit[i][j] == 1;
	if (map[i][j] == 0)
		return;
	cnt++;
	visit[i][j] = 1;
	for (int k = 0; k < 4; k++) {
		dfs(i + dx[k], j + dy[k], n, cnt);
	}

}

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int m, q;
	cin >> m >> q;
	int n = 1;
	for (int i = 0; i < m; i++)
		n *= 2;

	for (int i = 0; i < n; i++)
		for (int j = 0; j < n; j++)
			cin >> map[i][j];

	vector<int> v;
	for (int i = 0; i < q; i++) {
		int a;
		cin >> a;
		int l = 1;
		for (int j = 0; j < a; j++)
			l *= 2;
		v.push_back(l);
	}

	for (int o = 0; o < q; o++) {
		for (int i = 0; i < n; i++) {
			memset(visit[i], 0, sizeof(int) * n);
			memset(decrea[i], 0, sizeof(int) * n);
		}

		for (int i = 0; i < n; i++)                   //얼음 회전
			for (int j = 0; j < n; j++) {
				if (visit[i][j] == 1)
					continue;
				lotate(i, j, v[o]);
			}

	

		for (int i = 0; i < n; i++)                   //인근 확인 후 감소
			for (int j = 0; j < n; j++) {
				int cnt = 0;
				for (int k = 0; k < 4; k++) {
					int nx = i + dx[k];
					int ny = j + dy[k];
					if (nx < 0 || nx >= n || ny < 0 || ny >= n)
						continue;
					if (map[nx][ny] > 0)
						cnt++;
				}

				if (cnt < 3)
					if (map[i][j] != 0)
						decrea[i][j] = map[i][j] - 1;
					else  decrea[i][j] = map[i][j];
				else
					decrea[i][j] = map[i][j];
			}

		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				map[i][j] = decrea[i][j];

		

	}

	for (int i = 0; i < n; i++)
		memset(visit[i], 0, sizeof(int) * n);

	int sum = 0;
	for (int i = 0; i < n; i++)
		for (int j = 0; j < n; j++)
			sum += map[i][j];

	for (int i = 0; i < n; i++)
		for (int j = 0; j < n; j++) {
			if (visit[i][j] == 1)
				continue;
			if (map[i][j] == 0)
				continue;
			int cnt = 0;
			dfs(i, j,n, cnt);
			Max = max(cnt, Max);
		}

	/*cout << "\n";
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++)
			cout << map[i][j] << " ";
		cout << "\n";
	}*/

	cout << sum << " " << Max;

}
