#include <iostream>
using namespace std;
#define MAX_INT 2147483647
int main() {
    int data[1001][3] = { 0, };
    int dp[1001][3] = { 0, };
    int n;
    cin >> n;

    for (int i = 1; i <= n; i++) {
        for (int j = 0; j < 3; j++) {
            cin >> data[i][j];
        }
        dp[i][0] = min(dp[i - 1][1], dp[i - 1][2]) + data[i][0];
        dp[i][1] = min(dp[i - 1][0], dp[i - 1][2]) + data[i][1];
        dp[i][2] = min(dp[i - 1][0], dp[i - 1][1]) + data[i][2];
    }

    int min = MAX_INT;
    for (int i = 0; i < 3; i++) {
        if (min > dp[n][i])
            min = dp[n][i];
    }
    cout << min << endl;
}