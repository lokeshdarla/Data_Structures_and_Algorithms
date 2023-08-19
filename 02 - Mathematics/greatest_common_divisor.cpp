/*
We are given two numbers we nedd to find the gcd of two numbers
*/

#include<bits/stdc++.h>
using namespace std;

// Naive solution
int gcd1(int a,int b)
{
    int res=min(a,b);
    while(res>0)
    {
        if(a%res==0 && b%res==0)
        {
            return res;
        }
        res--;
    }
    return res;
}

// Euclidean method
int gcd2(int a,int b)
{
    while(a!=b)
    {
        if(a>b)
        {
            a=a-b;
        }
        else
        {
            b=b-a;
        }
    }
    return a;
}

// optimised implementation of euclidean algorithm
int gcd3(int a,int b)
{
    if(b==0)
    {
        return a;
    }
    return gcd3(b,a%b);
}

int main()
{
    int a,b;
    cin>>a>>b;
    cout<<gcd1(a,b)<<" "<<gcd2(a,b)<<" "<<gcd3(a,b);
}