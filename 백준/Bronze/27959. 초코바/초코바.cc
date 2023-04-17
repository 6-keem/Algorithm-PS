#include <iostream>
using namespace std;
int main() {
	int n, price;

	cin >> n >> price;
	n *= 100;
	if (n >= price)cout << "Yes" << endl;
	else cout << "No" << endl;
}