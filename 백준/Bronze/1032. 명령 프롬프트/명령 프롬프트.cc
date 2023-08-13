#include <iostream>
#include <string>
using namespace std;
 
int main() {
    string temp[50];
    int n;
    
    cin >> n;
    for(int i=0; i<n; i++)
        cin >> temp[i];

    for(int i = 0; i < temp[0].length(); i++){
        char ch = temp[0][i];
        for(int j = 0 ; j < n ; j++){
            if(ch != temp[j][i]){
                ch = '?';
                break;
            }
        }    
        cout << ch;    
    }
    return 0;
}
 