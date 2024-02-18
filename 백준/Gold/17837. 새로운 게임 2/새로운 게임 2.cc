#include <iostream>
#include <vector>
#include <algorithm>
#include <climits>
#include <queue>
#include <cstring>
#include <stack>
using namespace std;

struct Map {
	int n;
	queue < int> q;
};

struct object {
	int x;
	int y;
	int dir;
};

int sucess = 0;
Map map[12][12];
int dx[] = { 0,0,-1,1 };
int dy[] = { 1,-1,0,0 };

void white(int x, int y, int nx, int ny, int n, vector<object>& o) {
	queue<int> q;

	while (map[x][y].q.front() != n) {
		q.push(map[x][y].q.front());
		map[x][y].q.pop();
	}

	while (map[x][y].q.size() != 0) {
		map[nx][ny].q.push(map[x][y].q.front());
		o[map[x][y].q.front()].x = nx;
		o[map[x][y].q.front()].y = ny;
		map[x][y].q.pop();
	}

	if (map[nx][ny].q.size() >= 4)
		sucess = 1;

	while (q.size() != 0) {
		map[x][y].q.push(q.front());
		q.pop();
	}

}

void red(int x, int y, int nx, int ny, int n, vector<object>& o) {
	queue<int> q;

	while (map[x][y].q.front() != n) {
		q.push(map[x][y].q.front());
		map[x][y].q.pop();
	}

	stack<int> change;
	while (map[x][y].q.size() != 0) {
		change.push(map[x][y].q.front());
		o[map[x][y].q.front()].x = nx;
		o[map[x][y].q.front()].y = ny;
		map[x][y].q.pop();
	}

	while (change.size() != 0) {
		map[nx][ny].q.push(change.top());
		change.pop();
	}

	if (map[nx][ny].q.size() >= 4)
		sucess = 1;

	while (q.size() != 0) {
		map[x][y].q.push(q.front());
		q.pop();
	}

}

void blue(vector<object>& o,int i,int n) {
	if (o[i].dir == 0 || o[i].dir == 2)
		o[i].dir++;
	else if (o[i].dir == 1 || o[i].dir == 3)
		o[i].dir--;

	int nx = o[i].x + dx[o[i].dir];
	int ny = o[i].y + dy[o[i].dir];

	if (nx < 0 || nx >= n || ny < 0 || ny >= n)
		return;
	if (map[nx][ny].n == 0)
		white(o[i].x, o[i].y, nx, ny, i, o);

	else if (map[nx][ny].n == 1)
		red(o[i].x, o[i].y, nx, ny, i, o);
}



int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int n, k;
	cin >> n >> k;
	for (int i = 0; i < n; i++)
		for (int j = 0; j < n; j++)
			cin >> map[i][j].n;

	vector<object> o;
	for (int i = 0; i < k; i++) {
		int a, b, c;
		cin >> a >> b >> c;
		o.push_back({ a - 1,b - 1,c - 1 });
		map[a - 1][b - 1].q.push(i);
	}

	int turn = 1;
	while (1) {

		for (int i = 0; i < k; i++) {
			int nx = o[i].x + dx[o[i].dir];
			int ny = o[i].y + dy[o[i].dir];

			if (nx < 0 || nx >= n || ny < 0 || ny >= n)    //격자 밖
				blue(o, i, n);

			else if (map[nx][ny].n == 0)                      //흰색
				white(o[i].x, o[i].y, nx, ny, i, o);

			else if (map[nx][ny].n == 1)                  //빨간색
				red(o[i].x, o[i].y, nx, ny, i, o);

			else if (map[nx][ny].n == 2)                  //파란색
				blue(o, i, n);
		}

		/*cout << "\n";
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j].q.size() == 0)
					cout << 0 << " ";
				else
					cout << map[i][j].q.size() << " ";
			}
			cout << "\n";
		}*/

		if (sucess)
			break;
		if (turn > 1000) {
			cout << -1;
			return 0;
		}

		turn++;
	}

	cout << turn;

	
	return 0;
}