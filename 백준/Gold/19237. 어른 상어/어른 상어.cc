#include <iostream>
#include <vector>
#include <algorithm>
#include <climits>
#include <queue>
#include <cstring>

using namespace std;


struct shark {
	int num;
	int x;
	int y;
	int d;
	int dir[4][4];
	int dead;
};

struct Map {
	int num;
	int smell;
};

struct cmp {
	bool operator()(shark& n1, shark& n2) {
		return n1.num > n2.num;
	}
};

int dx[] = { -1,1,0,0 };
int dy[] = { 0,0,-1,1 };
Map map[20][20];

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int n, m, k;
	cin >> n >> m >> k;
	vector<shark> v;
	priority_queue<shark, vector<shark>, cmp> pq;
	for (int i = 0; i < n; i++)
		for (int j = 0; j < n; j++) {
			cin >> map[i][j].num;
			if (map[i][j].num > 0)
				pq.push({ map[i][j].num,i,j,0,{0},0 });
		}

	while (pq.size() != 0) {
		v.push_back({ pq.top().num,pq.top().x,pq.top().y,0,{0},0 });
		pq.pop();
	}

	for (int i = 0; i < m; i++) {
		int a;
		cin >> a;
		v[i].d = a - 1;
		map[v[i].x][v[i].y].smell = k;
	}

	for (int i = 0; i < m; i++) 
		for (int j = 0; j < 4; j++) 
			for (int k = 0; k < 4; k++) {
				int a;
				cin >> a;
				v[i].dir[j][k] = a - 1;
			}


	int t = 1;
	int shark_cnt = m;
	while (1) {
		vector<shark> temp;
		for (int i = 0; i < m; i++) {                                        //상어 움직임
			if (v[i].dead == 1)
				continue;
			shark x = { 0,0,0,0,{0},0 };
			int x_flag = 0;
			int fail = 0;
			for (int j = 0; j < 4; j++) {
				int nx = v[i].x + dx[v[i].dir[v[i].d][j]];
				int ny = v[i].y + dy[v[i].dir[v[i].d][j]];
				if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
					if (j == 3)                                 //빈칸 없는 경우
						fail =1;
					continue;
				}
				
				if (map[nx][ny].num == v[i].num  && x_flag == 0) {                   //빈칸이 없는 경우 대비하여 우선순위 높은 자신의 칸 저장
					x.x = nx;
					x.y = ny;
					x.d = v[i].dir[v[i].d][j];
					x_flag = 1;
				}

				else if (map[nx][ny].num == 0) {                                    //빈칸을 우선적으로 찾으면 종료
					temp.push_back({ v[i].num,nx,ny,v[i].dir[v[i].d][j],{0}, 0 });
					break;
				}

				if (j == 3)                            //빈 칸 없는 경우
					fail = 1;
			}

			if (fail == 1)                                                         //빈칸 없을 시 우선순위 높은 자신의 칸으로 감
				temp.push_back({ v[i].num,x.x,x.y,x.d,{0}, 0 });

		}
		 
		for (auto s : temp) {                                            //상어끼리 겹치는 경우 처리
			if (map[s.x][s.y].num != 0 && map[s.x][s.y].num != s.num) {
				shark_cnt--;
				v[s.num - 1].dead = 1;
				continue;
			}
			map[s.x][s.y].num = s.num;
			map[s.x][s.y].smell = k+1;
			v[s.num - 1].x = s.x;
			v[s.num - 1].y = s.y;
			v[s.num - 1].d = s.d;
		}

		if (shark_cnt == 1) {                                          //1번 상어만 남앗으면 종료
			cout << t;
			break;
		}

		for(int i=0;i<n;i++)                                           //냄새 줄이기
			for (int j = 0; j < n; j++) 
				if (map[i][j].smell > 0) {
					map[i][j].smell--;
					if (map[i][j].smell == 0)
						map[i][j].num = 0;
				}

		if (t >= 1000) {
			cout << -1;
			break;
		}
		
		t++;
	}

	return 0;
}