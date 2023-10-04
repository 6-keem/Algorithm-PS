#include <stdio.h>
int graph[101][101] = {0,};
int DFSvisit[101] = {0,};
int flagcount = -1;
int DFS(int v, int N){
    flagcount++;
    DFSvisit[v] = 1;
    for(int i = 1; i<=N ; i++)
        if(graph[v][i] == 1 && DFSvisit[i] == 0)
            DFS(i,N);
}
int main(){
    int n,m; // n 정점 m 간선
    scanf("%d %d",&n,&m);
    
    int x, y;

    for(int i = 0 ; i < m ; i++)
    {
        scanf("%d %d",&x,&y);
        graph[x][y] = 1;
        graph[y][x] = 1;
    }

    DFS(1, n);
    
    printf("%d",flagcount);

}