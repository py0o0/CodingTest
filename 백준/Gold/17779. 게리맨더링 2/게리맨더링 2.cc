#include <iostream>
#include <vector>
#include <algorithm>
#include <climits>
#include <queue>
#include <cstring>
#include <stack>
using namespace std;

struct Map {
	int p;
	int n;
};

Map map[21][21];



int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int n;
	cin >> n;
	int amount = 0;
	for (int i = 1; i <= n; i++)
		for (int j = 1; j <= n; j++) {
			cin >> map[i][j].p;
			amount += map[i][j].p;
		}
	int answer = INT_MAX;
	for (int x = 1; x < n; x++) {
		for (int y = 1; y < n; y++) {
			for (int d1 = 1; d1 < n; d1++) {
				for (int d2 = 1; d1 + d2 < n; d2++) {
					if (y - d1<1 || y - d1 >= y || y + d2 <= y || y + d2>n || x + d1 + d2 > n)
						continue;

					for (int i = 1; i <= n; i++)
						for (int j = 1; j <= n; j++)
							map[i][j].n = 0;

					for (int i = 0; i <= d2; i++)                 //경계 채우기
						map[x + d1 + i][y - d1 + i].n = 5;
					for (int i = 0; i <= d1; i++)
						map[x +d2 + i][y +d2 - i].n = 5;
					for (int i = 0; i <= d1; i++) {
						map[x + i][y - i].n = 5;

						if (i != d1) {
							int nx = x + i + 1;
							while (map[nx][y - i].n != 5) {
								map[nx][y - i].n = 5;
								nx += 1;
								if (nx > n)
									break;
							}
						}
					}
					for (int i = 0; i <= d2; i++) {
						map[x + i][y + i].n = 5;
						
						if (i != d2) {
							int nx = x + i + 1;
							while (map[nx][y + i].n != 5) {
								map[nx][y + i].n = 5;
								nx += 1;
								if (nx > n)
									break;
							}
						}
					}

					int cnt[6] = { 0, };
					cnt[5] = amount;
					for (int i = 1; i <= n; i++)           //구역 채우기
						for (int j = 1; j <= n; j++) {
							if (map[i][j].n == 0) {
								if (i < x + d1 && j <= y) {
									map[i][j].n = 1;
									cnt[1] += map[i][j].p;
								}
								else if (i <= x + d2 && j > y && j <= n) {
									map[i][j].n = 2;
									cnt[2] += map[i][j].p;
								}
								else if (i >= x + d1 && i <= n && j < y - d1 + d2) {
									map[i][j].n = 3;
									cnt[3] += map[i][j].p;
								}
								else if (i >= x + d2 && i <= n && j >= y - d1 + d2 && j <= n) {
									map[i][j].n = 4;
									cnt[4] += map[i][j].p;
								}
							}
						}
					for (int i = 1; i < 5; i++)
						cnt[5] -= cnt[i];

					int Max = INT_MIN;
					int Min = INT_MAX;
					for (int i = 1; i < 6; i++) {
						Max = max(cnt[i], Max);
						Min = min(cnt[i], Min);
					}
					answer = min(Max - Min, answer);

					//if (Max - Min == 15) 
						//cout << x << " " << y << " " << d1 << " " << d2 << "\n";
					

					/*if (x == 5 && y == 3 && d1 == 2 && d2 == 1) {
						cout << "\n";
						cout << Max-Min << "\n";
						for (int i = 1; i <= n; i++) {
							for (int j = 1; j <= n; j++)
								cout << map[i][j].n << " ";
							cout << "\n";
						}
					}*/

				}
			}
		}
	}


	cout << answer;
	
	return 0;
}
