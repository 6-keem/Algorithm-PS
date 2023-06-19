#include <iostream>
using namespace std;
int main() {
	int n,data;
	int result[100] = { 0, };
	cin >> n;
	int i;
	for (i = 1; i <= n; i++) {
		cin >> data;
		for (int j = 0; j < n; j++) {
			if (data == 0 && result[j] == 0) {
				result[j] = i;
				break;
			}
			if(result[j] == 0)
				data--;
		}
	}
	for (int i = 0; i < n; i++)
		cout << result[i] << ' ';
	cout << endl;
}