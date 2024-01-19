#include <iostream>
#include <vector>
#include <algorithm>
#include <string>

using namespace std;

int total;

void bllizard(vector<pair<int, int>> bll, vector<vector<int>>&map, int n, int d) {
	
	int x = n / 2;
	int y = n / 2;

	for (int i = 0; i < bll[d].second; i++) {
		if (bll[d].first == 1) {                  //위
			y -= 1;
			map[y][x] = 0;
		}
		else if (bll[d].first == 2) {             //아래
			y += 1;
			map[y][x] = 0;
		}
		else if (bll[d].first == 3) {             //왼
			x -= 1;
			map[y][x] = 0;
		}
		else if (bll[d].first == 4) {             //오
			x += 1;
			map[y][x] = 0;
		}

	}
}

void moving(vector<vector<int>> &map,vector<pair<int,int>> s,int i,int n,int &move) {
	move = 0;
	for (int j = i + 1; j < n * n; j++) {
		if (map[s[j].second][s[j].first] != 0)
			move = 1;
		map[s[j - 1].second][s[j - 1].first] = map[s[j].second][s[j].first];
	}
	map[0][0] = 0;
}

void boom(vector<vector<int>>& map, vector<pair<int, int>> s, int n,int &Boom) {
	int cnt = 0;
	Boom = 0;

	int diff_va = map[s[1].second][s[1].first];
	int j = 1;
	for (int i = 1; i < n * n; i++) {
		int map_va = map[s[i].second][s[i].first];

		if (map_va == diff_va) 
			cnt++;
		else {
			if (cnt > 3) {
				for (; j < i; j++) {
					map[s[j].second][s[j].first] = 0;
				}
				Boom = 1;
				total += diff_va * cnt;
			}
			cnt = 1;
		}
		
		if (diff_va != map_va) {
			diff_va = map_va;
			j = i;
		}

	}
}

void change(vector<vector<int>>& map, vector<pair<int, int>> s,int n) {
	vector<vector<int>> cor(n, vector<int>(n));

	int diff_va = map[s[1].second][s[1].first];
	int j = 1;
	int cnt = 0;
	for (int i = 1; i < n * n; i++) {
		int map_va = map[s[i].second][s[i].first];

		if (map_va == diff_va)
			cnt++;

		if (map_va != diff_va) {
			cor[s[j].second][s[j].first]= cnt;
			j++;
			
			if (j >= n * n)
				break;
			cor[s[j].second][s[j].first] = diff_va;
			j++;

			cnt = 1;
			diff_va = map_va;
		}

		if (j >= n * n)
			break;
	}

	for (int i = 0; i < n; i++)
		for (int j = 0; j < n; j++)
			map[i][j] = cor[i][j];

}

int main(void) {
	int n, times;
	cin >> n >> times;
	vector<vector<int>> map(n, vector<int>(n));
	vector<pair<int, int>> s(n * n);
	vector<pair<int, int>> bll(times);
	for (int i = 0; i < n; i++)
		for (int j = 0; j < n; j++)
			cin >> map[i][j];
	
	for (int i = 0; i < times; i++)
		cin >> bll[i].first >> bll[i].second;
	

	int x = n / 2;
	int y = n / 2;
	s[0].first = x;
	s[0].second = y;
	s[1].first = x-1;
	s[1].second = y;
	s[2].first = x-1;
	s[2].second = y+1;
	x -= 1;
	y += 1;

	int cnt = 2;
	int total_cnt = 0;
	char head = 'R';
	for (int i = 3; i < n * n; ) {
		if (i != n * n - n + 1 && total_cnt == 2)
			cnt++, total_cnt = 0;
		else if (i == n * n - n + 1)
			total_cnt = 0;
		if (head == 'R') {
			for (int j = 0; j < cnt; j++) {
				x += 1;
				s[i].first = x;
				s[i].second = y;
				i++;
			}
			head = 'U';
		}
		else if (head == 'U') {
			for (int j = 0; j < cnt; j++) {
				y -= 1;
				s[i].first = x;
				s[i].second = y;
				i++;
			}
			head = 'L';
		}
		else if (head == 'L') {
			for (int j = 0; j < cnt; j++) {
				x -= 1;
				s[i].first = x;
				s[i].second = y;
				i++;
			}
			head = 'D';
		}
		else if (head == 'D') {
			for (int j = 0; j < cnt; j++) {
				y += 1;
				s[i].first = x;
				s[i].second = y;
				i++;
			}
			head = 'R';
		}
		total_cnt++;
	}

	/*cout << "\n";
	for (int i = 0; i < n*n; i++) {
		
			cout << map[s[i].second][s[i].first] << " ";
		
	}*/

	for (int i = 0; i < times; i++) {
		int move = 1;

		bllizard(bll, map, n, i);                               //블리자드

		for (int j = 1; j < n * n; j++) {                       //블리자드로 인한 한칸 땡기기
			if (map[s[j].second][s[j].first] == 0 && j != 0) {
				moving(map, s, j, n, move);
				if (move == 0)
					break;
			}
		}

		while (1) {                                              //boom!
			int Boom = 0;
			boom(map, s, n, Boom);

			if (Boom == 0)
				break;

			for (int j = 1; j < n * n; j++) {                    //boom으로 인한 땡기기
				if (map[s[j].second][s[j].first] == 0 && j != 0) {
					moving(map, s, j, n, move);
					j--;
					if (move == 0)
						break;
				}
			}
		}
		
		change(map, s, n);                                        //맵 수정

		/*cout << "\n";
		for (int k = 0; k < n; k++) {
			for (int j = 0; j < n; j++)
				cout << map[k][j] << " ";
			cout << "\n";
		}*/

	}
	cout << total;
}