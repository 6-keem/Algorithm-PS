#include <iostream>
using namespace std;

int main(){
    int start,end;
    cin >> start >> end;

    int sum, count;
    sum = count = 0;
    int index = 1;
    for(int i = 1; i <= 1000; i ++){
        count = 0;
        while(count < i){
            if(start <= index && index <= end){
                sum += i;
            }
            count++;
            index++;
        }
    }
    cout<<sum<<endl;
}