#include <iostream>
#include <vector>
#include <algorithm>
#include <climits>
#include <queue>
#include <cstring>
#include <stack>
using namespace std;

int p = 1000000007;

long long f(int s, int e) {
	long long x = 1;
	for (long long i = s; i <= e; i++)
		x = (x * i) % p;
	return x;
}

long long power(long long a, long long b) {
	if (b == 1)
		return a % p;
	long long x = power(a, b / 2);
	if (b % 2 == 1) 
		return x * x % p * a % p;
	else
		return x * x % p;
	
}

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	long long n, k;
	cin >> n>> k;

	if (k == n || k == 0)
		cout << 1;
	else
		cout << f(k + 1, n) * power(f(1, n - k), p - 2) % p;

	return 0;
}