/*
Task is to print to x to the power of n
*/

#include<bits/stdc++.h>
using namespace std;

int i_power(int x, int n)
{
    int res=1;
    while(n>0)
    {
        if(n%2!=0)
            res=res*x;
        x=x*x;
        n=n/2;
    }
    return res;
}

int main()
{
    int x,n;
    cin>>x>>n;
    cout<<i_power(x,n);
}