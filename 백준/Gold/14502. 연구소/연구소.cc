#include <iostream>
#include <vector>
#include <algorithm>
#include <climits>
#include <queue>

using namespace std;

int dj[8] = { 0,-1,1,0 };
int di[8] = { -1,0,0,1 };
int total;

struct xy {
	int i;
	int j;
};



void dfs(vector<vector<int>> map, vector<int> v, vector<xy> b,vector<xy> C,int n,int m,int start) {
	if (C.size() == 3) {

		map[C[0].i][C[0].j] = 1;
		map[C[1].i][C[1].j] = 1;
		map[C[2].i][C[2].j] = 1;

		queue<xy> q;
		for (int i = 0; i < b.size(); i++)
			q.push(b[i]);

		vector<vector<int>> visit(n, vector<int>(m));
		while (q.size() != 0) {
			for (int i = 0; i < 4; i++) {
				int ni = q.front().i + di[i];
				int nj = q.front().j + dj[i];

				if (ni < 0 || ni >= n || nj < 0 || nj >= m)
					continue;
				if (map[ni][nj] == 0 && visit[ni][nj] == 0) {
					visit[ni][nj] = 1;
					map[ni][nj] = 2;
					q.push({ ni,nj });
				}
			}
			q.pop();
		}

		int cnt=0;
		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				if (map[i][j] == 0)
					cnt++;

		total = max(cnt, total);

		return;
	}
	

	for (int i = start; i < n*m; i++) {

		if (v[i] == 0) {
			C.push_back({ i / m,i % m });
			dfs(map, v, b, C, n, m, i + 1);
			C.pop_back();
		}
	}
}

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	
	int n, m;
	cin >> n >> m;
	vector<vector<int>> map(n, vector<int>(m));
	vector<int> v(n * m);
	vector<xy> b;

	int k = 0;
	for(int i=0;i<n;i++)
		for (int j = 0; j < m; j++) {
			cin >> map[i][j];
			v[k++] = map[i][j];
			if (map[i][j] == 2)
				b.push_back({ i,j });
		}

	vector<xy> C;
	dfs(map, v, b, C, n, m, 0);
	cout << total;
}
