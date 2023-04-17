#include <iostream>
using namespace std;
bool calc(int a1, int a[], int b1, int b[]) {
	int data[10] = { 1,2,4,8,16,32,64,128,256,512 };
	for (int i = 9; i >= 0; i--) {
		if (a1 >= data[i]) {
			a1 -= data[i];
			a[i]++;
		}
		if (b1 >= data[i]) {
			b1 -= data[i];
			b[i]++;
		}
	}
	if (b1 != 0 || a1 != 0) return false;
	else return true;
}
int main() {
	int a[10] = { 0 }, b[10] = { 0 };
	int c[10] = {0};
	int a1, b1;
	cin >> a1 >> b1;

	bool flag = calc(a1, a, b1, b);
	if (flag) {
		for (int i = 0; i < 10; i++) {
			if ((a[i] == 1 && b[i] == 0) || (a[i] == 0 && b[i] == 1)) c[i]++;
		}
	}
	else cout << "0" << endl;
	int reuslt = 1, sum = 0;
	for (int i = 0; i < 10; i++) {
		reuslt = 1;
		for (int j = 0; j < i; j++) {
			reuslt *= 2;
		}
		if (c[i] == 1) sum += reuslt;
	}
	cout << sum;
}