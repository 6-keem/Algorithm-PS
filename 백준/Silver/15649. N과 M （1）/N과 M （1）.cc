#include <iostream>
using namespace std;

int n, m;
int graph[9] = {0,};
bool visited[9] = {false,};

void dfs(int count){
    if(count == m){ //현재 그래프에 저장된 숫자의 개수와 출력되어야 하는 개수가 동일하면 출력
        for(int i = 0 ; i < count ; i++)
            cout << graph[i] << ' ';
        cout << '\n';
        return;
    }
    for(int i = 1 ; i <= n ; i++){ // 숫자 범위 내에서
        if(visited[i] == false){ // 방문한 적 없는 노드
            visited[i] = true; // 방문했다고 바꿔주고
            graph[count] = i; // 방문한 노드 그래프에 기록
            dfs(count+1); // 개수 하나 증가시켜서 재귀
            visited[i] = false; // 리턴 후 이미 값을 출력했기 때문에 다음 시행을 위해 초기화
        }  
    }
}

int main(){
    ios::sync_with_stdio(false);
	cin.tie(0);

    cin >> n >> m;
    dfs(0);
}