#include <iostream>
using namespace std;
#define MIN_INT     (-2147483647 - 1)
#define MAX_INT       2147483647
int input[101][101] = { 0, }; // 높이가 있는 원본
int graph[101][101] = { 0, }; // 잠긴 곳과 잠기지 않은 곳을 나타낸 그래프 0,1
int visited[101][101] = { 0, };
int n;
int maxCount = MIN_INT;
int dx[4] = { 1,0,-1,0 };
int dy[4] = { 0,-1,0,1 };
void setGraph(int waterHeight) {
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            visited[i][j] = 0;
            if (input[i][j] > waterHeight)
                graph[i][j] = 1;
            else
                graph[i][j] = 0;
        }
    }
}

void dfs(int y, int x) {
    if (x < 0 || x >= n || y < 0 || y >= n)
        return;
    visited[y][x] = 1;

    for (int i = 0; i < 4; i++) {
        int tempX = dx[i] + x;
        int tempY = dy[i] + y;
        if (tempX < 0 || tempX > n || tempY < 0 || tempY > n)
            continue;
        if (visited[tempY][tempX] == 0 && graph[tempY][tempX] == 1) {
            dfs(tempY, tempX);
        }
    }
}
int main() {
    cin >> n;
    int maxHeight = MIN_INT;
    int minHeight = MAX_INT;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            cin >> input[i][j];
            if (input[i][j] < minHeight)
                minHeight = input[i][j];
            if(input[i][j] > maxHeight)
                maxHeight = input[i][j];
        }
    }


    for (int height = minHeight - 1; height <= maxHeight; height++) {
        setGraph(height);
        int tempCount = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j] == 1 && visited[i][j] == 0) {
                    dfs(i, j);
                    tempCount++;
                }
            }
        }
        maxCount = maxCount > tempCount ? maxCount : tempCount;
    }
    cout << maxCount << endl;
}