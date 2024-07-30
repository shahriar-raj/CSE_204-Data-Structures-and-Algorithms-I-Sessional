#include<iostream>
#include<cmath>
#include<climits>

using namespace std;

int* bin(int a, int n){
    int *b = new int[n];
    for(int i=n; i>0; i--){
        b[i-1] = a%2;
        a/=2;
    }
    return b;
}

int dec(int* b, int n){
    int a =0, f=1;
    for(int i=0; i<n; i++){
        a += b[n-i-1]*f;
        f*=2;
    }
    return a;
}

int dynamic(int n, int *dp, int **A, int x){
    dp[0] = 0;
    for(int i=1; i<x; i++){
        dp[i] = INT_MAX;
    }
    for(int i=0; i<x; i++){
        int* b = bin(i, n);
        for(int j=0; j<n; j++){
            int *c = new int[n];
            for(int m=0; m<n; m++){
                c[m] = b[m];
            }
            if(b[j]==0){
                c[j] = 1;
                int l = dec(c,n);
                int extra = 0;
                for(int k=0; k<n; k++){
                    extra += A[j][k]*c[k];
                }
                dp[l] = min(dp[l],dp[i]+extra);
            }
            delete c;
        }
        delete b;
    }
    return dp[x-1];
}

int main(){
    int n;
    cin >> n;
    int **A = new int* [n];
    for(int i=0; i<n; i++){
        A[i] = new int[n];
        for(int j=0; j<n; j++){
           cin >> A[i][j];
        }
    }
    int x = pow(2,n);
    int* dp = new int[x];
    cout << dynamic(n, dp, A, x);
    delete dp;
    for(int i=0; i<n; i++){
        delete A[i];
    }
    delete A;
    return 0;
}
