/*
LCM (Least Common Multiple) of two numbers is the smallest number which can be divided by both numbers. 
*/

#include<bits/stdc++.h>
using namespace std;

// Naive solution
int lcm1(int a,int b)
{
    int res=max(a,b);
    while(true)
    {
        if(res%a==0 && res%b==0)
        {
            return res;
        }
        res++;
    }
}

int gcd(int a,int b)
{
    if(b==0)
    {
        return a;
    }
    else
    {
        return gcd(b,a%b);
    }
}

// Efficient solution
int lcm2(int a,int b)
{
    return (a*b)/gcd(a,b);
}

int main()
{
    int a,b;
    cin>>a>>b;
    cout<<lcm1(a,b)<<" "<<lcm2(a,b);
    
}
