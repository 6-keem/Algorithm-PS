#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <string.h>
int main() {
	int count = 0;
	int data;
	scanf("%d",&data);
	int ndata[3];
	for (int i = 1; i <= data; i++) {
		if (i < 10) count++;
		else if (i < 100) count++;
		else if (i < 1000) {
			int temp = i;
			for (int j = 2; j >= 0; j--) {
				ndata[j] = temp % 10;
				temp /= 10;
			}
			if (ndata[0] + ndata[2] == ndata[1] * 2) count++;
		}
	}
	printf("%d\n", count);	
}