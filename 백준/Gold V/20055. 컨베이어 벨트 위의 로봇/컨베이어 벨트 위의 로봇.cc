#include <iostream>
#include <vector>
#include <algorithm>
#include <climits>
#include <queue>
#include <cstring>
#include <stack>
using namespace std;

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int n, k;

	cin >> n >> k;

	vector<int> v(2 * n);
	int cnt = 0;
	for (int i = 0; i < 2 * n; i++) {
		cin >> v[i];
		if (v[i] == 0)
			cnt++;
	}

	if (cnt >= k) {
		cout << 0;
		return 0;
	}
	cnt = 0;
	int turn = 1;

	deque<int> robot;
	while (1) {
		int temp = v[2 * n - 1];                      //벨트 움직임
	
		for (int i = 2 * n - 1; i > 0; i--) 
			v[i] = v[i - 1];
		
		v[0] = temp;

		for (int i = 0; i < robot.size();i++) {                          //로봇 움직임
			robot[i] += 1; //벨트에 의한 움직임
			if (robot[i] >= n - 1) {
				robot.pop_front();
				i--;
			}
			else {
				int next = robot[i] + 1; //로봇의 자체 움직임
				if (v[next] > 0) {
					int fail = 0;
					for (int j = 0; j < i; j++) {
						if (robot[j] == next) {
							fail = 1;
							break;
						}
					}
					if (!fail) {
						robot[i] = next;
						v[next]--;
						if (next >= n - 1) {
							robot.pop_front();
							i--;
						}
					}
				}

			}
		}

		if (v[0] > 0) {        //로봇 올림
			v[0]--;
			robot.push_back(0);
		}

		cnt = 0;
		for (int i = 0; i < 2 * n; i++)         //내구도 확인
			if (v[i] <= 0)
				cnt++;
		if (cnt >= k)
			break;

		turn++;
	}

	cout << turn;
	
	return 0;
}

