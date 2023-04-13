#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int main() {
    int t;
    int r, c;
    char factory[400][400] = { 0 };
    scanf("%d", &t);

    while (t--) {
        int count = 0;
        scanf("%d %d", &r,&c);
        fflush(stdin);

        for (int i = 0; i < r; i++) {
            scanf("%s",factory[i]);

        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (factory[i][j] == 'o') {
                    if (j != 0 && j != c - 1) {
                        if (factory[i][j - 1] == '>' && factory[i][j + 1] == '<') count++;
                    }
                    if (i != 0 && i != r - 1) {
                        if (factory[i - 1][j] == 'v' && factory[i + 1][j] == '^') count++;
                    }

                }
            }
        }
        printf("%d\n", count);
    }
}