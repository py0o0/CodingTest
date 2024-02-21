#include <iostream>
#include <vector>
#include <algorithm>
#include <climits>
#include <queue>
#include <cstring>
#include <stack>
using namespace std;

int map[8][20] = { {0,2,4,6,8,10,12,14,16,18,20,22,24,26,28,30,32,34,36,38},{0,13,16,19},{0,22,24},{0,28,27,26},{25},{30,35},{40},{0} };

int Max = INT_MIN;

struct game {
	int x;
	int y;
};

void dfs(vector<int> dice,vector<game> g, int score,int cnt) {
	if (cnt >= 10) {
		Max = max(score, Max);
		return;
	}

	for (int i = 0; i < 4; i++) {
		if (g[i].x == 7)
			continue;
		if (g[i].x == 0 && (g[i].y == 5 || g[i].y == 10 || g[i].y == 15)) {
			int temp = g[i].y;
			if (g[i].y == 5) {
				g[i].x = 1;
				g[i].y = dice[cnt];
			}
			else if (g[i].y == 10) {
				g[i].x = 2;
				g[i].y = dice[cnt];
			}
			else if (g[i].y == 15) {
				g[i].x = 3;
				g[i].y = dice[cnt];
			}

			if (g[i].x == 1 || g[i].x == 3) {
				if (g[i].y == 4) {
					g[i].x = 4;
					g[i].y = 0;
				}
				else if (g[i].y == 5) {
					g[i].x = 5;
					g[i].y = 0;
				}
			}

			else if (g[i].x == 2) {
				if (g[i].y == 3) {
					g[i].x = 4;
					g[i].y = 0;
				}
				else if (g[i].y == 4) {
					g[i].x = 5;
					g[i].y = 0;
				}
				else if (g[i].y == 5) {
					g[i].x = 5;
					g[i].y = 1;
				}
			}

			int flag = 0;
			for (int j = 0; j < 4; j++) {
				if (i != j) {
					if (g[j].x == g[i].x && g[j].y == g[i].y) {
						if (g[j].x != 7) {
							flag = 1;
							break;
						}
					}
				}
			}
			if (flag == 1) {
				g[i].x = 0;
				g[i].y = temp;
				continue;
			}

			score += map[g[i].x][g[i].y];
			dfs(dice, g, score, cnt + 1);
			score -= map[g[i].x][g[i].y];
			g[i].x = 0;
			g[i].y = temp;


		}
		else {
			int tempX = g[i].x;
			int tempY = g[i].y;
			g[i].y += dice[cnt];
			if (g[i].x == 0) {
				if (g[i].y == 20) {
					g[i].x = 6;
					g[i].y = 0;
				}
				else if (g[i].y >= 21) {
					g[i].x = 7;
					g[i].y = 0;
				}
			}
			else if (g[i].x == 1|| g[i].x == 3) {
				if (g[i].y == 4) {
					g[i].x = 4;
					g[i].y = 0;
				}
				else if (g[i].y >= 5&& g[i].y <7) {
					g[i].x = 5;
					g[i].y = g[i].y % 5;
				}
				else if (g[i].y == 7) {
					g[i].x = 6;
					g[i].y = 0;
				}
				else if (g[i].y >= 8) {
					g[i].x = 7;
					g[i].y = 0;
				}
			}
			else if (g[i].x == 2) {
				if (g[i].y == 3) {
					g[i].x = 4;
					g[i].y = 0;
				}
				else if (g[i].y >= 4 && g[i].y < 6) {
					g[i].x = 5;
					g[i].y = g[i].y % 4;
				}
				else if (g[i].y == 6) {
					g[i].x = 6;
					g[i].y = 0;
				}
				else if (g[i].y >= 7) {
					g[i].x = 7;
					g[i].y = 0;
				}
			}
			else if (g[i].x == 4) {
				if (g[i].y >= 1 && g[i].y < 3) {
					g[i].x = 5;
					g[i].y = g[i].y - 1;
				}
				else if (g[i].y == 3) {
					g[i].x = 6;
					g[i].y = 0;
				}
				else if (g[i].y >= 4) {
					g[i].x = 7;
					g[i].y = 0;
				}
			}
			else if (g[i].x == 5) {
				if (g[i].y == 2) {
					g[i].x = 6;
					g[i].y = 0;
				}
				else if (g[i].y >= 3) {
					g[i].x = 7;
					g[i].y = 0;
				}
			}
			else if (g[i].x == 6) {
					g[i].x = 7;
					g[i].y = 0;
				
			}

			int flag = 0;
			for (int j = 0; j < 4; j++) {
				if (i != j) {
					if (g[j].x == g[i].x && g[j].y == g[i].y) {
						if (g[j].x != 7) {
							flag = 1;
							break;
						}
					}
				}
			}
			if (flag == 1) {
				g[i].x = tempX;
				g[i].y = tempY;
				continue;
			}

			score += map[g[i].x][g[i].y];
			dfs(dice, g, score, cnt + 1);
			score -= map[g[i].x][g[i].y];
			g[i].x = tempX;
			g[i].y = tempY;


		}

	}

}

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	vector<int> dice;
	for (int i = 0; i < 10; i++) {
		int n;
		cin >> n;
		dice.push_back(n);
	}
	vector<game> g(4);

	dfs(dice, g, 0, 0);

	cout << Max;
	
	return 0;
}

