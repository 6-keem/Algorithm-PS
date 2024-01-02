#include <iostream>
#include <vector>
#include <queue>
using namespace std;

#define MAX_INT 2147483647
int n, m, k, x;
vector<int> graph[300001];
int answer[300001];

void dijkstra(int s) {
	for (int i = 0; i <= n; i++)
		answer[i] = MAX_INT;
	answer[s] = 0;
	queue<int> queue;
	queue.push(s);
	while (!queue.empty()) {
		int v = queue.front();
		queue.pop();
		for (int i = 0; i < graph[v].size(); i++) {
			int w = graph[v][i];
			if (answer[w] > answer[v] + 1) {
				answer[w] = answer[v] + 1;
				queue.push(w);
			}
		}
	}
}

int main() {
	cin >> n >> m >> k >> x;

	int s, d;
	for (int i = 0; i < m; i++) {
		cin >> s >> d;
		graph[s].push_back(d);
	}
	dijkstra(x);
	bool flag = false;
	for (int i = 1; i <= n; i++) {
		if (answer[i] == k) {
			cout << i << endl;
			flag = true;
		}
	}
	if (!flag)
		cout << -1 << endl;
}