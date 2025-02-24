/*
Task is to calculate x to power of n
*/

#include<bits/stdc++.h>
using namespace std;

// Naive solution
int c_power(int x,int n)
{
    int res=1;
    for(int i=1;i<=n;i++)
    {
        res=res*x;
    }
    return res;
}

//efficient approach
int c_power2(int x,int n)
{
    if(n==0) return 1;
    int temp=c_power2(x,n/2);
    temp=temp*temp;
    if(n%2==0) return temp;
    else return temp*x;
}

int main()
{
    int x,n;
    cin>>x>>n;
    cout<<c_power(x,n)<<"\n"<<c_power2(x,n);
}