#include <iostream>
#include <vector>
#include <algorithm>
#include <climits>
#include <queue>
#include <cstring>
#include <stack>
using namespace std;

struct Like {
	int n;
	int s[4];
	int x;
	int y;
};

int map[20][20];
int dx[] = { 0,0,1,-1 };
int dy[] = { 1,-1,0,0 };	
int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int n;
	cin >> n;

	vector<Like> like;
	for (int i = 0; i < n * n; i++) {
		int a, b, c, d, e;
		cin >> a >> b >> c >> d >> e;
		like.push_back({ a,{b,c,d,e} });
			
	}
	int total = 0;
	int seq = 0;
	int store[2] = { };
	for (int o = 0; o < n * n; o++) {
		int Max = -1;
		int zeroMax = -1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == 0) {
					int cnt = 0;
					int zeroCnt = 0;
					for (int k = 0; k < 4; k++) {
						int nx = i + dx[k];
						int ny = j + dy[k];
						if (nx < 0 || nx >= n || ny < 0 || ny >= n)
							continue;
						if (map[nx][ny] == 0)
							zeroCnt++;
						else {
							for (int l = 0; l < 4; l++) {
								if (map[nx][ny] == like[o].s[l]) {
									cnt++;
									break;
								}
							}
						}
					}
					if (cnt > Max) {
						Max = cnt;
						zeroMax = zeroCnt;
						store[0] = i;
						store[1] = j;
					}
					else if (Max == cnt) {
						if(zeroCnt>zeroMax) {
							zeroMax = zeroCnt;
							store[0] = i;
							store[1] = j;
						}
					}
				}
			}
		}
		map[store[0]][store[1]] = like[o].n;
		like[o].x = store[0];
		like[o].y = store[1];
		
		/*cout << "\n";
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++)
				cout << map[i][j] << " ";
			cout << "\n";
		}*/

	}

	for (int i = 0; i < n * n; i++) {
		int likecnt = 0;
		for (int k = 0; k < 4; k++) {
			int nx = like[i].x + dx[k];
			int ny = like[i].y + dy[k];
			if (nx < 0 || nx >= n || ny < 0 || ny >= n)
				continue;
			if (map[nx][ny] != 0) {
				for (int l = 0; l < 4; l++) {
					if (map[nx][ny] == like[i].s[l]) {
						likecnt++;
						break;
					}
				}
			}
		}
		if (likecnt == 1)
			total += 1;
		else if (likecnt == 2)
			total += 10;
		else if (likecnt == 3)
			total += 100;
		else if (likecnt == 4)
			total += 1000;
	}

	cout << total;

	return 0;
}

