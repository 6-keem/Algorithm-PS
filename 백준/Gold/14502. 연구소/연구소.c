#define _CRT_SECURE_NO_WARNINGS

#include <stdio.h>
#include <stdlib.h>

int dx[4] = { -1,0,1,0 };
int dy[4] = { 0,1,0,-1 };
int graph[10][10] = { 0, };
int temp[10][10];
int virus[64][2];
int count = 0;
int answer = 0;
int n, m;

#define EMPTY 0
#define WALL 1
#define VIRUS 2 

void dfs(int x, int y) {
	for (int i = 0; i < 4; i++) {
		int tempX = x + dx[i];
		int tempY = y + dy[i];
		if (0 < tempX && tempX <= m && 0 < tempY && tempY <= n && temp[tempY][tempX] == EMPTY) {
			temp[tempY][tempX] = VIRUS;
			dfs(tempX, tempY);
		}
	}
}
int set_init() {
	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= m; j++) {
			temp[i][j] = graph[i][j];
		}
	}
}

int main() {
	scanf("%d %d", &n, &m);

	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= m; j++) {
			scanf("%d", &graph[i][j]);

			if (graph[i][j] == VIRUS) {
				virus[count][0] = j;
				virus[count][1] = i;
				count++;
			}
		}
	}

	set_init();
	int x1, x2, x3, y1, y2, y3;
	for (int i = 0; i < n * m; i++) {
		y1 = i / m + 1;
		x1 = i % m + 1;
		if (temp[y1][x1] == EMPTY)
			for (int j = i + 1; j < n * m; j++) {
				y2 = j / m + 1;
				x2 = j % m + 1;
				if (temp[y2][x2] == EMPTY) {
					for (int k = j + 1; k < n * m; k++) {
						y3 = k / m + 1;
						x3 = k % m + 1;
						if (temp[y3][x3] == EMPTY) {
							temp[y1][x1] = temp[y2][x2] = temp[y3][x3] = WALL;
							for (int r = 0; r < count; r++)
								dfs(virus[r][0], virus[r][1]);

							int cnt = 0;
							for (int a = 1; a <= n; a++) {
								for (int b = 1; b <= m; b++) {
									if (temp[a][b] == EMPTY)
										cnt++;
								}
							}

							if (answer < cnt)
								answer = cnt;

							set_init();
						}
					}
				}
			}
		
	}
	printf("%d", answer);

}