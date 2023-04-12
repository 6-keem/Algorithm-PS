#include <stdio.h>
int main(){
    int t;
    int n;
    unsigned long long temp = 0;
    scanf("%d",&t);
    while(t--){
        unsigned long long sum = 0;
        scanf("%d",&n);
        for(int i = 0 ; i < n ; i ++){
            scanf("%lld",&temp);
            sum += temp % n;
        }
        if(sum % n == 0) printf("YES\n");
        else printf("NO\n");
    }
}