#include <iostream>
#include <vector>
#include <algorithm>
#include <climits>
#include <queue>

using namespace std;

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	
	int t;
	cin >> t;
	vector < pair<int, int>> v(41);
	for (int o = 0; o < t; o++) {
		int n;
		cin >> n;
		int a, b, c, d;
		v[0].first = 1;
		v[0].second = 0;
		v[1].first = 0;
		v[1].second = 1;
	
		for(int i = 2; i <= n; i++) {
			v[i].first = v[i - 1].first + v[i - 2].first;
			v[i].second = v[i - 1].second + v[i - 2].second;
		}

		cout << v[n].first << " " << v[n].second << "\n";
	}

	
}
