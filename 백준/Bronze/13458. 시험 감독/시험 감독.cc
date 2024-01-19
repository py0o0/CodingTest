#include <iostream>
#include <vector>
#include <algorithm>
#include <climits>
#include <queue>

using namespace std;



int main(void) {
	int n;
	cin >> n;
	vector<long long> peo;
	for (int i = 0; i < n; i++) {
		long long a;
		cin >> a;
		peo.push_back(a);
	}
	long long x, y;
	cin >> x >> y;

	long long cnt = 0;
	for (int i = 0; i < peo.size(); i++) {
		peo[i] -= x;
		cnt++;
		
		if (peo[i] > 0) {
			if (peo[i] % y == 0)
				cnt += peo[i] / y ;
			else
				cnt += peo[i] / y+1;
		}
	}

	cout << cnt;

	return 0;
}