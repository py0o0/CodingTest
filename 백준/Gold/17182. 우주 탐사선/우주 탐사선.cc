#include <iostream>
#include <vector>
#include <climits>
#include <queue>
using namespace std;

int arr[11][11];
int visit[11];
int an = INT_MAX;
void dfs(int start, int dis, int cnt, int n) {
	if (cnt == n) {
		an = min(an, dis);
		return;
	}

	for (int i = 0; i < n; i++) {
		if (visit[i] == 1) continue;
		visit[i] = 1;
		dfs(i, dis + arr[start][i], cnt + 1, n);
		visit[i] = 0;
	}

}

int main(void) {
	ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
	
	int n, start;
	cin >> n >> start;
	for (int i = 0; i < n; i++)
		for (int j = 0; j < n; j++)
			cin >> arr[i][j];

	visit[start] = 1;

	for (int i = 0; i < n; i++)
		for (int j = 0; j < n; j++)
			for (int k = 0; k < n; k++)
				arr[i][j] = min(arr[i][j], arr[i][k] + arr[k][j]);

	dfs(start, 0,1 , n);
	cout << an;
	return 0;

}