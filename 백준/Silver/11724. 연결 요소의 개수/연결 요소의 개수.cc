#include <iostream>
using namespace std;

int graph[1001][1001] = { 0, };
int visited[1001] = { 0, };
int n, m;

void dfs(int v, int N) {
    visited[v] = 1;
    for (int i = 1; i <= N; i++) {
        if (graph[v][i] == 1 && visited[i] == 0) {
            dfs(i, N);
        }
    }
    return;
}
int main() {
    int count = 0;
    cin >> n >> m;
    int x, y;
    for (int i = 0; i < m; i++) {
        cin >> x >> y;
        graph[x][y] = 1;
        graph[y][x] = 1;
    }

    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
            if (graph[i][j] == 1 && visited[j] == 0) {
                dfs(i, n);
                count++;
            }
        }
    }
    for (int i = 1; i <= n; i++) {
        if (visited[i] == 0)
            count++;
    }
    cout << count << endl;
}