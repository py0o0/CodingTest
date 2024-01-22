#include <iostream>
#include <vector>
#include <algorithm>
#include <climits>
#include <queue>
#include <cstring>

using namespace std;

int map[101][101];
int dx[] = { 0,-1,0,1 };
int dy[] = { 1,0,-1,0 };

struct dragon {
	int x;
	int y;
	int dir;
	int num;
};

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int n;
	cin >> n;

	vector<dragon> dra;
	for (int i = 0; i < n; i++) {
		int a, b, c, d;
		cin >> a >> b >> c >> d;
		dra.push_back({ b,a,c,d });
	}

	int r = 0, c = 0;

	for (int i = 0; i < n; i++) {
		vector<dragon> d;
		int x = dra[i].x;
		int y = dra[i].y;
		map[x][y] = 1;
		x += dx[dra[i].dir];
		y += dy[dra[i].dir];
		map[x][y] = 1;
		d.push_back({ x,y,dra[i].dir,0 });

		r = max(x, r);
		c = max(y, c);

		for (int j = 0; j < dra[i].num ; j++) {
		
			for (int k = d.size() - 1; k > -1; k--) {
				x += dx[(d[k].dir + 1) % 4];
				y += dy[(d[k].dir + 1) % 4];
				map[x][y] = 1;
				d.push_back({ x,y,(d[k].dir + 1) % 4,0 });

				r = max(x, r);
				c = max(y, c);
			}

			
		}
	}

	int cnt = 0;

	for (int i = 0; i < r+1; i++) 
		for (int j = 0; j < c + 1; j++)
			if (map[i][j] == 1)
				if (map[i + 1][j] == 1 && map[i][j + 1] == 1 && map[i + 1][j + 1] == 1)
					cnt++;
	
	cout << cnt;
	return 0;
}

