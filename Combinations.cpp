//Combinations

#include <iostream>
using namespace std;
int main() {
    string s;
    cin >> s;
    int l = s.length();
    for (int ctr = 0; ctr < (1 << l); ctr++){
        string comb = " ";
        for (int i = 0; i < l; i++){
            if ((ctr & (1 << i)) > 0){
                comb += s[i];
            }
        }
        cout << comb << endl;
    }
    return 0;
}
