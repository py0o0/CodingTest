#include <iostream>
#include <vector>
#include <algorithm>
#include <climits>
#include <queue>

using namespace std;



struct SN {
	vector<pair<int, int>> snake;
	char head;
};

int main(void) {
	int n;
	cin >> n;
	vector<vector<int>> map(n + 2, vector<int>(n + 2));
	int a;
	cin >> a;
	for (int i = 0; i < a; i++) {
		int x, y;
		cin >> x >> y;
		map[x][y] = 2;
	}
	queue<pair<int, char>> move;
	int m;
	cin >> m;
	for (int i = 0; i < m; i++) {
		int x;
		char s;
		cin >> x >> s;
		move.push(make_pair(x, s));
	}

	for (int i = 0; i < n + 2; i++)
		map[0][i] = 1, map[n + 1][i] = 1, map[i][0] = 1, map[i][n + 1] = 1;

	SN s;
	s.snake.push_back(make_pair(1, 1));
	s.head = 'R';

	int cnt = 0;
	while (1) {

		cnt++;


		int fx = s.snake[s.snake.size() - 1].first;
		int fy = s.snake[s.snake.size() - 1].second;

		for (int i = s.snake.size() - 1; i > 0; i--)      //몸의 움직임
			s.snake[i] = s.snake[i - 1];

		if (s.head == 'R')
			s.snake[0].second += 1;
		else if (s.head == 'L')
			s.snake[0].second -= 1;
		else if (s.head == 'U')
			s.snake[0].first -= 1;
		else if (s.head == 'D')
			s.snake[0].first += 1;


		if (move.size() > 0) {                            //방향 전환
			if (cnt == move.front().first) {                   //방향 전환 시간
				if (move.front().second == 'D') {
					if (s.head == 'R')
						s.head = 'D';
					else if (s.head == 'L')
						s.head = 'U';
					else if (s.head == 'U')
						s.head = 'R';
					else if (s.head == 'D')
						s.head = 'L';
				}
				else {
					if (s.head == 'R')
						s.head = 'U';
					else if (s.head == 'L')
						s.head = 'D';
					else if (s.head == 'U')
						s.head = 'L';
					else if (s.head == 'D')
						s.head = 'R';
				}
				move.pop();
			}
		}



		if (map[s.snake[0].first][s.snake[0].second] == 2) {   //사과 먹
			s.snake.push_back(make_pair(fx, fy));
			map[s.snake[0].first][s.snake[0].second] = 0;
		}



		if (map[s.snake[0].first][s.snake[0].second] == 1)   //벽 박
			break;

		int flag = 0;
		for (int i = 1; i < s.snake.size(); i++) {           //몸 박
			if (s.snake[0].first == s.snake[i].first && s.snake[0].second == s.snake[i].second)
				flag = 1;
		}
		if (s.snake[0].first == fx && s.snake[0].second == fy)
			flag = 1;

		if (flag == 1)
			break;

		

		/*for (int i = 0; i < s.snake.size(); i++)
			cout << s.snake[i].first << ", " << s.snake[i].second << " ";

		cout <<" "<<s.head << " " << cnt << " \n";*/

		
	}
	

	cout << cnt;

	return 0;
}
