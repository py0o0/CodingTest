#include <iostream>
#include <vector>
#include <algorithm>
#include <climits>
#include <queue>

using namespace std;

struct xy {
	int i;
	int j;
};

int map[9][9];
int di[4] = { 1,-1,0,0 };
int dj[4] = { 0,0,1,-1 };
int total = INT_MAX;

void cctv(vector<xy> v,int n,int m,int x) {
	if (x > v.size())
		return;

	if (x == v.size()) {     //모든 감시카메라 작동하여 맵의 사각지대 확인
		int cnt = 0;
		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				if (map[i][j] == 0)             //사각지대
					cnt++;                  
		total = min(cnt, total);

		return;
	}

	if (map[v[x].i][v[x].j] == 1) {                       //1번 감시 카메라의 감시하는 경우는 4가지
		for (int i = 0; i < 4; i++) {
			int ni = v[x].i + di[i];
			int nj = v[x].j + dj[i];
			vector<xy> t;
			while (1) {
				if (ni < 0 || ni >= n || nj < 0 || nj >= m)
					break;
				if (map[ni][nj] == 6)
					break;
				else if (map[ni][nj] == 0) {   //확인할 수 있는 영역은 7로 기록
					map[ni][nj] = 7;
					t.push_back({ ni,nj });
				}                
				ni += di[i];
				nj += dj[i];

			}
			cctv(v, n, m, x + 1);
			for (int j = 0; j < t.size(); j++)
				map[t[j].i][t[j].j] = 0;

		}
	}
	else if (map[v[x].i][v[x].j] == 2) {              //2번 카메라의 감시하는 경우는 2가지
		for (int i = 0; i < 2; i++) {
			if (i == 1)
				i = 2;
			int ni1 = v[x].i + di[i];
			int nj1 = v[x].j + dj[i];
			int ni2 = v[x].i + di[i + 1];
			int nj2 = v[x].j + dj[i + 1];
			int fail1 = 0;
			int fail2 = 0;
			vector<xy> t;
			while (1) {
				if (fail1 == 1 && fail2 == 1)
					break;
				if (ni1 < 0 || ni1 >= n || nj1 < 0 || nj1 >= m)
					fail1 = 1;
				if (map[ni1][nj1] == 6)
					fail1 = 1;
				if (ni2 < 0 || ni2 >= n || nj2 < 0 || nj2 >= m)
					fail2 = 1;
				if (map[ni2][nj2] == 6)
					fail2 = 1;
				if (fail1==0&&map[ni1][nj1] == 0) {   
					map[ni1][nj1] = 7;
					t.push_back({ ni1,nj1 });
					
				}
				if (fail2 == 0 && map[ni2][nj2] == 0) {
					map[ni2][nj2] = 7;
					t.push_back({ ni2,nj2 });

				}
				if (fail1 == 0) {
					ni1 += di[i];
					nj1 += dj[i];
				}
				if (fail2 == 0) {
					ni2 += di[i + 1];
					nj2 += dj[i + 1];
				}
			}
	
			cctv(v, n, m, x + 1);
			for (int j = 0; j < t.size(); j++)
				map[t[j].i][t[j].j] = 0;
		}
	}

	else if (map[v[x].i][v[x].j] == 3) {              //3번 카메라의 감시하는 경우는 4가지
		for (int i = 0; i < 2; i++) {
			for (int k = 2; k < 4; k++) {
				int ni = v[x].i + di[i];
				int nj = v[x].j + dj[i];
				vector<xy> t;
				while (1) {
					if (ni < 0 || ni >= n || nj < 0 || nj >= m)
						break;
					if (map[ni][nj] == 6)
						break;
					else if (map[ni][nj] == 0) {  
						map[ni][nj] = 7;
						t.push_back({ ni,nj });
					}
					ni += di[i];
					nj += dj[i];
				}
				ni = v[x].i + di[k];
				nj = v[x].j + dj[k];
				while (1) {
					if (ni < 0 || ni >= n || nj < 0 || nj >= m)
						break;
					if (map[ni][nj] == 6)
						break;
					else if (map[ni][nj] == 0) {
						map[ni][nj] = 7;
						t.push_back({ ni,nj });
					}
					ni += di[k];
					nj += dj[k];
				}
				
				cctv(v, n, m, x + 1);
				for (int j = 0; j < t.size(); j++)
					map[t[j].i][t[j].j] = 0;

			}
		}
	}

	else if (map[v[x].i][v[x].j] == 4) {              //4번 카메라의 감시하는 경우는 4가지
		for (int i = 0; i < 4; i++) {
			
				int ni = v[x].i + di[i];
				int nj = v[x].j + dj[i];
				vector<xy> t;
				while (1) {
					if (ni < 0 || ni >= n || nj < 0 || nj >= m)
						break;
					if (map[ni][nj] == 6)
						break;
					else if (map[ni][nj] == 0) {
						map[ni][nj] = 7;
						t.push_back({ ni,nj });
					}
					ni += di[i];
					nj += dj[i];
				}
				ni = v[x].i + di[(i + 1) % 4];
				nj = v[x].j + dj[(i + 1) % 4];
				while (1) {
					if (ni < 0 || ni >= n || nj < 0 || nj >= m)
						break;
					if (map[ni][nj] == 6)
						break;
					else if (map[ni][nj] == 0) {
						map[ni][nj] = 7;
						t.push_back({ ni,nj });
					}
					ni += di[(i + 1) % 4];
					nj += dj[(i + 1) % 4];
				}
				ni = v[x].i + di[(i + 2) % 4];
				nj = v[x].j + dj[(i + 2) % 4];
				while (1) {
					if (ni < 0 || ni >= n || nj < 0 || nj >= m)
						break;
					if (map[ni][nj] == 6)
						break;
					else if (map[ni][nj] == 0) {
						map[ni][nj] = 7;
						t.push_back({ ni,nj });
					}
					ni += di[(i + 2) % 4];
					nj += dj[(i + 2) % 4];
				}
				
				cctv(v, n, m, x + 1);
				for (int j = 0; j < t.size(); j++)
					map[t[j].i][t[j].j] = 0;
		}
	}

	else if (map[v[x].i][v[x].j] == 5) {              //5번 카메라의 감시하는 경우는 1가지
		vector<xy> t;
		for (int i = 0; i < 4; i++) {
			int ni = v[x].i + di[i];
			int nj = v[x].j + dj[i];
			while (1) {
				if (ni < 0 || ni >= n || nj < 0 || nj >= m)
					break;
				if (map[ni][nj] == 6)
					break;
				else if (map[ni][nj] == 0) {
					map[ni][nj] = 7;
					t.push_back({ ni,nj });
				}
				ni += di[i];
				nj += dj[i];
			}
		}

		cctv(v, n, m, x + 1);
		for (int j = 0; j < t.size(); j++)
			map[t[j].i][t[j].j] = 0;
	}
}

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	
	int n, m;
	cin >> n >> m;

	vector<xy> v;
	
	for(int i=0;i<n;i++)                        //모든 감시카메라의 좌표를 담음
		for (int j = 0; j < m; j++) {   
			cin >> map[i][j];
			if (map[i][j] > 0 && map[i][j] != 6)
				v.push_back({ i,j });
		}
	
	cctv(v,  n, m, 0);
	cout << total;	
	
}