#include <iostream>
#include <vector>
#include <algorithm>
#include <climits>
#include <queue>
#include <cstring>

using namespace std;

int map[50][50];
int visit[50][50];
int dx[] = { 0,0,-1,1 };
int dy[] = { 1,-1,0,0 };

struct circle {
	int num;
	int dir;
	int cnt;
};

struct xy {
	int x;
	int y;
};

void lotate(int m,int x,int dir,int k) {
	for (int j = 0; j < k; j++) {
		if (dir == 1) {
			int temp = map[x][0];
			for (int i = 0; i < m - 1; i++) {
				map[x][i] = map[x][i + 1];
			}
			map[x][m - 1] = temp;
		}

		else if (dir == 0) {
			int temp = map[x][m - 1];
			for (int i = m - 1; i > 0; i--) {
				map[x][i] = map[x][i - 1];
			}
			map[x][0] = temp;
		}
	}
}

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int n, m, t;
	cin >> n >> m >> t;
	for (int i = 0; i < n; i++)
		for (int j = 0; j < m; j++)
			cin >> map[i][j];

	vector<circle> c;
	for (int i = 0; i < t; i++) {
		int a, b, d;
		cin >> a >> b >> d;
		c.push_back({ a - 1,b,d });
	}
	

	for (int o = 0; o < t; o++) {

		for (int i = 0; i < n; i++) 
			if ((i + 1) % (c[o].num + 1) == 0) {
				lotate(m, i, c[o].dir, c[o].cnt);                    //회전 함수
			}
		
		for (int i = 0; i < n; i++)
			memset(visit[i], 0, sizeof(int) * m);

		queue<xy> q;

		int suc = 0;                                       //원판에 인접한 수가 있는지를 검사할 변수
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (visit[i][j] == 1)
					continue;
				if (map[i][j] < 0)
					continue;
				
				int temp = map[i][j];
				vector<xy> v;
				visit[i][j] = 1;
				q.push({ i,j });

				while (q.size() != 0) {
					for (int k = 0; k < 4; k++) {
						int nx, ny;
						if (k < 2) {                      //같은 원판 내 검사
							nx = q.front().x;
							ny = (q.front().y + dy[k] + m) % m;
						}
						else {                            //다른 원판 검사
							nx = q.front().x + dx[k];
							ny = q.front().y;
						}
						
						if (nx < 0 || nx >= n || ny < 0 || ny >= m)
							continue;
						if (visit[nx][ny] == 1)
							continue;
						if (map[nx][ny] == temp) {
							visit[nx][ny] = 1;
							q.push({ nx,ny });
							v.push_back({ nx,ny });
						}
					}
					q.pop();
				}

				if (v.size() > 0) {
					suc = 1;
					map[i][j] = -1;
					for (auto a : v)
						map[a.x][a.y] = -1;
				}

			}
		}


		if (suc == 0) {                             //인접한 번호가 없을 경우
			double sum = 0;
			double cnt = 0;
			for (int i = 0; i < n; i++) 
				for (int j = 0; j < m; j++) {
					if (map[i][j] < 0)
						continue;
					sum += map[i][j];
					cnt++;
				}
			double av = sum / cnt;

			for (int i = 0; i < n; i++)
				for (int j = 0; j < m; j++) {
					if (map[i][j] < 0)
						continue;
					if (map[i][j] > av)
						map[i][j] -= 1;
					else if (map[i][j] < av)
						map[i][j] += 1;
				}
		}

		/*cout << "\n";
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++)
				cout << map[i][j] << " ";
			cout << "\n";
		}*/
		
	}

	int sum = 0;
	for (int i = 0; i < n; i++) 
		for (int j = 0; j < m; j++) 
			if (map[i][j] > 0)
				sum += map[i][j];
	cout << sum;
}

