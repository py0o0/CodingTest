#include <iostream>
#include <vector>
#include <algorithm>
#include <climits>
#include <queue>

using namespace std;

int dj[8] = { 0,-1,-1,-1,0,1,1,1 };
int di[8] = { -1,-1,0,1,1,1,0,-1 };
int total;

struct fish {
	int i;
	int j;
	int dir;
	int dead;
};

void fish_move(vector<vector<int>>& map, vector<fish> &f, fish shark) {
	for (int i = 1; i <= 16; i++) {
		if (f[i].dead == 0) {
			int j = 0;
			for (; j < 8; j++) {
				int ni = f[i].i + di[(f[i].dir + j) % 8];
				int nj = f[i].j + dj[(f[i].dir + j) % 8];
			
				if (ni < 0 || ni >= 4 || nj < 0 || nj >= 4)
					continue;
				if (ni == shark.i && nj == shark.j)
					continue;

				if (map[ni][nj] == 0) {
					map[f[i].i][f[i].j] = 0;
					map[ni][nj] = i;
					f[i].i = ni;
					f[i].j = nj;
					break;
				}
				else if (map[ni][nj] > 0) {
					int temp = map[ni][nj];
					map[ni][nj] = i;
					map[f[i].i][f[i].j] = temp;
					int a = f[i].i;
					int b = f[i].j;
					f[i].i = ni;
					f[i].j = nj;
					f[temp].i = a;
					f[temp].j = b;
					break;
				}

			}
			f[i].dir = (f[i].dir + j) % 8;
		}
		
	}
}

void dfs(vector<vector<int>> map, vector<fish> f, fish shark,int score) {

	if (map[shark.i][shark.j] == 0) {
		total = max(total, score);
		return;
	}

	int temp = map[shark.i][shark.j];
	f[temp].dead = 1;
	score += temp;
	shark.dir = f[temp].dir;
	map[shark.i][shark.j] = 0;

	fish_move(map, f, shark);

	/*cout << "\n";
	for (int i = 0; i < 4; i++) {
		for (int j = 0; j < 4; j++)
			cout << map[i][j] << " ";
		cout << "\n";
	}
	cout << shark.i << ", " << shark.j << " " << shark.dir << "    " <<score<< "\n";*/

	for (int i = 0; i < 4; i++) {
		shark.i += di[shark.dir] ;
		shark.j += dj[shark.dir] ;

		int ni = shark.i;
		int nj = shark.j;

		if (ni < 0 || ni >= 4 || nj < 0 || nj >= 4) {
			total = max(total, score);
			break;
		}
		dfs(map, f, shark, score);
	}
}

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	
	fish shark;
	vector<vector<int>> map(4, vector<int>(4));
	vector<fish> f(17);
	for(int i=0;i<4;i++)
		for (int j = 0; j < 4; j++) {
			int dir;
			cin >> map[i][j] >> dir;
			f[map[i][j]].i = i;
			f[map[i][j]].j = j;
			f[map[i][j]].dir = dir - 1;
			
		}
	
	shark.i = 0;
	shark.j = 0;

	dfs(map, f, shark, 0);

	cout << total;

}
