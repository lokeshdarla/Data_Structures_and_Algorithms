/* 
Task is to find the power modulo
*/

#include<bits/stdc++.h>
using namespace std;


int mod_power(int x,int n,int m)
{
    int res=1;
    while(n>0)
    {
        if(n&1)
            res=(res*x)%m;
        x=(x*x)%m;
        n=n>>1;
    }

    return res;
}

int main()
{
    int x,n,m;
    cin>>x>>n>>m;
    cout<<mod_power(x,n,m);
}