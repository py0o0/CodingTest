#include <iostream>
#include <vector>
#include <algorithm>
#include <climits>
#include <queue>

using namespace std;

int m[12][12];

int main(void) {

	queue<pair<pair<int, int>,int>> R;
	queue<pair<pair<int, int>,int>> B;

	int a, b;
	cin >> a >> b;
	for (int i = 1; i <= a; i++) {
		for (int j = 1; j <= b; j++) {
			char s;
			cin >> s;
			m[i][j] = s;
			if (s == 'R')
				R.push(make_pair(make_pair(i, j),0));
			if (s == 'B')
				B.push(make_pair(make_pair(i, j),0));
		}
	}

	

	int cnt = 0;
	int suc = 0, fail = 0;
	while (R.size() != 0&&B.size()!=0) {
		for (int o = 0; o < 4; o++) {
			int Rf = R.front().first.first;
			int Rs = R.front().first.second;

			int Bf = B.front().first.first;
			int Bs = B.front().first.second;

			fail = 0;

			if (o == 0) {
				for (int i = 1; i <= a; i++) {
					if (m[Rf + 1][Rs] != '#' && (Rf + 1 != Bf || Rs != Bs)) {
						if (m[Rf + 1][Rs] == 'O')
							suc = 1;
						Rf += 1;
					}
					
					if (m[Bf + 1][Bs] != '#'){ 
						if (Bf + 1 != Rf || Bs != Rs) {
							if (m[Bf + 1][Bs] == 'O')
								fail = 1;
							Bf += 1;
						}
						else {
							if (m[Bf + 1][Bs] == 'O'){
								fail = 1; 
								Bf += 1;
							}
						}

					}
					
					if (fail == 1) {
						suc = 0;
						break;
					}

				}
			}

			else if (o == 1) {
				for (int i = 1; i <= a; i++) {
					if(m[Rf -1][Rs] != '#' && (Rf - 1 != Bf || Rs != Bs)) {
						if (m[Rf - 1][Rs] == 'O')
							suc = 1;
						Rf -= 1;
					}

					if (m[Bf - 1][Bs] != '#' ){
						if (Bf - 1 != Rf || Bs != Rs) {
							if (m[Bf - 1][Bs] == 'O')
								fail = 1;
							Bf -= 1;
						}
						else {
							if (m[Bf - 1][Bs] == 'O') {
								fail = 1;
								Bf -= 1;
							}
						}
						
					}

					if (fail == 1) {
						suc = 0;
						break;
					}
				}
			}

			else if (o == 2) {
				for (int i = 1; i <= b; i++) {
					if (m[Rf][Rs+1] != '#' && (Rf != Bf ||Rs+1 != Bs)) {
						if (m[Rf][Rs+1] == 'O')
							suc = 1;
						Rs += 1;
					}

					if (m[Bf][Bs+1] != '#') {
						if (Bf != Rf || Bs+1 != Rs) {
							if (m[Bf ][Bs+1] == 'O')
								fail = 1;
							Bs += 1;
						}
						else {
							if (m[Bf][Bs+1] == 'O') {
								fail = 1;
								Bs += 1;
							}
						}

					}

					if (fail == 1) {
						suc = 0;
						break;
					}
				}
			}

			else if (o == 3) {
				for (int i = 1; i <= b; i++) {
					if (m[Rf][Rs - 1] != '#' && (Rf != Bf || Rs - 1 != Bs)) {
						if (m[Rf][Rs - 1] == 'O')
							suc = 1;
						Rs -= 1;
					}

					if (m[Bf][Bs - 1] != '#') {
						if (Bf != Rf || Bs - 1 != Rs) {
							if (m[Bf][Bs - 1] == 'O')
								fail = 1;
							Bs -= 1;
						}
						else {
							if (m[Bf][Bs - 1] == 'O') {
								fail = 1;
								Bs -= 1;
							}
						}

					}

					if (fail == 1) {
						suc = 0;
						break;
					}
				}
			}

			

			if (fail != 1) {

				R.push(make_pair(make_pair(Rf, Rs), R.front().second + 1));
				B.push(make_pair(make_pair(Bf, Bs), B.front().second + 1));
			}

			if (suc == 1)
				break;

		}
		R.pop();
		B.pop();
		
		
		if (R.back().second >10 || suc == 1)
			break;
	}
	if (suc == 1) {
			cout << R.back().second ;
	}

	else
		cout << -1;


	return 0;
}

