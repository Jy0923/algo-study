#include <bits/stdc++.h>
using namespace std;

#define fastio ios_base::sync_with_stdio(0); cin.tie(0); cout.tie(0);

int arr [100002];
// 연산 개수
int n;

int idx = 0;


void swap(int idx1, int idx2){
    int temp = arr[idx1];
    arr[idx1] = arr[idx2]; 
    arr[idx2] = temp;
}

int top(){
    if(idx > 0) return arr[1];
    else return -1;
}

void push_back(int data){
    arr[++idx] = data;
    
    int cur = idx;
    while(cur > 1 && arr[cur] >= arr[cur / 2]) {
        swap(cur, cur / 2);
        cur /= 2;
    }    
    
}

int pop(){
    
    int maxVal = 0;

    if(idx == 0)
        return 0;
    else maxVal = arr[1];

    // 루트 노드 삭제
    arr[1] = arr[idx];
    // 마지막 노드 삭제
    arr[idx--] = 0;

    int cur = 1;
    while(true){
        // 왼쪽 자식으로 놓고 생각
        int child = cur * 2;

        if(child + 1 <= idx && arr[child] < arr[child+1])
            child++; // 오른쪽 자식
        
        if(child > idx || arr[child] < arr[cur])
            break;
        
        swap(cur, child);
        
        cur = child;
    }

    return maxVal;
}

int main(){
    
    fastio;
    cin >> n;

    int cur = 0;
    for(int i=0; i<n; i++){
        cin >> cur;

        if(cur==0)
            cout << pop() << "\n";
        else{
            push_back(cur);
        }
        
    }

    return 0;
}
