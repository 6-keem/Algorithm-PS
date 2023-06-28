#include <iostream>
using namespace std;

int n, m;
char graph[51][51] = { "", };
int edx[6] = { -1,-1,-1,0,1,0 };
int odx[6] = { 0,-1,0,1,1,1 };
int dy[6] = { 1,0,-1,-1,0,1 };
int count = 0;
void calc() {
    for (int r = 0; r < n; r++) {
        for (int c = 0; c < m; c++) {
            if (graph[r][c] == '#')
                continue;
            int x, y;
            for (int i = 0; i < 6; i++) {
                if (r % 2 == 0) x = c + edx[i];
                else x = c + odx[i];
                y = r + dy[i];
                if (!(x < 0 || x >= m || y < 0 || y >= n)) {
                    if (graph[y][x] == '#')
                        ::count++;
                }
            }
        }
    }
}
int main() {
    cin >> n >> m;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            cin >> graph[i][j];
        }
        cin.ignore();
    }
    calc();
    cout << ::count << endl;
}