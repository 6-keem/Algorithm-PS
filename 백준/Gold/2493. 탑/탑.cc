#include <iostream>
#include <vector>
#include <stack>
using namespace std;

class Index {
public:
    int value;
    int index;
    Index(int index, int value)
        : index(index), value(value) { }
};

int main() {
    stack<Index> st;
    vector<Index> vt;
    vector<Index> answer;
    int N;
    cin >> N;
    for (int i = 1; i <= N; i++) {
        int ch;
        cin >> ch;
        vt.push_back(Index(i, ch));
    }

    for (int i = 0; i < N; i++) {
        int ch = vt[i].value;
        while (!st.empty() && ch >= st.top().value)
            st.pop();
        if (!st.empty() && ch < st.top().value)
            answer.push_back(st.top());
        else {
            answer.push_back(Index(0, 0));
            st.push(Index(0, 0));
        }
        st.push(Index(i+1, ch));
    }

    for (int i = 0; i < N; i++) 
        cout << answer[i].index << ' ';
    cout << endl;
}