/*
Task is to print the prime numbers between 1 to given number n
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
void prime_series1(int n)
{
    for(int i=2;i<=n;i++)
    {
        if(is_prime(i))
        {
            cout<<i<<" ";
        }
    }
    cout<<"\n";
}

// Sieve of Erasthencs: Efficient approach;
void sieve_primes(int n)
{
    vector <bool> isPrime(n+1,true);
    for(int i=2;i*i<=n;i++)
    {
        if(isPrime[i])
        {
            for(int j=i*i;j<=n;j=j+i)
            {
                isPrime[j]=false;
            }
        }
    }

    for(int i=2;i<=n;i++)
    {
        if(isPrime[i])
        {
            cout<<i<<" ";
        }
    }
    cout<<"\n";
}


// shorter implementation of sieve of erastenchs
void sieve_primes2(int n)
{
    vector <bool> isPrime(n+1,true);
    for(int i=2;i<=n;i++)
    {
        if(isPrime[i])
        {
            cout<<i<<" ";
            for(int j=i*i;j<=n;j=j+i)
            {
                isPrime[j]=false;
            }
        }
    }
    cout<<"\n";
}
int main()
{
    int n;
    cin>>n;
    prime_series1(n);
    sieve_primes(n);
    sieve_primes2(n);
}