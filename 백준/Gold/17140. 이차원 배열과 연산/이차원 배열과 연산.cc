#include <iostream>
#include <vector>
#include <algorithm>
#include <climits>
#include <queue>
#include <cstring>

using namespace std;
int map[100][100];

struct standard {
	int val;
	int cnt;
};

struct cmp {
	bool operator()(standard& n1, standard n2) {
		if (n1.cnt == n2.cnt)
			return n1.val > n2.val;
		return n1.cnt > n2.cnt;
	}
};

void r_sort(int i, int& c) {
	priority_queue<standard, vector<standard>, cmp> pq;
	int temp[101];
	memset(temp, 0, sizeof(temp));

	for (int j = 0; j < c; j++) {
		if (map[i][j] != 0) {
			temp[map[i][j]]++;
			map[i][j] = 0;
		}
	}

	for (int j = 0; j < 101; j++) {
		if (temp[j] != 0)
			pq.push({ j,temp[j] });
		if (pq.size() >= 50)
			break;
	}

	int size = pq.size();
	c = max(c, size * 2);

	int j = 0;
	while (pq.size() != 0) {
		map[i][j++] = pq.top().val;
		map[i][j++] = pq.top().cnt;
		pq.pop();
	}
}

void c_sort(int i, int& r) {
	priority_queue<standard, vector<standard>, cmp> pq;
	int temp[101];
	memset(temp, 0, sizeof(temp));

	for (int j = 0; j < r; j++) {
		if (map[j][i] != 0) {
			temp[map[j][i]]++;
			map[j][i] = 0;
		}
	}

	for (int j = 0; j < 101; j++) {
		if (temp[j] != 0)
			pq.push({ j,temp[j] });
		if (pq.size() >= 50)
			break;
	}

	int size = pq.size();
	r = max(r, size * 2);

	int j = 0;
	while (pq.size() != 0) {
		map[j++][i] = pq.top().val;
		map[j++][i] = pq.top().cnt;
		pq.pop();
	}
}

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int r, c, k, x, y, t;
	cin >> x >> y >> k;
	r = c = 3;
	
	for (int i = 0; i < 3; i++) 
		for (int j = 0; j < 3; j++) 
			cin >> map[i][j];
	
	if (map[x - 1][y - 1] == k) {
		cout << 0;
		return 0;
	}

	t = 1;
	while(1) {
		if (r >= c) 
			for (int i = 0; i < r; i++)
				r_sort(i, c);
		
		else
			for (int i = 0; i < c; i++)
				c_sort(i, r);

		if (map[x - 1][y - 1] == k) {
			cout << t;
			return 0;
		}

		/*cout << "\n";
		for (int k = 0; k < r; k++) {
			for (int j = 0; j < c; j++)
				cout << map[k][j] << " ";
			cout << "\n";
		}*/
		
		if (t == 100)
			break;

		t++;
		
	}
	cout << -1;
	return 0;
}
