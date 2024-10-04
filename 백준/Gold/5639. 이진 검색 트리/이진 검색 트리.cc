#include <iostream>
#include <vector>
#include <climits>
#include <queue>
using namespace std;

struct Node {
	int n;
	Node* left;
	Node* right;
	Node(int a, Node* b, Node* c) {
		n = a; left = b; right = c;
	}
};

void insert(Node* root, Node* node) {
	Node* prev = root;
	while (root != NULL) {
		prev = root;
		if (root->n < node->n) root = root->right;
		else if(root->n > node->n) root = root->left;
	}
	if (prev->n < node->n) prev->right = node;
	else if (prev->n > node->n) prev->left = node;
}

void post(Node* root) {
	if (root == NULL) return;

	post(root->left);
	post(root->right);
	cout << root->n << "\n";
}

int main(void) {
	int n;
	vector<int> v;
	while (cin >> n) v.push_back(n);

	Node* head = new Node(v[0], NULL, NULL);
	for (int i = 1; i < v.size(); i++)
		insert(head, new Node(v[i], NULL, NULL));

	post(head);
	return 0;
}