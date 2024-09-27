#include<bits/stdc++.h>
using namespace std;
int main(){
    map<char,int> hash;
    string str="acdaabcaac"; 
    for(auto ele:str) hash[ele]++;
    int k=4; 
    int n=str.size();
    int x=hash.size();
    string ans="";
    int ct=0;
    if(k<x || k>n) cout<<"-1";  
    else{
        for(auto ele:hash){
            ans+=ele.first;
            hash[ele.first]--;
            ct++;
        }
        for(auto ele:hash){
            int temp=ele.second;
                while(temp>0 && ct<k){
                    temp--;
                    ct++;
                    ans+=ele.first;
                }
        }
    }
    sort(ans.begin(),ans.end());
    cout<<ans<<endl;
}
