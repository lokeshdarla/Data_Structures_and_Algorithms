#include <bits/stdc++.h>
using namespace std;

vector<int> qRoots(int a, int b, int c) {
    vector<int> v;
    double det = b * b - 4 * a * c;
    if (det < 0) {
        v.push_back(-1);
    } else {
        int root1 = static_cast<int>(floor((-b + sqrt(det)) / (2 * a)));
        int root2 = static_cast<int>(floor((-b - sqrt(det)) / (2 * a)));
        v.push_back(min(root1, root2));
        v.push_back(max(root1, root2));
    }

    return v;
}

int main() {
    int a, b, c;
    cin >> a >> b >> c;
    vector<int> roots = qRoots(a, b, c);
    if (roots.size() == 1) {
        cout << "Imaginary roots";
    } else {
        cout << roots[0] << " " << roots[1];
    }
    return 0;
}
