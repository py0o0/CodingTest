#include <iostream>
#include <vector>
#include <algorithm>
#include <climits>
#include <queue>
#include <cstring>

using namespace std;

int map[20][20];
int visit[20][20];
vector<int>wall[20][20];

struct xyDir {                            // 온풍기의 좌표와 방향을 저장
	int i;
	int j;
	int dir;
};

int dirX[] = { 0,0,-1,1 };
int dirY[] = { 1,-1,0,0 };
int check[][3] = { {0,1,0} ,{0,1,0} ,{1,0,1},{1,0,1} };                 //방향에 따른 벽 확인 배열
int wall_checkX[][3] = { {0,0,1} ,{0,0,1} ,{0,0,0} ,{0,1,0} };
int wall_checkY[][3] = { {0,0,0 }, { 0,-1,0 } ,{0,0,-1},{0,0,-1} };
int dx[][3] = { { -1,0,1} ,{ -1,0,1} ,{-1,-1,-1},{1,1,1} };             // 방향에 따른 다음 좌표
int dy[][3] = { {1,1,1} ,{ -1,-1,-1 },{1,0,-1} ,{1,0,-1} };
int dirA[] = { 0 ,0,1,0 };                                              //뒤에 벽이 있나 없나 체크
int dirB[] = { -1 ,0,0,0 };
int wall_check[] = { 1,1,0,0 };
int dirX_2[] = { 0,0,0,1 };                                            //spread 에서 벽 확인 배열
int dirY_2[] = { 0,-1,0,0 };

void fan_wind(int x, int y, int r, int c, int cnt, int dir) {
	if (cnt < 1)
		return;
	if (x < 0 || x >= r || y < 0 || y >= c)
		return;
	if (visit[x][y] == 1)
		return;

	int wall_num[3] = { 0 };                                       //이동을 막는 벽은 총 3개
	for (int t = 0; t < 3; t++) {
		int nx = x + wall_checkX[dir][t];
		int ny = y + wall_checkY[dir][t];
		if (nx < 0 || nx >= r || ny < 0 || ny >= c)
			continue;
		for (int i = 0; i < wall[nx][ny].size(); i++) {
			if (wall[nx][ny][i] == check[dir][t])
				wall_num[t] = 1;
		}
	}

	int a = x + dirA[dir];
	int b = y + dirB[dir];
	for (int i = 0; i < wall[a][b].size(); i++) {                 //내 뒤가 벽이면 온도를 바꾸지 않음
		if (wall[a][b][i] == wall_check[dir])
			return;
	}

	visit[x][y] = 1;
	map[x][y] += cnt;

	for (int i = 0; i < 3; i++) {                                //벽으로 막히지 않는 경우 재귀
		int nx = x + dx[dir][i];
		int ny = y + dy[dir][i];
		if (nx < 0 || nx >= r || ny < 0 || ny >= c)
			continue;
		if (wall_num[i] == 1)
			continue;
		fan_wind(nx, ny, r, c, cnt - 1, dir);
	}

}

void spread(int r, int c) {
	int temp[20][20] = { 0, };

	for (int i = 0; i < r; i++)
		for (int j = 0; j < c; j++)
			temp[i][j] = map[i][j];

	for (int i = 0; i < r; i++)
		for (int j = 0; j < c; j++) {
			for (int k = 0; k < 4; k++) {
				int nx = i + dirX[k];
				int ny = j + dirY[k];
				if (nx < 0 || nx >= r || ny < 0 || ny >= c)
					continue;

				int wall_is = 0;
				int wallX = i + dirX_2[k];
				int wallY = j + dirY_2[k];

				if (wallX < 0 || wallX >= r || wallY < 0 || wallY >= c)
					wall_is = 0;
				else
					for (int t = 0; t < wall[wallX][wallY].size(); t++)
						if (wall[wallX][wallY][t] == wall_check[k])
							wall_is = 1;

				if (map[i][j] > map[nx][ny] && wall_is == 0) {                //벽이 없고 내 온도가 더 높을 시 확산
					temp[nx][ny] += (map[i][j] - map[nx][ny]) / 4;
					temp[i][j] -= (map[i][j] - map[nx][ny]) / 4;
				}
			}
		}

	for (int i = 0; i < r; i++)
		for (int j = 0; j < c; j++) {
			map[i][j] = temp[i][j];
			if (i == 0 || j == 0 || i >= r - 1 || j >= c - 1)
				if (map[i][j] > 0)
					map[i][j]--;                                 //테두리고 0도가 아닐시 -1
		}

}

int check_f(vector<xyDir>check_t, int k) {
	for (auto c : check_t)
		if (map[c.i][c.j] < k)
			return 0;
	return 1;
}

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int r, c, k;
	cin >> r >> c >> k;
	vector<xyDir>check_t;
	vector<xyDir>fan;
	for (int i = 0; i < r; i++)
		for (int j = 0; j < c; j++) {
			cin >> map[i][j];
			if (map[i][j] == 5) {
				map[i][j] = 0;
				check_t.push_back({ i,j,0 });
			}
			else if (map[i][j] > 0) {
				fan.push_back({ i,j,map[i][j] - 1 });
				map[i][j] = 0;
			}
		}
	int n;
	cin >> n;
	for (int i = 0; i < n; i++) {
		int a, b, c;
		cin >> a >> b >> c;
		wall[a - 1][b - 1].push_back(c);
	}
	int cnt = 1;
	while (1) {

		for (auto f : fan) {                                         //온풍기의 열전달
			for (int i = 0; i < r; i++)
				memset(visit[i], 0, sizeof(int) * c);
			fan_wind(f.i + dirX[f.dir], f.j + dirY[f.dir], r, c, 5, f.dir);
		}

		spread(r, c);                                                    //온도 조절

		if (check_f(check_t, k))                                         //종료 확인
			break;

		if (cnt == 100) {
			cout << 101;
			return 0;
		}

		cnt++;
	}

	
	cout << cnt;
	return 0;
}

