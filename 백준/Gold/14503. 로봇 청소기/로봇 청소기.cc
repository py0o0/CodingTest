#include <iostream>
#include <vector>
#include <algorithm>
#include <string>
#include <cmath>
#include <climits>

using namespace std;

int dx[4] = { 0,1,0,-1 };
int dy[4] = { -1,0,1,0 };


struct cleaner {
	int x;
	int y;
	int dir;
};



int check(vector<vector<int>> map,int i,int j,int n,int m) {
	if (i < 0 || i >= n || j < 0 || j >= m)
		return 0;
	if (map[i][j] == 1||map[i][j]==2)
		return 0;
	else if (map[i][j] == 0)
		return 1;
}

void back(vector<vector<int>> map,cleaner &c,int n,int m,int &break_p) {
	int nx = c.x - dx[c.dir];
	int ny = c.y - dy[c.dir];
	if (map[ny][nx]==1) {
		break_p = 1;
		return;
	}
	c.x = nx;
	c.y = ny;
}

int main(void) {

	int n, m;
	cin >> n >> m;
	cleaner c;
	cin >> c.y >> c.x >> c.dir;

	vector<vector<int>> map(n, vector<int>(m));

	for (int i = 0; i < n; i++)
		for (int j = 0; j < m; j++)
			cin >> map[i][j];

	int cnt = 0;
	while (1) {

		if (map[c.y][c.x] == 0) {
			map[c.y][c.x] = 2;
			cnt++;
		}

		else {
			int ch_cnt = 0;
			for (int i = 0; i < 4; i++) {
				int nx = c.x + dx[i];
				int ny = c.y + dy[i];
				int ch=check(map, ny, nx, n, m);
				if (ch > 0)
					ch_cnt++;
			}

			if (ch_cnt == 0) {
				int break_p = 0;
				back(map,c, n, m, break_p);
				if (break_p == 1)
					break;
			}
			else {
				if (c.dir == 0) {
					for (c.dir = 3; c.dir > -1; c.dir--) {
						int nx = c.x + dx[c.dir];
						int ny = c.y + dy[c.dir];
						int ch = check(map, ny, nx, n, m);
						if (ch == 1) {
							c.x = nx;
							c.y = ny;
							break;
						}
					}
				}
				else if (c.dir == 3) {
					for (c.dir = 2; c.dir > -1; c.dir--) {
						int nx = c.x + dx[c.dir];
						int ny = c.y + dy[c.dir];
						int ch = check(map, ny, nx, n, m);
						if (ch == 1) {
							c.x = nx;
							c.y = ny;
							break;
						}
						if (c.dir == 0)
							c.dir = 4;
					}
				}
				else if (c.dir == 2) {
					for (c.dir = 1; c.dir > -1; c.dir--) {
						int nx = c.x + dx[c.dir];
						int ny = c.y + dy[c.dir];
						int ch = check(map, ny, nx, n, m);
						if (ch == 1) {
							c.x = nx;
							c.y = ny;
							break;
						}
						if (c.dir == 0)
							c.dir = 4;
					}
				}
				else if (c.dir == 1) {
					for (c.dir = 0; c.dir > -1; c.dir--) {
						int nx = c.x + dx[c.dir];
						int ny = c.y + dy[c.dir];
						int ch = check(map, ny, nx, n, m);
						if (ch == 1) {
							c.x = nx;
							c.y = ny;
							break;
						}
						if (c.dir == 0)
							c.dir = 4;
					}
				}
			}
		}

		/*cout << "\n";
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++)
				cout << map[i][j] << " ";
			cout << "\n";
		}
		if (c.dir == 0)
			cout << "u " << cnt << '\n';
		else if (c.dir == 1)
			cout << "r " << cnt << '\n';
		else if (c.dir == 2)
			cout << "d " << cnt << '\n';
		else if (c.dir == 3)
			cout << "L " << cnt << '\n';*/
	}
	cout << cnt;
}
