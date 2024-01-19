#include <iostream>
#include <vector>
#include <algorithm>
#include <string>
#include <cmath>
#include <climits>
#include <queue>

using namespace std;

void ro_1(vector<vector<vector<char>>> &cube,char dir, char lo) {
	if (dir == 'L') {
		if (lo == '+') {
			int temp[3] = { 0, };
			for (int i = 0; i < 3; i++)
				temp[i] = cube[0][i][0];
			for (int i = 0; i < 3; i++)
				cube[0][i][0] = cube[3][2-i][2];
			for (int i = 0; i < 3; i++)
				cube[3][i][2] = cube[1][i][0];
			for (int i = 0; i < 3; i++)
				cube[1][i][0] = cube[2][2 - i][0];
			for (int i = 0; i < 3; i++)
				cube[2][i][0] = temp[i];
		}
		else {
			int temp[3] = { 0, };
			for (int i = 0; i < 3; i++)
				temp[i] = cube[0][i][0];
			for (int i = 0; i < 3; i++)
				cube[0][i][0] = cube[2][i][0];
			for (int i = 0; i < 3; i++)
				cube[2][i][0] = cube[1][2 - i][0];
			for (int i = 0; i < 3; i++)
				cube[1][i][0] = cube[3][i][2];
			for (int i = 0; i < 3; i++)
				cube[3][i][2] = temp[2 - i];
		}
	}
	else if (dir == 'R') {
		if (lo == '+') {
			int temp[3] = { 0, };
			for (int i = 0; i < 3; i++)
				temp[i] = cube[0][i][2];
			for (int i = 0; i < 3; i++)
				cube[0][i][2] = cube[2][i][2];
			for (int i = 0; i < 3; i++)
				cube[2][i][2] = cube[1][2-i][2];
			for (int i = 0; i < 3; i++)
				cube[1][i][2] = cube[3][i][0];
			for (int i = 0; i < 3; i++)
				cube[3][i][0] = temp[2 - i];
		}
		else {
			int temp[3] = { 0, };
			for (int i = 0; i < 3; i++)
				temp[i] = cube[0][i][2];
			for (int i = 0; i < 3; i++)
				cube[0][i][2] = cube[3][2 - i][0];
			for (int i = 0; i < 3; i++)
				cube[3][i][0] = cube[1][i][2];
			for (int i = 0; i < 3; i++)
				cube[1][i][2] = cube[2][2 - i][2];
			for (int i = 0; i < 3; i++)
				cube[2][i][2] = temp[i];
		}
	}
	else if (dir == 'U') {
		if (lo == '+') {
			int temp[3] = { 0, };
			for (int i = 0; i < 3; i++)
				temp[i] = cube[2][0][i];
			for (int i = 0; i < 3; i++)
				cube[2][0][i] = cube[5][0][i];
			for (int i = 0; i < 3; i++)
				cube[5][0][i] = cube[3][0][i];
			for (int i = 0; i < 3; i++)
				cube[3][0][i] = cube[4][0][i];
			for (int i = 0; i < 3; i++)
				cube[4][0][i] = temp[i];
		}
		else {
			int temp[3] = { 0, };
			for (int i = 0; i < 3; i++)
				temp[i] = cube[2][0][i];
			for (int i = 0; i < 3; i++)
				cube[2][0][i] = cube[4][0][i];
			for (int i = 0; i < 3; i++)
				cube[4][0][i] = cube[3][0][i];
			for (int i = 0; i < 3; i++)
				cube[3][0][i] = cube[5][0][i];
			for (int i = 0; i < 3; i++)
				cube[5][0][i] = temp[i];
		}
	}
	else if (dir == 'D') {
		if (lo == '+') {
			int temp[3] = { 0, };
			for (int i = 0; i < 3; i++)
				temp[i] = cube[2][2][i];
			for (int i = 0; i < 3; i++)
				cube[2][2][i] = cube[4][2][i];
			for (int i = 0; i < 3; i++)
				cube[4][2][i] = cube[3][2][i];
			for (int i = 0; i < 3; i++)
				cube[3][2][i] = cube[5][2][i];
			for (int i = 0; i < 3; i++)
				cube[5][2][i] = temp[i];
		}
		else {
			int temp[3] = { 0, };
			for (int i = 0; i < 3; i++)
				temp[i] = cube[2][2][i];
			for (int i = 0; i < 3; i++)
				cube[2][2][i] = cube[5][2][i];
			for (int i = 0; i < 3; i++)
				cube[5][2][i] = cube[3][2][i];
			for (int i = 0; i < 3; i++)
				cube[3][2][i] = cube[4][2][i];
			for (int i = 0; i < 3; i++)
				cube[4][2][i] = temp[i];
		}
	}
	else if (dir == 'F') {
		if (lo == '+') {
			int temp[3] = { 0, };
			for (int i = 0; i < 3; i++)
				temp[i] = cube[0][2][i];
			for (int i = 0; i < 3; i++)
				cube[0][2][i] = cube[4][2-i][2];
			for (int i = 0; i < 3; i++)
				cube[4][i][2] = cube[1][2][i];
			for (int i = 0; i < 3; i++)
				cube[1][2][i] = cube[5][2-i][0];
			for (int i = 0; i < 3; i++)
				cube[5][i][0] = temp[i];
		}
		else {
			int temp[3] = { 0, };
			for (int i = 0; i < 3; i++)
				temp[i] = cube[0][2][i];
			for (int i = 0; i < 3; i++)
				cube[0][2][i] = cube[5][i][0];
			for (int i = 0; i < 3; i++)
				cube[5][2 - i][0] = cube[1][2][i];
			for (int i = 0; i < 3; i++)
				cube[1][2][i] = cube[4][i][2];
			for (int i = 0; i < 3; i++)
				cube[4][i][2] = temp[2 - i];
		}
	}
	else if (dir == 'B') {
		if (lo == '+') {
			int temp[3] = { 0, };
			for (int i = 0; i < 3; i++)
				temp[i] = cube[0][0][i];
			for (int i = 0; i < 3; i++)
				cube[0][0][i] = cube[5][i][2];
			for (int i = 0; i < 3; i++)
				cube[5][i][2] = cube[1][0][2 - i];
			for (int i = 0; i < 3; i++)
				cube[1][0][i] = cube[4][i][0];
			for (int i = 0; i < 3; i++)
				cube[4][i][0] = temp[2 - i];
		}
		else {
			int temp[3] = { 0, };
			for (int i = 0; i < 3; i++)
				temp[i] = cube[0][0][i];
			for (int i = 0; i < 3; i++)
				cube[0][0][i] = cube[4][2 - i][0];
			for (int i = 0; i < 3; i++)
				cube[4][i][0] = cube[1][0][i];
			for (int i = 0; i < 3; i++)
				cube[1][0][i] = cube[5][2-i][2];
			for (int i = 0; i < 3; i++)
				cube[5][i][2] = temp[i];
		}
	}
}

void ro_2(vector<vector<vector<char>>>& cube, char dir, char lo) {
	vector<vector<char>> temp(3, vector<char>(3));
	int k = 0;
	if (dir == 'L')
		k = 4;
	else if (dir == 'R')
		k = 5;
	else if (dir == 'U')
		k = 0;
	else if (dir == 'D') {
		k = 1;
		if (lo == '+')
			lo = '-';
		else
			lo = '+';
	}
	else if (dir == 'F')
		k = 2;
	else if (dir == 'B')
		k = 3;
	
	if (lo == '+') {
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				temp[j][2 - i] = cube[k][i][j];
	}
	else {
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				temp[2 - j][i] = cube[k][i][j];
	}
	

	for (int i = 0; i < 3; i++)
		for (int j = 0; j < 3; j++)
			cube[k][i][j] = temp[i][j];
}

int main(void) {
	int n;
	cin >> n;
	for (int t = 0; t < n; t++) {
		vector<vector<vector<char>>> cube
			= { {{'w','w','w'},{'w','w','w'},{'w','w','w'}},
			{{'y','y','y'},{'y','y','y'},{'y','y','y'}},
			{{'r','r','r'},{'r','r','r'},{'r','r','r'}},
			{{'o','o','o'},{'o','o','o'},{'o','o','o'}},
			{{'g','g','g'},{'g','g','g'},{'g','g','g'}},
		{{'b','b','b'},{'b','b','b'},{'b','b','b'}} };

		int num;
		cin >> num;
		vector<string> dir(num);
		for (int i = 0; i < num; i++) {
			cin >> dir[i];
		}

		for (int i = 0; i < num; i++) {
			ro_1(cube, dir[i][0], dir[i][1]);
			ro_2(cube, dir[i][0], dir[i][1]);
			/*cout << "\n";
			for (int o = 0; o < 6; o++) {
				for (int j = 0; j < 3; j++) {
					for (int k = 0; k < 3; k++)
						cout << cube[o][j][k];
						
					cout << "\n";
				}
				cout << "\n";
			}*/
		
			

		
		}

		//cout << "\n";
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++)
				cout << cube[0][i][j];
			cout << "\n";
		}
	}
}
