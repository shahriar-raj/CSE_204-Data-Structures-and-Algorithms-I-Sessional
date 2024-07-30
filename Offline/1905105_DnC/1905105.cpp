#include <iostream>
#include <bits/stdc++.h>
#include <ctime>
#include <time.h>
#include <fstream>

using namespace std;

void initialize(int *A, int r, int size);
void Merge(int *A, int p, int q, int r);
void merge_sort(int* A, int p, int r);
int Partition(int* A, int p, int r);
void quicksort(int* A, int p, int r);
void insertion_sort(int* A, int size);
int R_Partition(int* A, int p, int r);
void R_quicksort(int* A, int p, int r);

void initialize(int *A, int r, int size){
    srand(r);
    for(int i = 0; i < size; i++)
        A[i] = rand();
}

void Merge(int *A, int p, int q, int r){
    int n_1 = q-p+1;
    int n_2 = r-q;
    int *L, *R;
    L = new int[n_1];
    R = new int[n_2];

    for(int i=0; i<n_1; i++){
        L[i] = A[p+i];
    }

    for(int j=0; j<n_2; j++){
        R[j] = A[q+j+1];
    }
    int i=0;
    int j=0;

    for(int k=p; k<=r; k++){
        if(i==n_1||j==n_2){
            if(i==n_1)
                A[k]=R[j++];
            else
                A[k]=L[i++];
        }
        else{
            if(L[i]<=R[j])
                A[k] = L[i++];
            else
                A[k] = R[j++];
        }
    }
    delete L;
    delete R;
}

void merge_sort(int* A, int p, int r){
    if(p<r){
        int q = (p+r)/2;
        merge_sort(A,p,q);
        merge_sort(A,q+1,r);
        Merge(A, p, q, r);
    }
}

int Partition(int* A, int p, int r){
    int pivot = A[r];
    int i = p-1;
    for(int j=p; j<r; j++){
        if(A[j]<=pivot){
            i = i+1;
            swap(A[i],A[j]);
        }
    }
    swap(A[i+1],A[r]);
    return i+1;
}

void quicksort(int* A, int p, int r){
    if(p<r){
        int q = Partition(A, p, r);
        quicksort(A,p,q-1);
        quicksort(A,q+1,r);
    }
}

int R_Partition(int* A, int p, int r){
    int temp = p +(rand()%(r-p));
    swap(A[temp],A[r]);
    return Partition(A, p, r);
}

void R_quicksort(int* A, int p, int r){
    if(p<r){
        int q = R_Partition(A, p, r);
        R_quicksort(A,p,q-1);
        R_quicksort(A,q+1,r);
    }
}

void insertion_sort(int* A, int size){
    for(int i=0;i<size;i++){
        int min=i;
        for(int j=i+1;j<size;j++){
            if(A[min]>A[j])
                min = j;
        }
        swap(A[i],A[min]);
    }
}

int main(){
    int N[6] = {5,10,100,1000,10000,100000};
    ofstream myfile;
    myfile.open ("output.csv");
    myfile<<",Time required in ms,,,,,,"<<endl;
    myfile<<"n,Merge Sort,Quick sort,Randomized Quick sort,Insertion Sort,Quick sort with Sorted Input,Randomized Quick sort with Sorted Input,STL sort() function"<<endl;
    for(int t=0; t<6; t++){
        int SIZE = N[t];
        double t_m_s = 0, t_q_s=0, t_r_s=0, t_s_q_s=0, t_s_r_s=0, t_i_s = 0, t_st_s = 0;
        int *A;
        A = new int[SIZE];
        for(int l=0; l<20; l++){
            double s_t_s;
            double e_t_s;

            initialize(A, l, SIZE);
            s_t_s = double(clock());
            merge_sort(A, 0, SIZE-1);
            e_t_s = double(clock());
            t_m_s += (e_t_s - s_t_s )/CLOCKS_PER_SEC*1000;

            initialize(A, l, SIZE);
            s_t_s = double(clock());
            quicksort(A, 0, SIZE-1);
            e_t_s = double(clock());
            t_q_s += (e_t_s - s_t_s )/CLOCKS_PER_SEC*1000;

            initialize(A, l, SIZE);
            s_t_s = double(clock());
            R_quicksort(A, 0, SIZE-1);
            e_t_s = double(clock());
            t_r_s += (e_t_s - s_t_s )/CLOCKS_PER_SEC*1000;

            initialize(A, l, SIZE);
            s_t_s = double(clock());
            insertion_sort(A,SIZE);
            e_t_s = double(clock());
            t_i_s += (e_t_s - s_t_s )/CLOCKS_PER_SEC*1000;

            initialize(A, l, SIZE);
            s_t_s = double(clock());
            sort(A, A+SIZE);
            e_t_s = double(clock());
            t_st_s += (e_t_s - s_t_s )/CLOCKS_PER_SEC*1000;

            s_t_s = double(clock());
            quicksort(A, 0, SIZE-1);
            e_t_s = double(clock());
            t_s_q_s += (e_t_s - s_t_s )/CLOCKS_PER_SEC*1000;

            s_t_s = double(clock());
            R_quicksort(A, 0, SIZE-1);
            e_t_s = double(clock());
            t_s_r_s += (e_t_s - s_t_s )/CLOCKS_PER_SEC*1000;

        }
        delete A;
        cout << SIZE << " " << t_m_s/20 << "  " << t_q_s/20 << " " << t_r_s/20 << " "  << t_i_s/20 << " "  << t_s_q_s/20 <<" " << t_s_r_s/20 <<" " << t_st_s/20 << endl;
        myfile << SIZE << "," << t_m_s/20 << "," << t_q_s/20 << "," << t_r_s/20 << "," << t_i_s/20 << "," << t_s_q_s/20 << "," << t_s_r_s/20 << "," << t_st_s/20 << endl;
    }
    myfile.close();
    return 0;
}


