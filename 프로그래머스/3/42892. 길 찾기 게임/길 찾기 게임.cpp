#include <string>
#include <vector>
#include <algorithm>
#include <iostream>
using namespace std;

struct Node{
    int name;
    int x;
    Node* left;
    Node* right;
    Node(int n,int xx,Node* a,Node* b){
        name = n, x = xx, left = a, right = b;
    }
};

struct xy{
    int n;
    int x;
    int y;
};
bool cmp(xy a, xy b){
    if(a.y == b.y) return a.x < b.x;
    return a.y > b.y;
}
vector<xy> v;
void insert(Node* head, Node* node){
    Node* root = head;
    Node* prev = root;
    while(root != NULL){
        prev = root;
        if(root -> x < node -> x) root = root->right;
        else root = root -> left;
    }
    if(prev->x < node -> x) prev->right = node;
    else prev->left = node;
    return;
}
vector<int> an;
void pre(Node* root){
    if(root == NULL) return;
    an.push_back(root->name);    
    pre(root -> left);
    pre(root -> right);
}

void post(Node* root){
    if(root == NULL) return;    
    post(root -> left);
    post(root -> right);
    an.push_back(root->name);
}

vector<vector<int>> solution(vector<vector<int>> nodeinfo) {
    vector<vector<int>> answer;
    for(int i = 0; i< nodeinfo.size();i++)
        v.push_back({i+1,nodeinfo[i][0],nodeinfo[i][1]});
    sort(v.begin(),v.end(),cmp);
    Node* head = new Node(v[0].n,v[0].x ,NULL,NULL);
    
    for(int i = 1; i< v.size();i++)
        insert(head,new Node(v[i].n,v[i].x ,NULL,NULL));
    
    pre(head);
    answer.push_back(an);
    an.clear();
    post(head);
    answer.push_back(an);
    
    return answer;
}