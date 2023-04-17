#include <iostream>
using namespace std;

int main(){
    int count = 1;
    unsigned long long t = 1;
    unsigned long long n;
    cin>>n;
    if(n==0){
      cout<<0<<endl;
      return 0;
    }
    while(t<n){
        t*=2;
        count++;
    }
    cout<<count<<endl;;
}