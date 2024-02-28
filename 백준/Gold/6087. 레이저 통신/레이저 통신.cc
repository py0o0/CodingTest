#include <iostream>
#include <vector>
#include <algorithm>
#include <climits>
#include <queue>
#include <cstring>
#include <stack>
using namespace std;

struct Laser {
	int x;
	int y;
	int dir;
};

char map[100][100];
int visit[100][100][4];
int dx[] = { 0,1,0,-1 };
int dy[] = { 1,0,-1,0 };

int bfs(int sx,int sy,int h,int w) {
	int mirror = 0;
	queue<Laser> temp;
	while (1) {
		queue<Laser> q;
		if (mirror == 0)
			q.push({ sx,sy,-1 });

		while (temp.size() != 0) {
			q.push(temp.front());
			temp.pop();
		}

		while (q.size() != 0) {
			for (int i = 0; i < 4; i++) {
				if (i == q.front().dir)
					continue;
				int nx = q.front().x;
				int ny = q.front().y;
				while (1) {
					nx += dx[i];
					ny += dy[i];
					if (nx < 0 || nx >= h || ny < 0 || ny >= w)
						break;
					if (map[nx][ny] == '*'|| visit[nx][ny][i] == 1)
						break;
					if (map[nx][ny] == 'C')
						return mirror;
					visit[nx][ny][i] = 1;
					temp.push({ nx, ny, i });
				}
			}
			q.pop();
		}
		mirror++;
	}
}

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int w, h;
	cin >> w >> h;
	int StartFlag=0;
	int sx = 0, sy = 0;
	for(int i=0;i<h;i++)
		for (int j = 0; j < w; j++) {
			cin >> map[i][j];
			if (map[i][j] == 'C') {
				if (StartFlag == 0) {
					StartFlag = 1;
					map[i][j] = 'S';
					sx = i;
					sy = j;
				}
			}
		}
	cout << bfs(sx, sy, h, w);

	return 0;
}
