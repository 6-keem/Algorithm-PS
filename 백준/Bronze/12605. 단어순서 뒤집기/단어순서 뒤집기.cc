#include <iostream>
#include <vector>
#include <string>
using namespace std;

int main() {
    int n;
    cin >> n;
    cin.ignore();
    for (int i = 0; i < n; i++) {
        vector<string> vt;
        string input;
        getline(cin, input);
        int startindex = 0;
        while (true) {
            string temp;
            int findindex = input.find(' ',startindex);
            if (findindex == -1) {
                temp = input.substr(startindex, input.length() - startindex);
                vt.push_back(temp);
                break;
            }
            temp = input.substr(startindex, findindex - startindex);
            startindex = findindex + 1;
            vt.push_back(temp);
        }
        cout << "Case #" << i + 1 << ": ";
        for (int i = vt.size() - 1; i >= 0; i--) {
            cout << vt[i] << ' ';
        }
        cout << endl;
    }
}