#include <iostream>
#include <vector>
#include <algorithm>
#include <climits>
#include <queue>
#include <cstring>

using namespace std;

struct fire {
	int x;
	int y;
	int mass;
	int speed;
	int dir;
};

deque<fire> map[100][100];

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int n, m, k;
	cin >> n >> m >> k;
	for (int i = 0; i < m; i++) {
		int a, b, c, d, e;
		cin >> a >> b >> c >> d >> e;
		map[a - 1][b - 1].push_back({ a - 1,b - 1,c,d,e });
	}

	for (int o = 0; o < k; o++) {
		vector<fire> v;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j].size() == 0)
					continue;
				int size = map[i][j].size();
				for (int l = 0; l < size; l++) {
					if (map[i][j][0].dir == 0) {
						int nx = (i - map[i][j][0].speed) % n;
						if (nx < 0)
							nx += n;
						v.push_back({ nx,j,map[i][j][0].mass ,map[i][j][0].speed ,map[i][j][0].dir });
					}
					else if (map[i][j][0].dir == 1) {
						int nx = (i - map[i][j][0].speed) % n;
						int ny = (j + map[i][j][0].speed) % n;
						if (nx < 0)
							nx += n;
						if (ny >= n)
							ny -= n;
						v.push_back({ nx,ny,map[i][j][0].mass ,map[i][j][0].speed ,map[i][j][0].dir });
					}
					else if (map[i][j][0].dir == 2) {
						int ny = (j + map[i][j][0].speed) % n;
						if (ny >= n)
							ny -= n;
						v.push_back({ i,ny,map[i][j][0].mass ,map[i][j][0].speed ,map[i][j][0].dir });
					}
					else if (map[i][j][0].dir == 3) {
						int nx = (i + map[i][j][0].speed) % n;
						int ny = (j + map[i][j][0].speed) % n;
						if (nx >= n)
							nx -= n;
						if (ny >= n)
							ny -= n;
						v.push_back({ nx,ny,map[i][j][0].mass ,map[i][j][0].speed ,map[i][j][0].dir });
					}
					else if (map[i][j][0].dir == 4) {
						int nx = (i + map[i][j][0].speed) % n;
						if (nx >= n)
							nx -= n;
						v.push_back({ nx,j,map[i][j][0].mass ,map[i][j][0].speed ,map[i][j][0].dir });
					}
					else if (map[i][j][0].dir == 5) {
						int nx = (i + map[i][j][0].speed) % n;
						int ny = (j - map[i][j][0].speed) % n;
						if (nx >= n)
							nx -= n;
						if (ny < 0)
							ny += n;
						v.push_back({ nx,ny,map[i][j][0].mass ,map[i][j][0].speed ,map[i][j][0].dir });
					}
					else if (map[i][j][0].dir == 6) {
						int ny = (j - map[i][j][0].speed) % n;;
						if (ny < 0)
							ny += n;
						v.push_back({ i,ny,map[i][j][0].mass ,map[i][j][0].speed ,map[i][j][0].dir });
					}
					else if (map[i][j][0].dir == 7) {
						int nx = (i - map[i][j][0].speed) % n;
						int ny = (j - map[i][j][0].speed) % n;
						if (nx < 0)
							nx += n;
						if (ny < 0)
							ny += n;
						v.push_back({ nx,ny,map[i][j][0].mass ,map[i][j][0].speed ,map[i][j][0].dir });
					}



					map[i][j].pop_front();
				}
			}
		}

		for(auto c:v)
			map[c.x][c.y].push_back({ c.x,c.y,c.mass ,c.speed ,c.dir });

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j].size() < 2)
					continue;
				int mass = 0;
				int speed = 0;
				int odd = 1;
				int pair = 1;
				int size = map[i][j].size();
				for (int l = 0; l < size; l++) {
					mass += map[i][j][l].mass;
					speed += map[i][j][l].speed;
					if (map[i][j][l].dir % 2 == 0)
						odd = 0;
					else if (map[i][j][l].dir % 2 != 0)
						pair = 0;
				}

				map[i][j].clear();
				if (mass / 5 == 0)
					continue;
				if (odd == 1 || pair == 1) {
					map[i][j].push_back({ i,j,mass / 5,speed / size,0 });
					map[i][j].push_back({ i,j,mass / 5,speed / size,2 });
					map[i][j].push_back({ i,j,mass / 5,speed / size,4 });
					map[i][j].push_back({ i,j,mass / 5,speed / size,6 });
				}
				else {
					map[i][j].push_back({ i,j,mass / 5,speed / size,1 });
					map[i][j].push_back({ i,j,mass / 5,speed / size,3 });
					map[i][j].push_back({ i,j,mass / 5,speed / size,5 });
					map[i][j].push_back({ i,j,mass / 5,speed / size,7 });
				}

				
			}
		}

	}

	int mass = 0;

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			if (map[i][j].size() == 0)
				continue;
			int size = map[i][j].size();
			for (int l = 0; l < size; l++) 
				mass += map[i][j][l].mass;
			
		}
	}

	cout << mass;

	return 0;
}

