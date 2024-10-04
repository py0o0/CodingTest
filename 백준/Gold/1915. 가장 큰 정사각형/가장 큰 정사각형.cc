#include <iostream>
#include <vector>
#include <climits>
#include <queue>
using namespace std;

int main(void) {
	int n, m;
	cin >> n >> m;
	vector<vector<int>> map(n, vector<int>(m));

	int flag = 0;
	for (int i = 0; i < n; i++) {
		string s;
		cin >> s;
		for (int j = 0; j < m; j++) {
			map[i][j] = s[j] - '0';
			if (map[i][j] == 1) flag = 1;
		}
	}

	int Max = 0;
	for (int i = 1; i < n; i++) {
		for (int j = 1; j < m; j++) {
			if (map[i][j] != 0) {
				map[i][j] = min(map[i][j - 1], min(map[i - 1][j], map[i - 1][j - 1])) + 1; //가로의 길이와 세로의 길이 중 작은 길이 선택
				
				Max = max(map[i][j], Max);
			}
			
		}
	}
	if (Max == 0) cout << flag;
	else cout << Max * Max;
	return 0;
}