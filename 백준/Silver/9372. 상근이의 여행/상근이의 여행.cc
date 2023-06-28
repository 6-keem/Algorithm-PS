#include <iostream>
using namespace std;

int main() {
    int T, N, M,a,b;
    std::cin >> T;
    while (T--) {
        cin >> N >> M;
        for (int i = 1; i <= M; i++) {
            cin >> a >> b;
        }
        cout << N - 1 << endl;
    }
    return 0;
}