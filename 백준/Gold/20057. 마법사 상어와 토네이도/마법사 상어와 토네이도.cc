#include <iostream>
#include <vector>
#include <algorithm>
#include <climits>
#include <queue>
#include <cstring>

using namespace std;

int map[500][500];
	
struct tone {
	int x;
	int y;
	int dir;
};

int dx[][10] = { {1,-1,2,-2,1,-1,1,-1,0,0},{0,0,0,0,-1,-1,1,1,2,1}  ,{1,-1,2,-2,1,-1,1,-1,0,0,}, {0,0,0,0,1,1,-1,-1,-2,-1} };
int dy[][10] = { {0,0,0,0,1,1,-1,-1,-2,-1},{1,-1,2,-2,1,-1,1,-1,0,0},{0,0,0,0,-1,-1	,1,1,2,1}  , {1,-1,2,-2,1,-1,1,-1,0,0} };

int cal[] = { 7,7,2,2,1,1,10,10,5,100 };

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int n;
	cin >> n;
	vector<tone> to;
	to.push_back({ n / 2,n / 2,-1 });
	to.push_back({ n / 2,n / 2 - 1,0 });
	to.push_back({ n / 2 + 1,n / 2 - 1,1 });

	for (int i = 0; i < n; i++) 
		for (int j = 0; j < n; j++) 
			cin >> map[i][j];
			
	int cnt = 2;
	int count = 0;
	int x = n / 2 + 1;
	int y = n / 2 - 1;
	for (int i = 3; i < n * n;) {
		if (to[i - 1].dir == 1){                          //밑 방향
			int j = 0;
			for (; j < cnt; j++) {
				y++;
				to.push_back({ x,y,2 });
			}
			i += j;
		}
		else if (to[i - 1].dir == 2) {                   //오른 방향
			int j = 0;
			for (; j < cnt; j++) {
				x--;
				to.push_back({ x,y,3 });
			}
			i += j;
		}
		else if (to[i - 1].dir == 3) {                    //윗 방향
			int j = 0;
			for (; j < cnt; j++) {
				y--;
				to.push_back({ x,y,0 });
			}
			i += j;
		}
		else if (to[i - 1].dir == 0) {                    //왼 방향
			int j = 0;
			for (; j < cnt; j++) {
				x++;
				to.push_back({ x,y,1 });
			}
			i += j;
		}
		if (x == 0 && y == 0)
			break;
		count++;
		if (count == 2 && i != n * n + 1 - n)
			cnt++, count = 0;
	}


	int total = 0;
	for (int k=1;k<to.size();k++) {
		int sum = map[to[k].x][to[k].y];
		int Sum = sum;
		for (int i = 0; i < 9; i++) {
			int nx = to[k].x + dx[to[k].dir][i];
			int ny = to[k].y + dy[to[k].dir][i];

			Sum -= sum * cal[i] / 100;

			if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
				total += sum * cal[i] / 100;
				continue;
			}

			map[nx][ny]+= sum * cal[i] / 100;
		}
		map[to[k].x][to[k].y] = 0;
		int nx = to[k].x + dx[to[k].dir][9];
		int ny = to[k].y + dy[to[k].dir][9];

		if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
			total += Sum;
			continue;
		}
		map[nx][ny] += Sum;
		


		/*cout << "\n";
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++)
				cout << map[i][j] << " ";
			cout << "\n";
		}*/
	}

	cout << total;




}

