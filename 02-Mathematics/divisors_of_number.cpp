/*
Task is to print all the divisors of a number in a sorted order
*/

#include<bits/stdc++.h>
using namespace std;

// Naive solution
void divisors1(int n)
{
    for(int i=1;i<=n;i++)
    {
        if(n%i==0)
        {
            cout<<i<<" ";
        }
    }
    cout<<"\n";

}

// efficient approach but lacks sorted order
void divisors2(int n)
{
    for(int i=1;i*i<=n;i++)
    {
        if(n%i==0)
        {
            cout<<i<<" ";
            if(i!=n/i)
            {
                cout<<n/i<<" ";
            }
        }
    }
    cout<<"\n";
}


//Optimization of efficeint approach
void divisors3(int n)
{
    for(int i=1;i*i<=n;i++)
    {
        if(n%i==0)
        {
            cout<<i<<" ";
        }
    }

    for(int i=sqrt(n);i>=1;i--)
    {
        if(n%i==0)
        {
            cout<<n/i<<" ";
        }
    }

    cout<<"\n";

}

int main()
{
    int n;
    cin>>n;
    divisors1(n);
    divisors2(n);
    divisors3(n);
}