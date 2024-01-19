#include <iostream>
#include <vector>
#include <algorithm>
#include <string>


using namespace std;



int main(void) {
	int n, m;
	cin >> n >> m;
	vector<vector<int>> map(n, vector<int>(m));
	for (int i = 0; i < n; i++)
		for (int j = 0; j < m; j++)
			cin >> map[i][j];

	int MAX = 0;

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			int sum = 0;
			if (i + 3 < n) {            //1번 모양 l
				sum += map[i][j] + map[i + 1][j] + map[i + 2][j] + map[i + 3][j];
				MAX=max(MAX, sum);
				sum = 0;
			}
			if (j + 3 < m) {
				sum += map[i][j] + map[i][j+1] + map[i][j+2] + map[i][j+3];
				MAX = max(MAX, sum);
				sum = 0;
			}

			if (i + 1 < n && j + 1 < m) { //2번 모양 ㅁ
				sum += map[i][j] + map[i][j + 1] + map[i + 1][j] + map[i + 1][j + 1];
				MAX = max(MAX, sum);
				sum = 0;
			}

			if (j - 1 > -1 && i - 2 > -1) { //3번 모양 ㄴ
				sum += map[i][j] + map[i][j - 1] + map[i - 1][j-1] + map[i - 2][j - 1];
				MAX = max(MAX, sum);
				sum = 0;
			}
			if (j + 1 < m && i - 2 > -1) { 
				sum += map[i][j] + map[i][j + 1] + map[i - 1][j + 1] + map[i - 2][j + 1];
				MAX = max(MAX, sum);
				sum = 0;
			}
			if (j + 2 < m && i - 1 > -1) { 
				sum += map[i][j] + map[i - 1][j] + map[i - 1][j + 1] + map[i - 1][j + 2];
				MAX = max(MAX, sum);
				sum = 0;
			}
			if (j - 2 > -1 && i - 1 > -1) { 
				sum += map[i][j] + map[i-1][j] + map[i - 1][j - 1] + map[i - 1][j - 2];
				MAX = max(MAX, sum);
				sum = 0;
			}
			if (j + 1 < m && i + 2 < n) {
				sum += map[i][j] + map[i][j+1] + map[i + 1][j + 1] + map[i + 2][j + 1];
				MAX = max(MAX, sum);
				sum = 0;
			}
			if (j - 1 > -1 && i + 2 < n) {
				sum += map[i][j] + map[i][j - 1] + map[i + 1][j - 1] + map[i + 2][j - 1];
				MAX = max(MAX, sum);
				sum = 0;
			}
			if (j + 2 < m && i + 1 < n) {
				sum += map[i][j] + map[i+1][j] + map[i + 1][j + 1] + map[i + 1][j + 2];
				MAX = max(MAX, sum);
				sum = 0;
			}
			if (j - 2 > -1 && i + 1 < n) {
				sum += map[i][j] + map[i + 1][j] + map[i + 1][j - 1] + map[i + 1][j - 2];
				MAX = max(MAX, sum);
				sum = 0;
			}

			if (j - 1 > -1 && i - 1 > -1 && i + 1 < n) { //4번 모양 ㅏ
				sum += map[i][j] + map[i][j - 1] + map[i - 1][j - 1] + map[i + 1][j - 1];
				MAX = max(MAX, sum);
				sum = 0;
			}
			if (j + 1 < m && i - 1 > -1 && i + 1 < n) { //4번 모양 ㅓ
				sum += map[i][j] + map[i][j + 1] + map[i - 1][j + 1] + map[i + 1][j + 1];
				MAX = max(MAX, sum);
				sum = 0;
			}
			if (j + 1 < m && j - 1 > -1 && i + 1 < n) { //4번 모양 ㅗ
				sum += map[i][j] + map[i + 1][j] + map[i + 1][j - 1] + map[i + 1][j + 1];
				MAX = max(MAX, sum);
				sum = 0;
			}
			if (j + 1 < m && j - 1 > -1 && i - 1 > -1) { //4번 모양 ㅜ
				sum += map[i][j] + map[i - 1][j] + map[i - 1][j - 1] + map[i - 1][j + 1];
				MAX = max(MAX, sum);
				sum = 0;
			}

			if (j + 2 < m &&  i + 1 < n) { //5번 모양 ㄱㄴ
				sum += map[i][j] + map[i][j+1] + map[i + 1][j + 1] + map[i + 1][j + 2];
				MAX = max(MAX, sum);
				sum = 0;
			}
			if (j - 2 > -1 && i + 1 < n) { 
				sum += map[i][j] + map[i][j - 1] + map[i + 1][j - 1] + map[i + 1][j - 2];
				MAX = max(MAX, sum);
				sum = 0;
			}
			if (j + 1 < m && i + 2 < n) {
				sum += map[i][j] + map[i + 1][j] + map[i + 1][j + 1] + map[i + 2][j + 1];
				MAX = max(MAX, sum);
				sum = 0;
			}
			if (j - 1 > -1 && i + 2 < n) {
				sum += map[i][j] + map[i + 1][j] + map[i + 1][j - 1] + map[i + 2][j - 1];
				MAX = max(MAX, sum);
				sum = 0;
			}

		}

	}
	
	cout << MAX;

}
	