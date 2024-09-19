#include <iostream>
#include <string>
#include <queue>
using namespace std;

int m[11];
int an[11];

int main(void) {

    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;
    cin >> n;

    for (int i = 0; i < n; i++) {
        cin >> m[i];
        an[i] = -1;
    }
    
    for (int i = 0; i < n; i++) {
        int cur = m[i];
    
        int cnt = 0;
        for (int j = 0; j < n; j++) {
            if (cnt == cur) {
                while (an[j] != -1)
                    j++;
                an[j] = i + 1;
                break;
            }

            if (an[j] == -1)
                cnt++;

            }

        
    }

    for (int i = 0; i < n; i++)
        cout << an[i] << " ";
    
}

