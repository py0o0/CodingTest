#include <iostream>
#include <vector>
#include <algorithm>
#include <climits>
#include <queue>

using namespace std;

int ans;

int max_value(vector<vector<int>> v) {
	int MAX = 0;
	for (int i = 0; i < v.size(); i++) {
		for (int j = 0; j < v[0].size(); j++)
			MAX = max(MAX, v[i][j]);
	}
	return MAX;
}

vector<vector<int>> right(vector<vector<int>> v) {
	vector<int> c(v.size());
	vector<vector<int>> check(v.size(), c);
	for (int i = 0; i < v.size(); i++) {
		for (int j = v[0].size() - 2; j>-1; j--) {
			if (v[i][j] == 0)
				continue;
			for (int k = j+1; k < v[0].size(); k++) {
				if (v[i][k] == v[i][k - 1] && check[i][k] == 0) {
					v[i][k] *= 2;
					v[i][k - 1] = 0;
					check[i][k] = 1;
					break;
				}
				else if (v[i][k] == 0) {
					v[i][k] = v[i][k - 1];
					v[i][k - 1] = 0;
				}
				else
					break;

			}
		}
	}
	return v;
}

vector<vector<int>> left(vector<vector<int>> v) {
	vector<int> c(v.size());
	vector<vector<int>> check(v.size(), c);
	for (int i = 0; i < v.size(); i++) {
		for (int j = 1; j <v[0].size(); j++) {
			if (v[i][j] == 0)
				continue;
			for (int k = j - 1; k > -1; k--) {
				if (v[i][k] == v[i][k + 1] && check[i][k] == 0) {
					v[i][k] *= 2;
					v[i][k + 1] = 0;
					check[i][k] = 1;
					break;
				}
				else if (v[i][k] == 0) {
					v[i][k] = v[i][k + 1];
					v[i][k + 1] = 0;
				}
				else
					break;

			}
		}
	}
	return v;
}


vector<vector<int>> up(vector<vector<int>> v) {
	vector<int> c(v.size());
	vector<vector<int>> check(v.size(), c);
	for (int i = 0; i < v.size(); i++) {
		for (int j = 1; j < v.size(); j++) {
			if (v[j][i] == 0)
				continue;
			for (int k = j - 1; k > -1; k--) {
				if (v[k][i] == v[k+1][i] && check[k][i] == 0) {
					v[k][i] *= 2;
					v[k+1][i] = 0;
					check[k][i] = 1;
					break;
				}
				else if (v[k][i] == 0) {
					v[k][i] = v[k+1][i];
					v[k+1][i] = 0;
				}
				else
					break;

			}
		}
	}
	return v;
}


vector<vector<int>> down(vector<vector<int>> v) {
	vector<int> c(v.size());
	vector<vector<int>> check(v.size(), c);
	for (int i = 0; i < v.size(); i++) {
		for (int j = v.size() - 2; j > -1; j--) {
			if (v[j][i] == 0)
				continue;
			for (int k = j + 1; k < v.size(); k++) {
				if (v[k][i] == v[k-1][i] && check[k][i] == 0) {
					v[k][i] *= 2;
					v[k-1][i] = 0;
					check[k][i] = 1;
					break;
				}
				else if (v[k][i] == 0) {
					v[k][i] = v[k-1][i];
					v[k-1][i] = 0;
				}
				else
					break;

			}
		}
	}
	return v;
}



void dfs(vector<vector<int>> v, int cnt) {
	
	ans=max(ans,max_value(v));

	if (cnt == 5)
		return;

	dfs(right(v), cnt+1);
	dfs(left(v), cnt + 1);
	dfs(up(v), cnt + 1);
	dfs(down(v), cnt + 1);

	return;
}

int main(void) {
	int t;
	cin >> t;
	vector<vector<int>> v;

	for (int i = 0; i < t; i++) {
		vector<int> v1;
		for (int j = 0; j < t; j++) {
			int a;
			cin >> a;
			v1.push_back(a);
		}
		v.push_back(v1);
	}

	dfs(v, 0);

	cout << ans;

	return 0;
}


