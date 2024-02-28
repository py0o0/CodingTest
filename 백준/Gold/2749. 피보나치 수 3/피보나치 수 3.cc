#include <iostream>
#include <vector>
#include <algorithm>
#include <climits>
#include <queue>
#include <cstring>
#include <stack>
using namespace std;

vector<vector<long long>> b = { {1,1},{1,0} };

vector<vector<long long>> mul(vector<vector<long long>>v1, vector<vector<long long>>v2) {
	vector<vector<long long>> temp{ {0,0},{0,0} };

	for (int i = 0; i < 2; i++) {
		for (int j = 0; j < 2; j++) {
			long long sum = 0;
			for (int k = 0; k < 2; k++)
				sum += (v1[i][k] * v2[k][j]);
			temp[i][j] = sum % 1000000;
		}
	}
	return temp;
}

vector<vector<long long>> fibo(long long n) {
	if (n == 1)
		return b;
	else if (n % 2 == 1)
		return mul(fibo(n - 1), b);
	else if(n % 2 == 0) {
		vector<vector<long long>> v = fibo(n / 2);
		return mul(v, v);
	}

}
int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	
	vector<vector<long long>> v;
	long long n;
	cin >> n;
	if (n < 1) {
		cout << 0;
		return 0;
	}
	v = fibo(n);
	
	cout << v[0][1];
	
	return 0;
}

