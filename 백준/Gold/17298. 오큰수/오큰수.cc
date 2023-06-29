#include <iostream>
#include <vector>
#include <stack>
using namespace std;
int main() {
    int N;
    cin >> N;
    stack<int> st;
    vector<int> vt;
    vector<int> ans;
    for (int i = 0; i < N; i++) {
        int ch;
        cin >> ch;
        vt.push_back(ch);
    }
    int ch2 = -1;
    while (N--) {
        int ch = vt[N];
        while (!st.empty() && ch >= st.top()) {
            st.pop();
        }
        if (!st.empty() && ch < st.top()) {
            ans.push_back(st.top());
            st.push(st.top());
        }
        else {
            ans.push_back(-1);
            st.push(-1);
        }
        st.push(ch);
    }
    for (int i = ans.size() - 1; i >= 0; i--) {
        cout << ans[i] << ' ';
    }
    cout << endl;
}