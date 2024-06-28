/*
Task is to check it is a prime number or not
*/

#include<bits/stdc++.h>
using namespace std;


// Naive solution
bool is_prime1(int n)
{
    for(int i=2;i<n;i++)
    {
        if(n%i==0)
        {
            return false;
        }
    }

    return true;
}


// Efficient solution 
bool is_prime2(int n)
{
    for(int i=2;i*i<=n;i++)
    {
        if(n%i==0)
        {
            return false;
        }
    }
    return true;
}

// optimised efficient solution
bool is_prime3(int n)
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

int main()
{
    int n;
    cin>>n;
    cout<<is_prime1(n);
    cout<<is_prime2(n);
    cout<<is_prime3(n);
}