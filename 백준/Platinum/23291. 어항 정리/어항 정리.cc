#include <iostream>
#include <vector>
#include <algorithm>
#include <climits>
#include <queue>
#include <cstring>
#include <stack>
using namespace std;

int map[101][101];
int temp[101][101];
int dx[4] = { 0,0,1,-1 };
int dy[4] = { 1,-1,0,0 };

void lotate(int& x, int& n, int& m) {
	for (int i = m - 1 , ix = 0; i > x; i--, ix++) {
		for (int j = 0,  jx = 0; j < n; j++, jx++) {
			temp[ix][jx] = map[j][i];
			map[j][i] = 0;
		}
	}

	int i = 0;
	int nextM = 0;
	int nextN = n;
	while (1) {
		if (temp[i][0] == 0)
			break;
		nextN = max(i + 2, nextN);
		int j = 0;
		while (1) {
			if (temp[i][j] == 0)
				break;
			map[i + 1][m + j] = temp[i][j];
			temp[i][j] = 0;
			nextM = max(m + j + 1, nextM);
			j++;
		}
		i++;
	}
	x = m - 1;
	m = nextM;
	n = nextN;

}
int abs(int n) {
	if (n < 0)
		return -n;
	return n;
}

void division(int x, int h, int n) {
	for (int i = 0; i < h; i++)
		for (int j = x; j < n; j++)
			temp[i][j] = map[i][j];

	for (int i = 0; i < h; i++) {
		for (int j = x; j < n; j++) {
			if (map[i][j] == 0)
				break;
			for (int k = 0; k < 4; k++) {
				int nx = i + dx[k];
				int ny = j + dy[k];
				if (ny<x || ny>=n || nx < 0 || nx >= h)
					continue;
				if (map[nx][ny] == 0)
					continue;

				int sub = abs(map[i][j] - map[nx][ny]);
				if (sub / 5 > 0) {
					if (map[i][j] > map[nx][ny]) {
						temp[nx][ny] += sub / 5;
						temp[i][j] -= sub / 5;
					}
					
				}
				

			}
		}
	}

	for (int i = 0; i < h; i++)
		for (int j = x; j < n; j++) {
			map[i][j] = temp[i][j];
			temp[i][j] = 0;
		}

}

void LineUp(int x, int h, int n) {
	int ix = 0;
	for (int i = x; i < n; i++) {
		for (int j = 0; j < h; j++) {
			if (map[j][i] == 0)
				break;
			temp[0][ix] = map[j][i];
			map[j][i] = 0;
			ix++;
		}
	}

	for (int i = 0; i < n; i++) {
		map[0][i] = temp[0][i];
		temp[0][i] = 0;
	}

}

void divide(int n) {
	for (int i = n/2 -1,ix = n/2; i > -1; i--,ix++) {
		map[1][ix] = map[0][i];
		map[0][i] = 0;
	}

	for (int i = 1, ix = 2; i > -1; i--, ix++) {
		for (int j = n - n / 4 - 1, jx = n - n / 4; j >= n / 2; j--, jx++) {
			map[ix][jx] = map[i][j];
			map[i][j] = 0;
		}
	}
}

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int n, k;
	cin >> n >> k;
	for (int i = 0; i < n; i++)
		cin >> map[0][i];

	int turn = 1;

	while (1) {
		int Min = INT_MAX;
		for (int i = 0; i < n; i++)                 //가장 적은 어항 ++
			Min = min(map[0][i], Min);
		for (int i = 0; i < n; i++)
			if (map[0][i] == Min)                         
				map[0][i]++;

		map[1][1] = map[0][0];                        //첫 쌓기
		map[0][0] = 0;

		int left = 2;
		int height = 2;
		int lotateX = 0;

		while (n - left >= height)                     //쌓기
			lotate(lotateX, height, left);

		division(lotateX + 1, height, n);                //물고기 분배

		LineUp(lotateX + 1, height, n);                //일렬로

		divide(n);                                     // n/4로 만듦

		division(n - n / 4, 4, n);

		LineUp(n - n / 4, 4, n);                //일렬로

		int Max = INT_MIN;
		Min = INT_MAX;
		for (int i = 0; i < n; i++) {
			Min = min(map[0][i], Min);
			Max = max(map[0][i], Max);
		}
		if (Max - Min <= k)
			break;
		
		turn++;
	}
	
	cout << turn;
	return 0;
}

