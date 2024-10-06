#include <iostream>
#include <vector>
#include <climits>
#include <queue>
using namespace std;

vector<long long> sege;
vector<long long> v;

long long init(int start, int end, int node) {
	if (start == end) 
		return sege[node] = v[start];
	int mid = (start + end) / 2;
	return sege[node] = init(start, mid, node * 2) + init(mid + 1, end, node * 2 + 1);

}

void update(int node, int start, int end, int index, long long diff) {
	if (start > index || index > end) return;
	sege[node] += diff;

	if (start != end) {
		int mid = (start + end) / 2;
		update(node * 2, start, mid, index, diff);
		update(node * 2 + 1, mid + 1, end, index, diff);
	}

}

long long cal(int node,int start, int end, int change_i, int change_j) {
	if (end < change_i || start > change_j) return 0;
	if (change_i <= start and change_j >= end) return sege[node];
	int mid = (start + end) / 2;
	return cal(node * 2, start, mid, change_i, change_j) + cal(node * 2 + 1, mid + 1, end, change_i, change_j);

}

int main(void) {
	ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
	long long n, m, k;
	cin >> n >> m >> k;
	v.resize(n);
	sege.resize(4 * n);
	for (int i = 0; i < n; i++)
		cin >> v[i];
	init(0, n - 1, 1);
	
	for (int i = 0; i < m + k; i++) {
		int a, b;
		long long c;
		cin >> a >> b >> c;
		if (a == 1) {
			long long diff = c - v[b - 1];
			v[b - 1] = c;
			update(1, 0, n - 1, b - 1, diff);
		}
		else {
			cout << cal(1, 0, n - 1, b - 1, c - 1)<<"\n";
		}
	}
	return 0;

}