/*
We are given a number. The task is to find the Number of Trailing Zeros in the factorial of the number.
The Trailing Zeros are the Zeros, which appear at the end of a number(factorial in that case)
*/

#include<bits/stdc++.h>
using namespace std;

//Naive method
int trail_zero1(int n)
{
    int count=0;
    int fact=1;
    for(int i=2;i<=n;i++)
    {
        fact=fact*i;
    }
    while(fact>0)
    {
        if(fact%10==0)
            count++;
        fact=fact/10;
    }
    return count;
}

/*
Efficient Approach:A trailing zero is always produced by prime 2 and 5 
*/
int trail_zero2(int n)
{
    int res=0;
    for(int i=5;n/i>=1;i=i*5)
    {
        res=res+n/i;
    }
    return res;
}

int main()
{
    int n;
    cin>>n;
    cout<<trail_zero1(n)<<"\n";
    cout<<trail_zero2(n);
}