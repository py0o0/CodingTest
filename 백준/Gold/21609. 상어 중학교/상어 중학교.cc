#include <iostream>
#include <vector>
#include <algorithm>
#include <string>
#include <cmath>
#include <climits>

using namespace std;

int visit[21][21];

struct magic {
	vector<pair<int,int>> rain;
	int cnt;
	int rain_cnt;
	int i;
	int j;

};

void dfs(vector<vector<int>> map,magic& v,int i,int j,int n,int num) {
	if (i < 0 || i >= n || j < 0 || j >= n)
		return;
	if (visit[i][j] == 1)
		return;
	if (map[i][j] == num || map[i][j] == 0) {
		visit[i][j] = 1;
		v.cnt++;
		if (map[i][j] == 0) {
			v.rain_cnt++;
			v.rain.push_back(make_pair(i, j));
		}
		dfs(map, v, i + 1, j, n, num);
		dfs(map, v, i - 1, j, n, num);
		dfs(map, v, i, j + 1, n, num);
		dfs(map, v, i, j - 1, n, num);
	}


}

bool cmp(magic& n1, magic& n2) {
	if (n1.cnt == n2.cnt) {
		if (n1.rain_cnt == n2.rain_cnt) {
			if (n1.i == n2.i)
				return n1.j > n2.j;
			else
				return n1.i > n2.i;
		}
		else
			return n1.rain_cnt > n2.rain_cnt;
	}
	else
		return n1.cnt > n2.cnt;
}

void dfs_boom(vector<vector<int>>& map,int i, int j, int n, int num) {
	if (i < 0 || i >= n || j < 0 || j >= n)
		return;
	if (visit[i][j] == 1)
		return;
	if (map[i][j] == num || map[i][j] == 0) {
		visit[i][j] = 1;
		map[i][j] = -2;
		dfs_boom(map, i + 1, j, n, num);
		dfs_boom(map, i - 1, j, n, num);
		dfs_boom(map, i, j + 1, n, num);
		dfs_boom(map, i, j - 1, n, num);
	}
}

void gravity(vector<vector<int>>& map,int n) {
	for (int i = 0; i < n - 1; i++) {
		for (int j = 0; j < n; j++) {
			if (map[i + 1][j] == -2 && map[i][j] != -1) {
				swap(map[i + 1][j], map[i][j]);
				for (int k = i; k > 0; k--) {
					if (map[k - 1][j] == -1)
						break;
					swap(map[k][j], map[k - 1][j]);
				}
			}
		}
	}
}

void ro(vector<vector<int>>& map, int n) {
	vector<vector<int>> temp(n, vector<int>(n));
	for (int i = 0; i < n; i++)
		for (int j = 0; j < n; j++)
			temp[n - 1 - j][i] = map[i][j];

	for (int i = 0; i < n; i++)
		for (int j = 0; j < n; j++)
			map[i][j] = temp[i][j];
}

int main(void) {
	int n, value;
	cin >> n >> value;
	vector<vector<int>> map(n, vector<int>(n));
	for (int i = 0; i < n; i++)
		for (int j = 0; j < n; j++)
			cin >> map[i][j];

	vector<magic> v;

	int k = 0;
	int score = 0;
	while (1) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (visit[i][j] == 0 && map[i][j] != 0 && map[i][j] != -1 && map[i][j] != -2) {
					v.push_back({ {},0,0,i,j });
					dfs(map, v[k], i, j, n, map[i][j]);
					
					for (int o = 0; o < v[k].rain.size(); o++) {
						visit[v[k].rain[o].first][v[k].rain[o].second] = 0;
					}
					k++;
				}
			}
		}

		if (v.size() == 0)
			break;

		sort(v.begin(), v.end(), cmp);

		if (v[0].cnt < 2)
			break;

		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				visit[i][j] = 0;

		score += v[0].cnt * v[0].cnt;

		dfs_boom(map,v[0].i,v[0].j,n,map[v[0].i][v[0].j]);

		v.clear();
		k = 0;
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				visit[i][j] = 0;

		gravity(map, n);

		ro(map, n);

		gravity(map, n);

		/*for (int i = 0; i < v.size(); i++) {
			cout << v[i].cnt << "\n";
		}*/

		/*cout << "\n";
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == -2)
					cout << "9 ";
				else if (map[i][j] == -1)
					cout << "8 ";
				else
					cout << map[i][j] << " ";
			}
			cout << "\n";
		}*/
		

	}
	cout << score;
}
