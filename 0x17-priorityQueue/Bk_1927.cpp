#include <bits/stdc++.h>
using namespace std;

#define fastio ios_base::sync_with_stdio(0); cin.tie(0); cout.tie(0);

int arr[100002];

int n;
int cmd;
int data;

int lastidx;

void swap(int idx1, int idx2){
    int temp = arr[idx1];
    arr[idx1] = arr[idx2];
    arr[idx2] = temp;
}

void push_back(int data){
    arr[++lastidx] = data;
    
    int cur = lastidx;
    // 부모보다 작으면 swap
    while(cur > 1 && arr[cur] < arr[cur / 2]){
        swap(cur, cur/2);
        cur /= 2;
    }
}

int pop(){
    int re = 0;
    if(lastidx == 0)
        return 0;
    else
        re = arr[1];
    
    arr[1] = arr[lastidx--];

    int cur = 1;
    int child = 0;
    while(true){
        child = cur * 2;

        // 오른쪽 자식도 확인
        if(child+1 <=lastidx && arr[child] > arr[child + 1])
            child++;
        
        if(child > lastidx || arr[child] > arr[cur])
            break;
        
        swap(child, cur);

        cur = child;
    }

    return re;
}

int main(){
    fastio;

    cin >> n;
    for(int i=0; i<n; i++){
        cin >> cmd;
        if(cmd > 0)
            push_back(cmd);
        else
            cout << pop() << "\n";
    }
    return 0;
}
