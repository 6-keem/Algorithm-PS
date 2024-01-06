#include <iostream>
#include <queue>
using namespace std;

int main() {
	int n, k;
	queue<int> queue;
	cin >> n >> k;
	for (int i = 1; i <= n; i++)
		queue.push(i);

	cout << "<";
	while (!queue.empty()) {
		int temp = 0;
		for (int i = 1; i <= k; i++) {
			temp = queue.front();
			queue.pop();
			if (i != k)
				queue.push(temp);
			else
				cout << temp;
		}
		if(!queue.empty())
			cout << ", ";
	}
	cout << ">";
	return 0;
}