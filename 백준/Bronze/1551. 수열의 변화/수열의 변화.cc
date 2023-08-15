#include <iostream>
using namespace std;
int main() {
    int num[21] = {0,};
	int n, k;
    cin >> n >> k;

	for (int i = 0; i < n; i++) {
		cin >> num[i];
		getchar();
	}

	for (int i = 0; i < k; i++) {
		for (int j = 0; j < n - 1; j++) {
			num[j] = num[j + 1] - num[j];
		}
		n--;
	}
    
	for (int i = 0; i < n - 1; i++)
		cout << num[i] << ",";
    
	cout << num[n - 1] << endl;
}