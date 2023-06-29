#include <iostream>
#include <deque>
using namespace std;

class Point {
public:
    int y, x;
    Point(int y, int x)
        : y(y), x(x) {}
};

int main() {
    int k;
    int dx[4] = { 1,0,-1,0 };
    int dy[4] = { 0,1,0,-1 };

    int board[102][102] = { 0, }; // 꼬리, 벽 = 2, 사과는 1
    board[1][1] = 2;
    char commandContainer[10001] = { "", };
    int appleCount;
    int direction = 0;
    int x, y;
    cin >> k;
    for (int i = 0; i <= k+1; i++) {
        if (i == 0 || i == k+1) {
            for (int j = 0; j <= k+1; j++)
                board[i][j] = 2;
        }
        else
            board[i][0] = board[i][k+1] = 2;
    }
    cin >> appleCount;
    while (appleCount--) {
        cin >> y >> x;
        board[y][x] = 1;
    }
    int commandCount;
    cin >> commandCount;
    while (commandCount--) {
        int time;
        char ch;
        cin >> time >> ch;
        commandContainer[time] = ch;
    }

    deque<Point> dq;
    int timer = 1;
    int currentX = 1, currentY = 1;
    int tailCount = 1;
    dq.push_back(Point(currentY, currentX));
    while (true) {
        if (board[currentY + dy[direction]][currentX + dx[direction]] == 2)
            break;
        else {
            Point temp = dq.front();
            currentX += dx[direction];
            currentY += dy[direction];
            if(board[currentY][currentX] != 1){
                dq.pop_front();
                board[temp.y][temp.x] = 0;
            }
            dq.push_back(Point(currentY, currentX));
            board[currentY][currentX] = 2;
        }
        if (commandContainer[timer] != NULL) {
            if (commandContainer[timer] == 'D') {
                direction = (direction + 1) % 4;
            }
            else if (commandContainer[timer] == 'L') {
                direction = (direction - 1 + 4) % 4;
            }
        }
        timer++;
    }
    cout << timer << endl;
}