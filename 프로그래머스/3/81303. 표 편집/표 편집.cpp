#include <string>
#include <vector>
#include <sstream>
#include <stack>
#include <iostream>
using namespace std;

struct Node{
    int n;
    Node* next;
    Node* prev;
    Node(int n, Node* next, Node* prev){
        this->n = n;
        this->next = next;
        this->prev = prev;
    }
    
};

string solution(int n, int k, vector<string> cmd) {
    string answer(n,'O');
    
    stack<Node*> st;
    Node* node = new Node(0,NULL,NULL);
    for(int i = 1; i<n;i++){
        Node* cur = new Node(i,NULL,node);
        node->next = cur;
        node = cur;
    }
    
    int cur = k;
    for(int i = 0; i < n - 1 - k; i++)
        node = node->prev;
    
    for(auto cmd : cmd){
        if(cmd[0] == 'D'){
            int num = stoi(cmd.substr(2));
            while(num--)
                node = node -> next;
            
        }
        else if(cmd[0] == 'U'){
            int num = stoi(cmd.substr(2));
            while(num--)
                node = node -> prev;
            
        }
        else if(cmd[0] == 'C'){
            st.push(node);
            answer[node -> n] = 'X';
            if(node -> prev != NULL) node->prev->next = node->next;
            
            if(node -> next != NULL){
                node->next->prev = node->prev;
                node = node->next;
            }
            else if(node -> next == NULL) node = node->prev;
            
        }
        else if(cmd[0] == 'Z'){
            Node* del = st.top();
            answer[del->n] = 'O';
            st.pop();
            
            if(del->prev != NULL) del->prev->next = del;
            if(del->next != NULL) del->next->prev = del;
            

        }
    }
   
 
    
    
    return answer;
}