#include <iostream>
#include <stack>
#include <queue>
using namespace std;

int main() {
	queue<int> q;
	stack<int> s;
	int n;
	std::cin >> n;
	int data;
	for (int i = 0; i < n; i++) {
		std::cin >> data;
		q.push(data);
	}
	data = 1;
	while (!q.empty()) {
		int value = q.front();
		if (value == data) {
			data++;
			q.pop();
		}
		else {
			if (!s.empty() && s.top() == data) {
				data++;
				s.pop();
			}
			else {
				s.push(value);
				q.pop();
			}
		}
	}
	while (!s.empty()) {
		int value = s.top();
		s.pop();
		if (value != data) {
			cout << "Sad" << endl;
			exit(0);
		}
		data++;
	}
	cout << "Nice" << endl;
}