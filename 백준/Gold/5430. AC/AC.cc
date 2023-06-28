#include <iostream>
#include <string>
#include <vector>
#include <deque>
using namespace std;

int main() {
    int T;
    cin >> T;
    int commandIndex = 0;
    int count;
    string command;
    while (T--) {
        int dCount = 0;
        deque<int> q;
        bool flag = true;
        commandIndex = 0;
        cin >> command >> count; cin.ignore();
        string input;
        cin >> input;
        int startindex = 1;

        for (int j = 0; j < command.length(); j++) {
            if (command[j] == 'D')
                dCount++;
        }
        if (dCount > count) {
            cout << "error" << endl;
            continue;
        }
        if (count != 0) {
            while (true) {
                int findindex = input.find(',', startindex);
                if (findindex == -1) {
                    int ch = stoi(input.substr(startindex, input.length() - 1 - startindex));
                    q.push_back(ch);
                    break;
                }
                int ch = stoi(input.substr(startindex, findindex - startindex));
                startindex = findindex + 1;
                q.push_back(ch);
            }
            for (int j = 0; j < command.length(); j++) {
                if (command[j] == 'D') {
                    if (flag)
                        q.pop_front();
                    else
                        q.pop_back();
                }
                else if (command[j] == 'R') {
                    flag = !flag;
                }
            }
        }

        cout << '[';
        if (q.size() != 0) {
            if (flag) {
                for (int j = 0; j < q.size() - 1; j++) {
                    cout << q[j] << ',';
                }
                cout << q.back();
            }
            else {
                for (int j = q.size() - 1; j > 0 ; j--) {
                    cout << q[j] << ',';
                }
                cout << q.front();
            }
        }
        cout << ']' << endl;
    }
}