#include <iostream>
using namespace std;

int main() {
	int n, m;
	string data[100];
	int count = 0;
	cin >> n >> m;
	for (int i = 0; i < n; i++)
		cin >> data[i];
	for (int i = 0; i < n; i++)
		for(int j = 0 ; j < m ; j ++){
			if (data[i][j] == '-')
				if (j == m - 1 || data[i][j + 1] == '|')
					count++;
			if (data[i][j] == '|')
				if (i == n - 1 || data[i + 1][j] == '-')
					count++;
		}
	cout << count << endl;
}