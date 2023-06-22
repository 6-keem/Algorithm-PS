#include <stdio.h>

int main() {
	char board[50][50] = { 0, };
	int n, m; // m은 가로, n은 세로
	int min = 64;
	scanf("%d %d", &n, &m);
	for (int i = 0; i < n; i++) {
		scanf("%s", &board[i]);
	}
	for (int i = 0; i < n - 7; i++) {
		for (int j = 0; j < m - 7; j++) {
			int cnt_b = 0, cnt_w = 0;
			for (int x = i; x < i + 8; x++) {
				for (int y = j; y < j + 8; y++) {
					if ((x + y) % 2 == 0) {
						if (board[x][y] == 'W') cnt_b++;
						else cnt_w++;
					}
					else {
						if (board[x][y] == 'W') cnt_w++;
						else cnt_b++;
					}
				}
			}
			min = min > cnt_b ? cnt_b : min;
			min = min > cnt_w ? cnt_w : min;
		}
	}
	printf("%d", min);

	return 0;
}