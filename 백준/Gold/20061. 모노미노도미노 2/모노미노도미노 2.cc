#include <iostream>
#include <vector>
#include <algorithm>
#include <climits>
#include <queue>
#include <cstring>
#include <stack>
using namespace std;

struct Do {
	int t;
	int x;
	int y;
};

int map[10][10];
int total;

void green_move(int t,int x,int y) {
	if (t == 2) {
		for (; x < 9; x++) {
			if (map[x+1][y] != 0 || map[x+1][y + 1] != 0)
				break;
		}
		map[x][y] = 1;
		map[x][y + 1] = 1;
	}
	else if(t==1) {
		for (; x < 9; x++) {
			if (map[x + 1][y] != 0)
				break;
		}
		map[x][y] = 1;
	}
	else if (t == 3) {
		x++;
		for (; x < 9; x++) {
			if (map[x + 1][y] != 0)
				break;
		}
		map[x][y] = 1;
		map[x - 1][y] = 1;
	}
}

void blue_move(int t, int x, int y) {
	if (t == 3) {
		for (; y < 9; y++) {
			if (map[x][y + 1] != 0 || map[x + 1][y + 1] != 0)
				break;
		}
		map[x][y] = 1;
		map[x + 1][y] = 1;
	}
	else if (t == 1) {
		for (; y < 9; y++) {
			if (map[x][y+1] != 0)
				break;
		}
		map[x][y] = 1;
	}
	else if (t == 2) {
		y++;
		for (; y < 9; y++) {
			if (map[x][y+1] != 0)
				break;
		}
		map[x][y] = 1;
		map[x][y - 1] = 1;
	}
}

void green_push(int x) {
	for (; x > 4; x--) {
		for (int j = 0; j < 4; j++) {
			map[x][j] = map[x - 1][j];
			map[x - 1][j] = 0;
		}
		
	}
}

void green_boom(){
	int cnt = 0;
	for (int i = 6; i < 10; i++) {
		cnt = 0;
		for (int j = 0; j < 4; j++)
			if (map[i][j] == 1)
				cnt++;
		if (cnt == 4) {
			for (int j = 0; j < 4; j++)
				map[i][j] = 0;
			green_push(i);
			total++;
		}
	}
}

void blue_push(int y) {
	for (; y > 4; y--) {
		for (int j = 0; j < 4; j++) {
			map[j][y] = map[j][y - 1];
			map[j][y - 1] = 0;
		}

	}
}

void blue_boom() {
	int cnt = 0;
	for (int i = 6; i < 10; i++) {
		cnt = 0;
		for (int j = 0; j < 4; j++)
			if (map[j][i] == 1)
				cnt++;
		if (cnt == 4) {
			for (int j = 0; j < 4; j++)
				map[j][i] = 0;
			blue_push(i);
			total++;
		}
	}
}

void check_softGreen() {
	int cnt = 0;
	for (int i = 4; i < 6; i++)
		for (int j = 0; j < 4; j++)
			if (map[i][j] != 0) {
				cnt++;
				break;
			}

	if (cnt == 2) {
		for (int i = 8; i < 10; i++) {
			for (int j = 0; j < 4; j++)
				map[i][j] = 0;
			green_push(i);
		}
	}
	else if (cnt == 1) {
		for (int j = 0; j < 4; j++)
			map[9][j] = 0;
		green_push(9);
	}

}

void check_softBlue() {
	int cnt = 0;
	for (int i = 4; i < 6; i++)
		for (int j = 0; j < 4; j++)
			if (map[j][i] != 0) {
				cnt++;
				break;
			}

	if (cnt == 2) {
		for (int i = 8; i < 10; i++) {
			for (int j = 0; j < 4; j++)
				map[j][i] = 0;
			blue_push(i);
		}
	}
	else if (cnt == 1) {
		for (int j = 0; j < 4; j++)
			map[j][9] = 0;
		blue_push(9);
	}

}

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int n;
	cin >> n;

	vector<Do> domino;
	for (int i = 0; i < n; i++) {
		int a, b, c;
		cin >> a >> b >> c;
		domino.push_back({ a,b,c });
	}

	for (auto d : domino) {
		green_move(d.t, d.x, d.y);
		blue_move(d.t, d.x, d.y);

		green_boom();
		blue_boom();

		check_softGreen();
		check_softBlue();
	}
	int cnt = 0;
	for(int i=6;i<10;i++)
		for (int j = 0; j < 4; j++) {
			if (map[i][j] == 1)
				cnt++;
			if (map[j][i] == 1)
				cnt++;
		}

	cout << total << "\n" << cnt;

	return 0;
}

