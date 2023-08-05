#include <iostream>
#include <cmath>
using namespace std;

void hanoi(int from, int by, int to, int n) {
	if (n == 1) {
		cout << from << " " << to<< "\n";
	}
	else {
		hanoi(from, to, by, n - 1);
		cout << from << " " << to << "\n";
		hanoi(by, from, to, n - 1);
	}
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int n;
	cin >> n;
	cout << (int)pow(2, n) - 1 << '\n';
	hanoi(1, 2, 3, n);
}