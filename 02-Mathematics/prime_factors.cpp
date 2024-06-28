/*
Task is to find the prime factorisation of the given number
*/

#include<bits/stdc++.h>
using namespace std;

bool is_prime(int n)
{
    if(n<=1)
    {
        return false;
    }
    else if(n==2 || n==3 )
    {
        return true;
    }
    else if(n%2==0 || n%3==0)
    {
        return false;
    }
    else
    {
        for(int i=5;i*i<=n;i=i+6)
        {
            if((n%i==0) || (n%(i+2)==0))
            {
                return false;
            }
        }
    }
    return true;
}


// Naive solution
void prime_factors1(int n)
{
    for(int i=2;i<n;i++)
    {
        if(is_prime(i))
        {
            int x=i;
            while(n%x==0)
            {
                cout<<i<<" ";
                x=x*i;
            }
        }

    }
}

void prime_factors2(int n)
{
    if(n<=1) return;
    for(int i=2;i*i<=n;i++)
    {
        if(n%i==0)
        {
            while(n%i==0)
            {
                cout<<i<<" ";
                n=n/i;
            }
        }
    }

    if(n>1)
    {
        cout<<n<<" ";
    }
}



void prime_factors3(int n)
{
    while(n%2==0)
    {
        cout<<2<<" ";
        n=n/2;
    }
    while(n%3==0)
    {
        cout<<3<<" ";
        n=n/3;
    }
    for(int i=5;i*i<=n;i++)
    {
        while(n%i==0)
        {
            cout<<i<<" ";
            n=n/i;
        }
        while (n%(i+2)==0)
        {
            cout<<i+2<<" ";
            n=n/(i+2);
        }
    }
    
    if(n>3)
    {
        cout<<n;
    }

}

int main()
{
    int n;
    cin>>n;
    prime_factors3(n);
}