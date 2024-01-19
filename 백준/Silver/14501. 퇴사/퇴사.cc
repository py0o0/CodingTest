#include <iostream>
#include <vector>
#include <algorithm>
#include <climits>
#include <queue>

using namespace std;

int MAX;

void dfs(vector<int> A, vector<int> T, vector<int> P, int start, int n) {
	if (start <= n) {
		int sum = 0;
		for (int i = 0; i < A.size(); i++) {
			sum += P[A[i]];
		}
		
		MAX = max(sum, MAX);

		/*for (int i = 0; i < A.size(); i++)
			cout << A[i] << " ";
		cout <<start<<" " << sum << "\n";*/

	}
	else
		return;

	for (int i = start; i < n; i++) {
		A.push_back(i);
		dfs(A, T, P, i + T[i], n);
		A.pop_back();
	}
}



int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int n;
	cin >> n;
	vector<int> T(n );
	vector<int> P(n );
	for (int i = 0; i < n; i++)
		cin >> T[i] >> P[i];
	vector<int> A;
	dfs(A, T, P, 0, n);
	cout << MAX;
}
