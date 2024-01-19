#include <iostream>
#include <vector>
#include <algorithm>
#include <string>


using namespace std;

void move(vector<int>& dice ,pair<int, int>& d ,int n,int w,char dir,int& fail) {
	if (dir == 'R') {
		d.first += 1;
		if (d.first >= w) {
			d.first -= 1;
			fail = 1;
			return;
		}

		int temp = dice[2]; //오른
		dice[2] = dice[0]; //위
		dice[0] = dice[3]; //왼
		dice[3] = dice[1]; //밑
		dice[1] = temp;
	}
	else if (dir == 'L') {
		d.first -= 1;
		if (d.first < 0) {
			d.first += 1;
			fail = 1;
			return;
		}
		int temp = dice[2]; //오른
		dice[2] = dice[1]; //밑
		dice[1] = dice[3]; //왼
		dice[3] = dice[0]; //위
		dice[0] = temp;
	}
	else if (dir == 'U') {
		d.second -= 1;
		if (d.second < 0) {
			d.second += 1;
			fail = 1;
			return;
		}

		int temp = dice[0]; //위
		dice[0] = dice[4]; //앞
		dice[4] = dice[1]; //밑
		dice[1] = dice[5]; //뒤
		dice[5] = temp;
	}
	else if (dir == 'D') {
		d.second += 1;
		if (d.second >= n) {
			d.second -= 1;
			fail = 1;
			return;
		}

		int temp = dice[0]; //위
		dice[0] = dice[5]; //뒤
		dice[5] = dice[1]; //밑
		dice[1] = dice[4]; //앞
		dice[4] = temp;
	}
}

void score(vector<vector<int>>& map,vector<int>& dice, pair<int, int>& d) {
	if (map[d.second][d.first] == 0) {
		map[d.second][d.first] = dice[1];
	}
	else {
		dice[1] = map[d.second][d.first];
		map[d.second][d.first] = 0;
	}
}

int main(void) {
	
	int n, w, cx, cy, cnt;
	cin >> n >> w >> cy >> cx >> cnt;
	vector<vector<int>> map(n, vector<int>(w));

	for (int i = 0; i < n; i++)
		for (int j = 0; j < w; j++)
			cin >> map[i][j];

	vector<int> com(cnt);
	for (int i = 0; i < cnt; i++)
		cin >> com[i];

	vector<int> dice(6);
	char dir = 'U';
	pair<int,int> d;
	d.first = cx;
	d.second = cy;

	for (int i = 0; i < cnt; i++) {
		int fail = 0;
		if (com[i] == 1) {
			dir = 'R';
			move(dice, d, n, w, dir, fail);
		}
		else if (com[i] == 2) {
			dir = 'L';
			move(dice, d, n, w, dir, fail);
		}
		else if (com[i] == 3) {
			dir = 'U';
			move(dice, d, n, w, dir, fail);
		}
		else if (com[i] == 4) {
			dir = 'D';
			move(dice, d, n, w, dir, fail);
		}

		

		if (fail == 0) {
			score(map, dice, d);
			cout << dice[0] << "\n";
		}
		
	}


	
}