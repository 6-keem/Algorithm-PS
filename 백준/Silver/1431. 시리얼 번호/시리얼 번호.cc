#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
using namespace std;

bool compare(string a, string b) {

    if (a.length() != b.length())
        return a.length() < b.length();

    int aSum = 0, bSum = 0;
    for (int i = 0; i < a.length(); i++) {
        if (isdigit(a[i]))
            aSum += a[i] - '0';
        if (isdigit(b[i]))
            bSum += b[i] - '0';
    }
    if (aSum != bSum)
        return aSum < bSum;

    return a < b;
}
int main() {
    vector<string> vt;
    string temp;
    int n;
    cin >> n;
    cin.ignore(1);
    for (int i = 0; i < n; i++) {
        getline(cin, temp);
        vt.push_back(temp);
    }

    sort(vt.begin(), vt.end(), compare);
    for (auto& a : vt)
        cout << a << endl;
}