#include <iostream>
#include <vector>
#include <algorithm>
#include <climits>
#include <queue>
#include <cstring>

using namespace std;

struct people_move {
	int i;
	int j;
	int v;    //맵의 값을 저장할 변수
};
int di[] = { 0,0,1,-1 };
int dj[] = { 1,-1,0,0 };

int abs(int n) {
	if (n >= 0)
		return n;
	return -n;
}

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	
	int map[50][50];
	int visit[50][50];
	int n, l, r;
	cin >> n >> l >> r;

	for (int i = 0; i < n; i++)
		for (int j = 0; j < n; j++)
			cin >> map[i][j];
	int move = 0;
	queue<people_move> q;
	while (1) {
		for (int i = 0; i < n; i++)
			memset(visit[i], 0, sizeof(int) * n);
		int fail = 1;             
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (visit[i][j] == 0) {
					visit[i][j] = 1;
					q.push({ i,j,map[i][j] });
					vector<people_move> v;                                      //나중에 이동 후의 값 수정을 위해 위치 저장
					v.push_back({ i,j,map[i][j] });
					while (q.size() != 0) {
						for (int k = 0; k < 4; k++) {
							int ni = q.front().i + di[k];
							int nj = q.front().j + dj[k];
							if (ni < 0 || ni >= n || nj < 0 || nj >= n)
								continue;
							if (visit[ni][nj] == 1)
								continue;
							int dis = abs(q.front().v - map[ni][nj]);
							if (dis >= l && dis <= r) {
								fail = 0;                                        //이동이 적어도 한번은 일어남
								q.push({ ni,nj,map[ni][nj] });
								visit[ni][nj] = 1;
								v.push_back({ ni,nj,map[ni][nj] });
							}

						}
						q.pop();
					}

					int sum = 0;
					for (auto a : v)
						sum += a.v;             //연결된 지역들의 합
					sum /= v.size();           
					for (auto a : v)
						map[a.i][a.j] = sum;   //인구수 = 총인구수 / 연결된 지역 수
				}
			}
		}

		if (fail == 1)
			break;

		move++;
	}
	cout << move;

	return 0;
}
