#include <iostream>
#include <vector>
#include <algorithm>
#include <string>


using namespace std;

int dx[4] = { 1,1,-1,-1 };
int dy[4] = { 1,-1,1,-1 };

void moving(vector<pair<int, int>> move, vector<pair<int, int>>& cloud, int i,int n) {
	if (move[i].first == 1) {  //왼
		for (int j = 0; j < move[i].second; j++) {
			for (int k = 0; k < cloud.size(); k++) {
				cloud[k].first -= 1;
				if (cloud[k].first < 0)
					cloud[k].first = n - 1;
			}
		}
	}
	else if (move[i].first == 2) {  //왼상
		for (int j = 0; j < move[i].second; j++) {
			for (int k = 0; k < cloud.size(); k++) {
				cloud[k].first -= 1;
				cloud[k].second -= 1;
				if (cloud[k].first < 0)
					cloud[k].first = n - 1;
				if (cloud[k].second < 0)
					cloud[k].second = n - 1;
			}
		}
	}
	else if (move[i].first == 3) {  //상
		for (int j = 0; j < move[i].second; j++) {
			for (int k = 0; k < cloud.size(); k++) {
				
				cloud[k].second -= 1;
				
				if (cloud[k].second < 0)
					cloud[k].second = n - 1;
			}
		}
	}
	else if (move[i].first == 4) {  //우상
		for (int j = 0; j < move[i].second; j++) {
			for (int k = 0; k < cloud.size(); k++) {
				cloud[k].first += 1;
				cloud[k].second -= 1;
				if (cloud[k].first >= n)
					cloud[k].first = 0;
				if (cloud[k].second < 0)
					cloud[k].second = n - 1;
			}
		}
	}
	else if (move[i].first == 5) {  //우
		for (int j = 0; j < move[i].second; j++) {
			for (int k = 0; k < cloud.size(); k++) {
				cloud[k].first += 1;
				
				if (cloud[k].first >= n)
					cloud[k].first = 0;
			}
		}
	}
	else if (move[i].first == 6) {  //우하
		for (int j = 0; j < move[i].second; j++) {
			for (int k = 0; k < cloud.size(); k++) {
				cloud[k].first += 1;
				cloud[k].second += 1;
				if (cloud[k].first >= n)
					cloud[k].first = 0;
				if (cloud[k].second >= n)
					cloud[k].second = 0;
			}
		}
	}
	else if (move[i].first == 7) {  //하
		for (int j = 0; j < move[i].second; j++) {
			for (int k = 0; k < cloud.size(); k++) {
				cloud[k].second += 1;
				if (cloud[k].second >= n)
					cloud[k].second = 0;
			}
		}
	}
	else if (move[i].first == 8) {  //왼하
		for (int j = 0; j < move[i].second; j++) {
			for (int k = 0; k < cloud.size(); k++) {
				cloud[k].first -= 1;
				cloud[k].second += 1;
				if (cloud[k].first < 0)
					cloud[k].first = n - 1;
				if (cloud[k].second >= n)
					cloud[k].second = 0;
			}
		}
	}
}

void water(vector<vector<int>> &map,vector<pair<int, int>> cloud,int n){
	for (int i = 0; i < cloud.size(); i++) {
		for (int j = 0; j < 4; j++) {
			int nx = cloud[i].first + dx[j];
			int ny = cloud[i].second + dy[j];

			if (nx < 0 || nx >= n || ny < 0 || ny >= n)
				continue;

			if (map[ny][nx] != 0)
				map[cloud[i].second][cloud[i].first]++;

		}
	}
}

void create(vector<vector<int>>& map,vector<pair<int, int>>& cloud, int n) {
	vector<vector<int>> ch(n, vector<int>(n));

	for (int i = 0; i < cloud.size(); i++) 
		ch[cloud[i].second][cloud[i].first] = 1;
	
	cloud.clear();

	for(int i=0;i<n;i++)
		for (int j = 0; j < n; j++) {
			if (map[i][j] >= 2 && ch[i][j] == 0) {
				cloud.push_back(make_pair(j, i));
				map[i][j] -= 2;
			}
		}
}

int main(void) {
	
	int n, w, cx, cy, cnt;
	cin >> n >> w;
	vector<vector<int>> map(n, vector<int>(n));

	for (int i = 0; i < n; i++)
		for (int j = 0; j < n; j++)
			cin >> map[i][j];

	vector<pair<int, int>> move(w);

	for (int i = 0; i < w; i++) {
		cin >> move[i].first >> move[i].second;
	}

	vector<pair<int, int>> cloud;

	cloud.push_back(make_pair(0, n - 1));
	cloud.push_back(make_pair(1, n - 1));
	cloud.push_back(make_pair(0, n - 2));
	cloud.push_back(make_pair(1, n - 2));

	for (int i = 0; i < w; i++) {
		moving(move, cloud, i, n);

		for (int k = 0; k < cloud.size(); k++)
			map[cloud[k].second][cloud[k].first] += 1;

		water(map, cloud, n);

		create(map, cloud,  n);

	}
	int sum = 0;
	for (int i = 0; i < n; i++)
		for (int j = 0; j < n; j++)
			sum += map[i][j];
	cout << sum;
	
}
	