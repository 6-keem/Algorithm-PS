#include <iostream>
#include <vector>
#include <string>
using namespace std;

int main(){
    vector<string> vt;
    int n;
    cin>>n;

  while(n--){
    string part;
    cin>>part;
    vt.push_back(part);
  }
  int count = 0;
  int total = 0;
  for (auto & a : vt){
      count = 0;
      if(a.length() < 6) continue;
      bool flag = false;
      string part = a.substr(a.length()-6, 6);
      if(part == "Cheese") flag = true;
      for(auto & b : vt){
        if(flag && a == b) count++;
      }
    if(count == 1) total ++;
  }
  if(total >= 4) cout<<"yummy"<<endl;
  else cout<<"sad"<<endl;
}