/* 
    Given a number N, the task is to return the count of digits in this number.
*/

#include <bits/stdc++.h>
using namespace std;

int digit_count(int n)
{
    int x = 0; // Initialize a variable to count digits
    while (n > 0)
    {
        x++; 
        n = n / 10;
    }
    return x;
}

int main()
{
    int n;
    cout << "Enter any number: ";
    cin >> n; // Input the number
    cout << "Number of digits: " << digit_count(n); // Print the digit count
}
