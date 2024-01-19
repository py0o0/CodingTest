#include <iostream>
#include <vector>
#include <algorithm>
#include <string>

using namespace std;

int dx[4] = { 0,0,1,-1 };
int dy[4] = { 1,-1,0,0 };
int cnt;
int ch[21][21] = { 0, };

struct dice {
	vector<vector<int>> d;
	int x, y;
	char head;

	dice() : d(4, vector<int>(3)) {
		head = 'R';
		x = 0;
		y = 0;
		d[0][1] = 2;   //뒤
		d[1][0] = 4;   //왼
		d[1][1] = 1;   //위
		d[1][2] = 3;   //오른
		d[2][1] = 5;   //앞
		d[3][1] = 6;   //아래
	}

};

void move(dice& dice,int n,int w) {
	if (dice.head == 'R') {
		if (dice.x == w - 1) {
			dice.head = 'L';
			dice.x -= 1;
		}
		else
			dice.x += 1;
	}
	else if (dice.head == 'L') {
		if (dice.x == 0) {
			dice.head = 'R';
			dice.x += 1;
		}
		else
			dice.x -= 1;
	}
	else if (dice.head == 'U') {
		if (dice.y == 0) {
			dice.head = 'D';
			dice.y += 1;
		}
		else
			dice.y -= 1;
	}
	else if (dice.head == 'D') {
		if (dice.y == n-1) {
			dice.head = 'U';
			dice.y -= 1;
		}
		else
			dice.y += 1;
	}

}

void chanedice(dice& dice) {
	if (dice.head == 'R') {
		int temp = dice.d[1][0];
		dice.d[1][0] = dice.d[3][1];
		dice.d[3][1] = dice.d [1][2];
		dice.d[1][2] = dice.d[1][1];
		dice.d[1][1] = temp;
	}
	else if (dice.head == 'L') {
		int temp = dice.d[1][0];
		dice.d[1][0] = dice.d[1][1];
		dice.d[1][1] = dice.d[1][2];
		dice.d[1][2] = dice.d[3][1];
		dice.d[3][1] = temp;
	}
	else if (dice.head == 'U') {
		int temp = dice.d[0][1];
		dice.d[0][1] = dice.d[1][1];
		dice.d[1][1] = dice.d[2][1];
		dice.d[2][1] = dice.d[3][1];
		dice.d[3][1] = temp;
	}
	else if (dice.head == 'D') {
		int temp = dice.d[0][1];
		dice.d[0][1] = dice.d[3][1];
		dice.d[3][1] = dice.d[2][1];
		dice.d[2][1] = dice.d[1][1];
		dice.d[1][1] = temp;
	}
}

void dfs(int x, int y, int n, int w, vector<vector<int>> map,int va) {
	if (x < 0 || x >= w || y < 0 || y >= n)
		return;
	if (ch[y][x] == 1)
		return;
	if (map[y][x] != va)
		return;
	if (map[y][x] == va)
		cnt++, ch[y][x] = 1;

	for (int i = 0; i < 4; i++) {
		int nx = x + dx[i];
		int ny = y + dy[i];
		dfs(nx, ny, n, w, map, va);
	}


}

void dicehead(dice& dice,int n) {
	if (dice.d[3][1] > n) {
		if (dice.head == 'R')
			dice.head = 'D';
		else if (dice.head == 'D')
			dice.head = 'L';
		else if (dice.head == 'L')
			dice.head = 'U';
		else if (dice.head == 'U')
			dice.head = 'R';
	}
	else if (dice.d[3][1] < n) {
		if (dice.head == 'R')
			dice.head = 'U';
		else if (dice.head == 'U')
			dice.head = 'L';
		else if (dice.head == 'L')
			dice.head = 'D';
		else if (dice.head == 'D')
			dice.head = 'R';
	}
}

int main(void) {
	int n, w, c;
	cin >> n >> w >> c;
	vector<vector<int>> map(n, vector<int>(w));
	for (int i = 0; i < n; i++) 
		for (int j = 0; j < w; j++) 
			cin >> map[i][j];

	dice dice;
	int total = 0;



	for (int i = 0; i < c; i++) {
		for (int i = 0; i < n; i++)
			for (int j = 0; j < w; j++)
				ch[i][j] = 0;
		cnt = 0;
		move(dice, n, w);                       //주사위 이동 함수
		int va = map[dice.y][dice.x];
		chanedice(dice);                        //주사위 면 바꾸기
		dfs(dice.x, dice.y, n, w,map,va);
		dicehead(dice,va);
		//cout <<dice.y+1<<" "<<dice.x+1<<" head : "<<dice.head <<" score : "<<va<<" dice Bottom : "<<dice.d[3][1] << " " << cnt << "\n";

		total += cnt * va;
	}
	cout << total;
		
	

	return 0;
}