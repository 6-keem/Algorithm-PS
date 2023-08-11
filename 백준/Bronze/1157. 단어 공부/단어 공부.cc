#include <iostream>
using namespace std;

int main() {
    int result[26] = { 0, };
    int max;
    int index;
    int count = 0;

    int ch;
    while ((ch = cin.get()) != '\n') {
        if (islower((char)ch))
            result[ch - 97]++;
        else
            result[ch - 65]++;
    }

    max = result[0];
    index = 0;
    for (int i = 1; i < 26; i++) {
        if (max < result[i]) {
            index = i;
            max = result[i];
        }
    }

    for (int i = 0; i < 26; i++)
        if (max == result[i])
            count++;
    if (count != 1)
        cout << '?' << endl;
    else
        cout << (char)(index + 65);
}