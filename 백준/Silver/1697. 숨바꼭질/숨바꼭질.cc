#include <iostream>
#include <queue>
using namespace std;

class Component {
public:
    int value;
    int count;
    Component(int value, int count)
        : value(value), count(count) { }
};

queue<Component> q;
int graph[100001] = { 0, };
int destination;

bool isPossible(int n) {
    return (n >= 0 && n < 100001);
}

int dfs() {
    while (!q.empty()) {
        Component temp = q.front();
        q.pop();
        if (temp.value == destination) {
            return temp.count;
        }
        if (isPossible(temp.value - 1) && graph[temp.value - 1] == 0) {
            graph[temp.value -1] = 1;
            q.push(Component(temp.value - 1, temp.count + 1));
        }
        if (isPossible(temp.value + 1) && graph[temp.value + 1] == 0) {
            graph[temp.value + 1] = 1;
            q.push(Component(temp.value + 1, temp.count + 1));
        }
        if (isPossible(temp.value * 2) && graph[temp.value * 2] == 0) {
            graph[temp.value * 2] = 1;
            q.push(Component(temp.value * 2, temp.count + 1));
        }
    }
}

int main() {
    int s;
    cin >> s >> destination;
    q.push(Component(s, 0));
    int answer = dfs();
    cout << answer << endl;
}