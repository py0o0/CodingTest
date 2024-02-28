#include <iostream>
#include <vector>
#include <algorithm>
#include <climits>
#include <queue>
#include <cstring>
#include <stack>
using namespace std;

vector<vector<int>> mul(vector<vector<int>>v1, vector<vector<int>> v2) {
	vector<vector<int>> temp(v1.size(), vector<int>(v1.size()));
	for (int i = 0; i < v1.size(); i++) {
		for (int j = 0; j < v1.size(); j++) {
			int sum = 0;
			for (int k = 0; k < v1.size(); k++) {
				sum += v1[i][k] * v2[k][j];
				sum = sum % 1000;
			}
			temp[i][j] = sum;
		}
	}
	return temp;
}
vector<vector<int>> power(vector<vector<int>> a, long long b) {
	if (b == 1)
		return a;
	vector<vector<int>> temp = power(a, b / 2);
	if (b % 2 == 1)
		return mul(mul(temp, temp), a);
	else
		return mul(temp, temp);
	
}

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int n; 
	long long b;
	cin >> n >> b;
	vector<vector<int>> v(n, vector<int>(n));
	for (int i = 0; i < n; i++)
		for (int j = 0; j < n; j++)
			cin >> v[i][j];

	v = power(v, b);

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++)
			cout << v[i][j] % 1000 << " ";
		cout << "\n";
	}

	return 0;
}

