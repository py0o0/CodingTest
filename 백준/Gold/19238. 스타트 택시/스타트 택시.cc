#include <iostream>
#include <vector>
#include <algorithm>
#include <climits>
#include <queue>
#include <cstring>

using namespace std;


struct taxi {
	int x;
	int y;
	int num;
	int fuel;
};

struct Map {
	int x;
	vector<int> dir;
};

struct cmp {
	bool operator()(taxi& n1, taxi& n2) {
		if (n1.x == n2.x)
			return n1.y > n2.y;
		return n1.x > n2.x;
	}
};

int dx[] = { -1,1,0,0 };
int dy[] = { 0,0,-1,1 };
Map map[20][20];
int visit[20][20];

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int n, m, k;
	cin >> n >> m >> k;
	for (int i = 0; i < n; i++)
		for (int j = 0; j < n; j++)
			cin >> map[i][j].x;

	taxi t;
	int x, y;
	cin >> x >> y;
	t.x = x - 1;
	t.y = y - 1;
	t.fuel = k;

	for (int i = 2; i < m + 2; i++) {
		int a, b, c, d;
		cin >> a >> b >> c >> d;
		map[a - 1][b - 1].x = i;                  //출발지
		map[c - 1][d - 1].dir.push_back(i);                //목적지
	}

	int cnt = 1;
	while (1) {
		queue<taxi> q;
		priority_queue<taxi, vector<taxi>, cmp> pq;
		q.push({ t.x,t.y,0,0 });

		for (int i = 0; i < n; i++)
			memset(visit[i], 0, sizeof(int) * n);

		int temp = 0;
		int flag = 0;

		if (map[t.x][t.y].x > 1)
			t.num = map[t.x][t.y].x;
		else {
			while (q.size() != 0) {                                         //손님 태우기

				for (int i = 0; i < 4; i++) {
					int nx = q.front().x + dx[i];
					int ny = q.front().y + dy[i];
					if (nx < 0 || nx >= n || ny < 0 || ny >= n)
						continue;
					if (map[nx][ny].x == 1)
						continue;
					if (visit[nx][ny] == 1)
						continue;
					if (flag == 1 && q.front().num >= temp)
						break;
					visit[nx][ny] = 1;
					q.push({ nx,ny,q.front().num + 1,0 });
					if (map[nx][ny].x > 1) {
						pq.push({ nx,ny,map[nx][ny].x,0 });
						flag = 1;
						temp = q.front().num + 1;
					}
				}

				q.pop();
				if (flag == 1 && q.front().num >= temp)
					break;
			}

			if (pq.size() == 0) {
				cout << -1;
				return 0;
			}

			t.x = pq.top().x;
			t.y = pq.top().y;
			t.num = pq.top().num;
			t.fuel -= temp;
			if (t.fuel <= 0) {
				cout << -1;
				return 0;
			}
		}
		map[t.x][t.y].x = 0;
		
		for (int i = 0; i < n; i++)
			memset(visit[i], 0, sizeof(int) * n);
		while (q.size() != 0)
			q.pop();

		q.push({ t.x,t.y,0,0 });
		flag = 0;
	
		while (q.size() != 0) {                                         //목적지로 이동

			for (int i = 0; i < 4; i++) {
				int nx = q.front().x + dx[i];
				int ny = q.front().y + dy[i];
				if (nx < 0 || nx >= n || ny < 0 || ny >= n)
					continue;
				if (map[nx][ny].x == 1)
					continue;
				if (visit[nx][ny] == 1)
					continue;
				if (flag == 1)
					break;
				visit[nx][ny] = 1;
				q.push({ nx,ny,q.front().num + 1,0 });
				if (map[nx][ny].dir.size()>0) {
					for(auto c: map[nx][ny].dir)
						if (c == t.num) {
							flag = 1;
							temp = q.front().num + 1;
							t.x = nx;
							t.y = ny;
						}
				}
			}
			if (q.front().num + 1 > t.fuel) {
				cout << -1;
				return 0;
			}
			q.pop();
			if (flag == 1)
				break;
		}
		if (flag == 0) {
			cout << -1;
			return 0;
		}

		t.fuel -= temp;


		if (t.fuel < 0) {
			cout << -1;
			return 0;
		}
		else
			t.fuel += temp  * 2;

		if (cnt == m)
			break;

		cnt++;
		

	}
	cout << t.fuel;

	return 0;
}

