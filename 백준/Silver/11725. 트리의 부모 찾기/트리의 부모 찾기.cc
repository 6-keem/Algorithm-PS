#include <iostream>
#include <vector>
using namespace std;

int n;
int ans[100001] = {0,};
int visited[100001] = {0,};
vector<int> graph[100001];

void dfs(int v){
    visited[v] = 1;
    for(int i = 0 ; i < graph[v].size() ; i ++){
        int n = graph[v][i];
        if(visited[n] == 0){
            ans[n] = v;
            dfs(n);
        }
    }
}

int main(){
    cin.tie(NULL);
	ios::sync_with_stdio(false);
    cin >> n;
    for(int i = 0 ; i < n ; i++){
        int x, y;
        cin >> x >> y;
        graph[x].push_back(y);
        graph[y].push_back(x);
    }
    dfs(1);

    for(int i = 2 ; i <= n ; i ++)
        cout << ans[i] << "\n";
}