#include <iostream>
#include <vector>
#include <algorithm>
#include <climits>
#include <queue>
#include <cstring>
#include <stack>
using namespace std;

struct MAP {
	queue<int> q;
	int smell;
};

struct Fish {
	int x;
	int y;
	int dir;
};

struct Move {
	int x;
	int y;
	int visit[4][4];
	Fish one;
	Fish two;
	Fish thr;
	int cnt;
	int fishing;
};

MAP map[4][4];
MAP temp[4][4];

int dx[] = { 0,-1, - 1,-1,0,1,1,1 };
int dy[] = { -1,-1,0,1,1,1,0,-1 };

int sx[] = { -1,0,1,0 };
int sy[] = { 0,-1,0,1 };

void FishClear(int x, int y) {
	if (map[x][y].q.size() > 0)
		map[x][y].smell = 1;
	while (map[x][y].q.size() != 0)
		map[x][y].q.pop();
}

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int m, s;
	cin >> m >> s;

	for (int i = 0; i < m; i++) {
		int a, b, c;
		cin >> a >> b >> c;
		map[a - 1][b - 1].q.push(c - 1);
	}

	Fish shark;
	cin >> shark.x >> shark.y;
	shark.x -= 1;
	shark.y -= 1;

	for (int o = 0; o < s; o++) {
		
		queue<Fish> fish;
		for (int i = 0; i < 4; i++)                      //물고기 복제
			for (int j = 0; j < 4; j++)
				if (map[i][j].q.size() != 0) {
					temp[i][j].q = map[i][j].q;
					while (map[i][j].q.size() != 0) {    //물고기 이동
						int curx = i;
						int cury = j;
						int curdir = map[i][j].q.front();
						for (int k = 0; k < 8; k++) {
							int dir = map[i][j].q.front() - k;
							if (dir < 0)
								dir += 8;
							int nx = i + dx[dir];
							int ny = j + dy[dir];
							if (nx < 0 || nx >= 4 || ny < 0 || ny >= 4)
								continue;
							if (nx == shark.x && ny == shark.y)
								continue;
							if (map[nx][ny].smell > 0)
								continue;
							curx = nx;
							cury = ny;
							curdir = dir;
							break;
						}
						fish.push({ curx, cury, curdir });
						map[i][j].q.pop();
					}
				}
		while (fish.size() != 0) {
			map[fish.front().x][fish.front().y].q.push(fish.front().dir);
			fish.pop();
		}

		int Max = -1;
		queue<Move> q;
		queue<Move> store;
		q.push({ shark.x,shark.y });

		while (q.size() != 0) {                                     //상어 이동
			for (int i = 0; i < 4; i++) {
				int nx = q.front().x + sx[i];
				int ny = q.front().y + sy[i];
				if (nx < 0 || nx >= 4 || ny < 0 || ny >= 4)
					continue;

				Move move;
				move = q.front();
				move.x = nx;
				move.y = ny;
				if (move.visit[nx][ny] == 0) {
					move.visit[nx][ny] = 1;
					move.fishing += map[nx][ny].q.size();
				}
				move.cnt += 1;

				if (q.front().cnt == 0) {
					move.one = { nx,ny };
					q.push(move);
				}
				else if (q.front().cnt == 1) {
					move.two = { nx,ny };
					q.push(move);
				}
				else if (q.front().cnt == 2) {
					move.thr = { nx,ny };
					if (Max < move.fishing) {
						Max = move.fishing;
						while (store.size() != 0)
							store.pop();
						store.push(move);
					}
				}

			}
			q.pop();
		}

		for (int i = 0; i < 4; i++)                                //냄새 지우기
			for (int j = 0; j < 4; j++)
				if (map[i][j].smell > 0) {
					map[i][j].smell++;
					if (map[i][j].smell >= 3)
						map[i][j].smell = 0;
				}
		
		FishClear(store.front().one.x, store.front().one.y);       //물고기 지우고 냄새 남기기
		FishClear(store.front().two.x, store.front().two.y);
		FishClear(store.front().thr.x, store.front().thr.y);

		shark.x = store.front().thr.x;
		shark.y = store.front().thr.y;


		for (int i = 0; i < 4; i++)
			for (int j = 0; j < 4; j++) {
				if (temp[i][j].q.size() > 0) {
					while (temp[i][j].q.size() != 0) {
						map[i][j].q.push(temp[i][j].q.front());
						temp[i][j].q.pop();
					}
				}
			}

	}

	int sum = 0;
	for (int i = 0; i < 4; i++)
		for (int j = 0; j < 4; j++)
			sum += map[i][j].q.size();
	
	cout << sum;

	return 0;
}
