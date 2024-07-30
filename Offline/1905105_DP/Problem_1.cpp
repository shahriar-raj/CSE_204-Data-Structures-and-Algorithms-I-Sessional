#include <iostream>
#include <cstring>

using namespace std;

int DP_LCS(char* str1, char* str2, int** D, int** L){
    int m = strlen(str1);
    int n = strlen(str2);
    for(int i=0; i<=m; i++){
        L[i][0] = 0;
    }
    for(int i=0; i<=n; i++){
        L[0][i] = 0;
    }
    for(int i=1; i<=m; i++){
        for(int j=1; j<=n; j++){
            if(str1[i-1]==str2[j-1]){
                L[i][j] = L[i-1][j-1] + 1;
                D[i][j] = 1;
            }
            else{
                if(L[i-1][j]>L[i][j-1]){
                    L[i][j] = L[i-1][j];
                    D[i][j] = 2;
                }
                else{
                    L[i][j] = L[i][j-1];
                    D[i][j] = 3;
                }
            }
        }
    }
    return L[m][n];
}

char* Construct_LCS(char* str1, int** D, int r, int m, int n, char* R){
    while(m!=0 && n!=0){
        if(D[m][n]==1){
            R[--r] = str1[--m];
            n = n - 1;
        }
        else if(D[m][n]==2){
            m = m-1;
        }
        else{
            n = n-1;
        }
    }
    return R;
}

int main(){
    char *str1, *str2;
    str1 = new char[50];
    str2 = new char[50];
    cin >> str1;
    cin >> str2;
    int m = strlen(str1);
    int n = strlen(str2);
    int** D = new int* [m+1];
    for(int i=0; i<=m; i++)
        D[i] = new int[n+1];
        int** L = new int*[m+1];
    for(int i=0; i<=m; i++)
        L[i] = new int[n+1];
    int r = DP_LCS(str1, str2, D, L);
    cout << r << endl;
    char* R = new char[r+1];
    R[r] = '\0';
    cout << Construct_LCS(str1, D, r, m, n, R) << endl;
    for(int i=0; i<=m; i++)
        delete D[i];
    for(int i=0; i<=m; i++)
        delete L[i];
    delete D, L;
    delete str1, str2, R;
    return 0;
}
