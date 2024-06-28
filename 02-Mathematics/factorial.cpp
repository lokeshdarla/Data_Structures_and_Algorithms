/*
Write  program to find the facorial of a number
*/

#include<bits/stdc++.h>
using namespace std;

int factorial_recursion(int n)
{
    if(n==0|| n==1)
    return 1;
    else
        return n*factorial_recursion(n-1);
}

int factorial_iterative(int n)
{
    int fact=1;
    for(int i=2;i<=n;i++)
    {
        fact=fact*i;
    }
    return fact;
}
int main()
{
    int n;
    cout<<"input a number: ";
    cin>>n;
    cout<<factorial_recursion(n)<<"\n";
    cout<<factorial_iterative(n);
}