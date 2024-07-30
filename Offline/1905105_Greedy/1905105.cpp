#include "bits/stdc++.h"

using namespace std;

int main(){
    int n,k;
    long long int cost=0;
    cin>>n>>k;
    int *arr;
    arr = new int[n];
    for(int i=0;i<n;i++)
        cin>>arr[i];
    sort(arr, arr+n, greater<int>());
    for(int i=0;i<n;i++)
        cost+=arr[i]*(i/k+1);
    cout << cost;
    return 0;
}
