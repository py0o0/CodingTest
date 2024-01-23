#include <iostream>
#include <vector>
#include <algorithm>
#include <climits>
#include <queue>
#include <cstring>

using namespace std;
int map[50][50];
int a, b;
int cnt;
int dx[] = { 0,0,-1,1 };
int dy[] = { 1,-1,0,0 };
void move_a(int r,int c) {
	
	for (int i = a; i > 0; i--) {
		map[i][0] = map[i - 1][0];
		if (i == a)
			map[i][0] = -1;
	}

	for (int i = 0; i < c - 1; i++)
		map[0][i] = map[0][i + 1];

	for (int i = 0; i < a; i++)
		map[i][c-1] = map[i + 1][c-1];

	for (int i = c-1; i > 1; i--)
		map[a][i] = map[a][i-1];

	map[a][1] = 0;

}

void move_b(int r, int c) {

	for (int i =b; i < r-1; i++) {
		map[i][0] = map[i + 1][0];
		if (i == b)
			map[i][0] = -1;
	};
	
	for (int i = 0; i < c - 1; i++)
		map[r - 1][i] = map[r - 1][i + 1];

	for (int i = r - 1; i > b; i--)
		map[i][c - 1] = map[i - 1][c - 1];

	for (int i = c - 1; i > 1; i--)
		map[b][i] = map[b][i - 1];

	map[b][1] = 0;

}

void check(int r, int c) {
	for (int i = 0; i < r; i++) {
		for (int j = 0; j < c; j++)
			cnt += map[i][j];
	}
}

void spread(int r, int c) {
	int temp[50][50] = { 0 };
	for (int i = 0; i < r; i++)
		for (int j = 0; j < c; j++)
			temp[i][j] = map[i][j];

	for (int i = 0; i < r; i++)
		for (int j = 0; j < c; j++) {
			if (map[i][j] != 0) {
				for (int k = 0; k < 4; k++) {
					int nx = i + dx[k];
					int ny = j + dy[k];
					if (nx < 0 || nx >= r || ny < 0 || ny >= c)
						continue;
					if (map[nx][ny] == -1)
						continue;
					temp[nx][ny] += map[i][j] / 5;
					temp[i][j] -= map[i][j] / 5;
					
				}
			}
		}

	for (int i = 0; i < r; i++)
		for (int j = 0; j < c; j++)
			map[i][j] = temp[i][j];
}

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int r, c, t;
	cin >> r >> c >> t;
	
	for (int i = 0; i < r; i++) {
		for (int j = 0; j < c; j++) {
			cin >> map[i][j];
			if (map[i][j] == -1) {
				if (a == 0)
					a = i;
				else
					b = i;
			}
		}
	}

	for (int k = 0; k < t; k++) {

		spread(r, c);

		move_a(r,c);

		move_b(r, c);

	}

	check(r, c);
	cout << cnt + 2;

}

