#include <iostream>
#include <algorithm>
using namespace std;

int graph[101][101] = { 0, };
int visited[101][101] = { 0, };
int dx[4] = { 1,0,-1,0 };
int dy[4] = { 0,-1,0,1 };
int indexCount = 0;
int answer[101] = { 0, };
int n, m, k;

void dfs(int y, int x) {
    visited[y][x] = 1;
    for (int i = 0; i < 4; i++) {
        int tempX = x + dx[i];
        int tempY = y + dy[i];

        if (tempX < 0 || tempX >= m || tempY < 0 || tempY >= n)
            continue;
        if (visited[tempY][tempX] == 0 && graph[tempY][tempX] == 0) {
            answer[indexCount]++;
            dfs(tempY, tempX);
        }
    }
}
int main() {
    cin >> n >> m >> k;

    for (int i = 0; i < k; i++) {
        int x1, y1, x2, y2;
        cin >> x1 >> y1 >> x2 >> y2;
        for (int j = y1; j < y2; j++) {
            for (int z = x1; z < x2; z++) {
                graph[j][z] = 1;
            }
        }
    }

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            if (visited[i][j] == 0 && graph[i][j] == 0) {
                dfs(i, j);
                indexCount++;
            }
        }
    }
    sort(answer, answer + indexCount);
    cout << indexCount << endl;
    for (int i = 0; i < indexCount; i++)
        cout << answer[i] + 1 << ' ';
    cout << endl;
}