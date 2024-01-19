#include <iostream>
#include <vector>
#include <algorithm>
#include <climits>
#include <queue>

using namespace std;

int L_cnt;
int dx[4] = { 1,-1,0,0 };
int dy[4] = { 0,0,1,-1 };

struct xy {
	int x;
	int y;
};
int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int r, c;
	cin >> r >> c;
	vector<vector<char>> map(r, vector<char>(c));
	vector<xy> duck;
	queue<xy> melt;

	for (int i = 0; i < r; i++)
		for (int j = 0; j < c; j++) {
			cin >> map[i][j];
			if (map[i][j] == 'L')
				duck.push_back({ j,i });
			if (map[i][j] != 'X')
				melt.push({ j,i });
		}
	int cnt = 0;
	queue<xy> find;
	find.push({ duck[0].x,duck[0].y });
	vector<vector<int>> visit(r, vector<int>(c));
	while (1) {
		int breaking = 0;
		queue<xy> temp;
		while (find.size() != 0) {
		
			for (int i = 0; i < 4; i++) {
				int nx = find.front().x + dx[i];
				int ny = find.front().y + dy[i];
				if (nx < 0 || ny < 0 || nx >= c || ny >= r)
					continue;
				if (ny == duck[1].y && nx == duck[1].x) {
					breaking = 1;
					break;
				}
				if (visit[ny][nx] == 1)
					continue;
				visit[ny][nx] = 1;
				if (map[ny][nx] == 'X') {
					temp.push({ nx,ny });
				}
				if (map[ny][nx] != 'X') {
					find.push({ nx,ny });
				}
			}
			find.pop();
			if (breaking)
				break;

		}

		if (breaking)
			break;

		while (temp.size() != 0) {
			xy tmp = temp.front();
			temp.pop();
			find.push(tmp);
		}

		

		int a = melt.size();
		while (a != 0) {

			for (int i = 0; i < 4; i++) {
				int nx = melt.front().x + dx[i];
				int ny = melt.front().y + dy[i];
				if (nx < 0 || ny < 0 || nx >= c || ny >= r)
					continue;
				if (map[ny][nx] != 'X')
					continue;
				melt.push({ nx,ny });
				map[ny][nx] = '.';
			}
			melt.pop();
			a--;
		}



		/*cout << "------\n";
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++)
				cout << map[i][j];
			cout << "\n";
		}*/

		cnt++;
	}
	cout << cnt;

}