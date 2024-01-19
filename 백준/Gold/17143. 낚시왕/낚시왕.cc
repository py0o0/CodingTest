#include <iostream>
#include <vector>
#include <algorithm>
#include <string>
#include <cmath>
#include <climits>

using namespace std;

struct shark {
	int x;
	int y;
	int Size;
	int dir;
	int speed;
};

int score;

int dx[5] = { 0,0,0,1,-1 };
int dy[5] = { 0,-1,1,0,0 };

void fishing(vector<vector<int>> &map, vector<shark> &v,int i,int n) {

	for (int j = 1; j <= n; j++) {
		if (map[j][i] > 0) {
			score += v[map[j][i]].Size;
			v[map[j][i]].Size = -1;
			break;
		}
	}
}

void update(vector<vector<int>>& map, vector<shark>& v, int m, int r, int c) {

	for (int k = 0; k <= r; k++)
		for (int j = 0; j <= c; j++)
			map[k][j] = 0;

	for (int i = 1; i <= m; i++) 
		if (v[i].Size > 0)
			map[v[i].y][v[i].x] = i;
	
}

void moving(vector<vector<int>>& map, vector<shark>& v, int m,int r, int c) {
	for (int i = 1; i <= m; i++) {
		if (v[i].Size > 0 && v[i].speed>0) {
			if (map[v[i].y][v[i].x] == i)
				map[v[i].y][v[i].x] = 0;

			int nx = v[i].x + dx[v[i].dir];
			int ny = v[i].y + dy[v[i].dir];

			if (nx < 1)
				nx = 2, v[i].dir = 3;
			else if (nx > c)
				nx = c - 1, v[i].dir = 4;
			else if (ny < 1)
				ny = 2, v[i].dir = 2;
			else if (ny > r)
				ny = r - 1, v[i].dir = 1;

			int end = 0;
			if (v[i].dir == 3 || v[i].dir == 4) 
				end = (v[i].speed-1) % ((c - 1) * 2);
			
			else if(v[i].dir == 1 || v[i].dir == 2)
				end = (v[i].speed-1) % ((r - 1) * 2);

			for (int j = 0; j < end; j++) {

				nx = nx + dx[v[i].dir];
				ny = ny + dy[v[i].dir];

				if (nx < 1)
					nx = 2, v[i].dir = 3;
				else if (nx > c)
					nx = c - 1, v[i].dir = 4;
				else if (ny < 1)
					ny = 2, v[i].dir = 2;
				else if (ny > r)
					ny = r - 1, v[i].dir = 1;

			}


			int lose = 0;
			v[i].x = nx;
			v[i].y = ny;
			if (map[ny][nx] > 0 && v[map[ny][nx]].Size < v[i].Size && map[ny][nx] < i)
				v[map[ny][nx]].Size = -1;
			else if (map[ny][nx] > 0 && v[map[ny][nx]].Size > v[i].Size && map[ny][nx] < i) {
				v[i].Size = -1;
				lose = 1;
			}
			if (lose == 0)
				map[ny][nx] = i;
			
		}

		else if (v[i].speed == 0) {
			if (map[v[i].y][v[i].x] != i) {
				int lose = 0;
				if (v[map[v[i].y][v[i].x]].Size < v[i].Size) {
					v[map[v[i].y][v[i].x]].Size = -1;
				}
				else if (v[map[v[i].y][v[i].x]].Size > v[i].Size) {
					v[i].Size = -1;
					lose = 1;
				}

				if (lose == 0)
					map[v[i].y][v[i].x] = i;
			}
		}
	}
}



int main(void) {

	int r, c, m;
	cin >> r >> c >> m;
	vector<vector<int>> map(r + 1, vector<int>(c + 1));

	vector<shark> v(m + 1);
	for (int i = 1; i <= m; i++)
		cin >> v[i].y >> v[i].x >> v[i].speed >> v[i].dir >> v[i].Size;

	for (int i = 1; i <= m; i++)
		map[v[i].y][v[i].x] = i;

	for (int i = 1; i <= c; i++) {

		fishing(map, v, i, r);
		update(map, v, m, r, c);
		moving(map, v, m, r, c);
		update(map, v, m, r, c);

		/*cout << "\n";
		for (int k = 0; k <= r; k++) {
			for (int j = 0; j <= c; j++)
				cout << map[k][j] << " ";
			cout << "\n";
		}

		cout << "뒤진 상어 : ";
		for (int k = 1; k <= m; k++) {
			if (v[k].Size < 0) {
				cout << k << " ";
			}
		}
		cout << "\n";*/
	}
	cout << score;
}
