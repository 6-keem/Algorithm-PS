#include <iostream>
#include <queue>
using namespace std;

class Point {
public:
    int x, y;
    Point(int y, int x)
        : y(y), x(x) { }
};
int graph[1001][1001] = { 0, };
int visited[1001][1001] = { 0, };
int dx[4] = { 1,0,-1,0 };
int dy[4] = { 0,-1,0,1 };
int n, m;
queue<Point> q;
void bfs() {
    while (!q.empty()) {
        Point temp = q.front();
        q.pop();
        for (int i = 0; i < 4; i++) {
            int tempX = temp.x + dx[i];
            int tempY = temp.y + dy[i];
            if (tempX < 0 || tempX >= m || tempY < 0 || tempY >= n)
                continue;
            if (graph[tempY][tempX] == 0) {
                graph[tempY][tempX] = graph[temp.y][temp.x] +1;
                q.push(Point(tempY, tempX));
            }
        }
    }
}
int main() {
    cin >> m >> n;
    int count = 0;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            cin >> graph[i][j];
            if (graph[i][j] == 1)
                q.push(Point(i, j));
        }
    }
   
    bfs();
    int ans = 0;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            if (graph[i][j] == 0) {
                cout << -1 << endl;
                return 0;
            }
            if (ans < graph[i][j]) {
                ans = graph[i][j];
            }
        }
    }
    cout << ans - 1 << endl;
    return 0;
}