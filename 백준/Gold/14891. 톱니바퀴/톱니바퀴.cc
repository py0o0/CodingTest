#include <iostream>
#include <vector>
#include <algorithm>
#include <string>
#include <cmath>
#include <climits>

using namespace std;

int ch[5];

void moving(vector<vector<int>> &h, int x, int y) {
	if (x == 1) {
		ch[x] = 1;

		int re = -1;
		if (re == y)
			re = 1;

		if (h[x][2] != h[x + 1][6] && ch[x + 1] == 0)
			moving(h, x + 1, re);

		if (y == 1) {
			int temp = h[x][7];
			for (int i = 7; i > 0; i--)
				h[x][i] = h[x][i - 1];
			h[x][0] = temp;
		}
		else {
			int temp = h[x][0];
			for (int i = 0; i < 7; i++)
				h[x][i] = h[x][i + 1];
			h[x][7] = temp;
		}

	}

	else if (x == 2) {
		ch[x] = 1;
		int re = -1;
		if (re == y)
			re = 1;

		if (h[x][2] != h[x + 1][6] && ch[x + 1] == 0)
			moving(h, x + 1, re);

		if (h[x][6] != h[x - 1][2] && ch[x - 1] == 0)
			moving(h, x - 1, re);

		if (y == 1) {
			int temp = h[x][7];
			for (int i = 7; i > 0; i--)
				h[x][i] = h[x][i - 1];
			h[x][0] = temp;
		}
		else {
			int temp = h[x][0];
			for (int i = 0; i < 7; i++)
				h[x][i] = h[x][i + 1];
			h[x][7] = temp;
		}

	}

	else if (x == 3) {
		ch[x] = 1;
		int re = -1;
		if (re == y)
			re = 1;

		if (h[x][2] != h[x + 1][6] && ch[x + 1] == 0)
			moving(h, x + 1, re);

		if (h[x][6] != h[x - 1][2] && ch[x - 1] == 0)
			moving(h, x - 1, re);

		if (y == 1) {
			int temp = h[x][7];
			for (int i = 7; i > 0; i--)
				h[x][i] = h[x][i - 1];
			h[x][0] = temp;
		}
		else {
			int temp = h[x][0];
			for (int i = 0; i < 7; i++)
				h[x][i] = h[x][i + 1];
			h[x][7] = temp;
		}

	}

	else if (x == 4) {
		ch[x] = 1;
		
		int re = -1;
		if (re == y)
			re = 1;

		if (h[x][6] != h[x - 1][2] && ch[x - 1] == 0)
			moving(h, x - 1, re);

		if (y == 1) {
			int temp = h[x][7];
			for (int i = 7; i > 0; i--)
				h[x][i] = h[x][i - 1];
			h[x][0] = temp;
		}
		else {
			int temp = h[x][0];
			for (int i = 0; i < 7; i++)
				h[x][i] = h[x][i + 1];
			h[x][7] = temp;
		}

	}
}

int main(void) {
	vector<vector<int>> h(5, vector<int>(8));

	vector<string> s(5);
	for (int i = 1; i < 5; i++)
		cin >> s[i];

	for (int i = 1; i <= 4; i++)
		for (int j = 0; j < 8; j++)
			h[i][j] = s[i][j] - '0';

	int n;
	cin >> n;
	vector<pair<int, int>> move(n);
	for (int i = 0; i < n; i++)
		cin >> move[i].first >> move[i].second;

	int sum = 0;
	for (int i = 0; i < n; i++) {

		for (int j = 0; j < 5; j++)
			ch[j] = 0;

		moving(h, move[i].first, move[i].second);

		/*cout << "\n";
		for (int k = 1; k <= 4; k++) {
			for (int j = 0; j < 8; j++)
				cout << h[k][j] << " ";
			cout << "\n";
		}*/
	}
	if (h[1][0] == 1)
		sum += 1;
	if (h[2][0] == 1)
		sum += 2;
	if (h[3][0] == 1)
		sum += 4;
	if (h[4][0] == 1)
		sum += 8;

	cout << sum;

}
