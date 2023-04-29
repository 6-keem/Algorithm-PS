#include <iostream>
#include <cmath>
using namespace std;

int zcount = 0;
int n,r,c;

void z(int x, int y, int size){
    if(c == x && r == y){
        cout<<zcount<<endl;
        return;
    }
    if(c >= x && c < x + size && r >= y && r < y + size) {// 내부에 있다
        z(x,y,size/2);
        z(x+size/2,y,size/2);
        z(x,y+size/2,size/2);
        z(x+size/2,y+size/2,size/2);

    }
    else{ // skip
        zcount += size * size;
        return; 
    }
}
int main(){
    cin>>n>>r>>c;
    z(0,0,pow(2,n));
    return 0;
}