/*
Given an integer, write a function that returns true if the given number is palindrome, else false.
*/

#include<bits/stdc++.h>
using namespace std;

bool ispalin(int n)
{
    int rev=0,temp=n;
    while(temp>0)
    {
        rev=(rev*10)+temp%10;
        temp=temp/10;
    }
    return (rev==n);
}

int main()
{
    int n;
    cout<<"enter any number: ";
    cin>>n;
    if(ispalin(n))
    {
        cout<<"Yes, it is a palindrome";
    }
    else
    {
        cout<<"No, it is not a palindrome";
    }
}