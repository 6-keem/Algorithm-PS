#include <iostream>
using namespace std;

int main() {
    int n;
    cin >> n;
    char ch;
    int maze[101][101] = { 0, };
    int x = 50, y = 50;
    maze[y][x] = 1;

    int up, down, left, right;
    up = down = left = right = 50;
    int direction = 0;
    for (int i = 0; i < n; i++) {
        cin >> ch;
        if (ch == 'R') direction++;
        else if (ch == 'L') direction--;
        if (direction < 0)
            (direction += 4) %= 4;
        else if (direction > 3)
            direction %= 4;

        if (ch == 'F') {
            switch (direction) {
            case 0:
                y++;
                if(y > down) 
                    down++;
                break;
            case 1:
                x--;
                if(x < right)
                    right--;
                break;
            case 2:
                y--;
                if(y < up)
                    up--;
                break;
            case 3:
                x++;
                if(x > left)
                    left++;
                break;
            }
            maze[y][x] = 1;
        }
    }

    for (int i = up; i <= down; i++) {
        for (int j = right; j <= left; j++) {
            if (maze[i][j] == 1)
                cout << '.';
            else
                cout << '#';
        }
        cout << endl;
    }
}