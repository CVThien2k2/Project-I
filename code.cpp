#include<iostream>
using namespace std;
struct Node{
	int data;
	Node*next;
}; 
Node* AddHead(Node*head, int value){
    Node* temp =new Node(); // Kh?i t?o node temp v?i data = value
    temp->data=value;
    if(head == NULL){
        head = temp; // //N?u linked list dang tr?ng th� Node temp l� head lu�n
    }else{
        temp->next = head; // Tr? next c?a temp = head hi?n t?i
        head = temp; // �?i head hi?n t?i = temp(V� temp b�y gi? l� head m?i m�)
    }
    return head;
}

void print(Node*p)
{
	while(p!=NULL){
		cout<< p->data<<"  ";
	}
}
int main(){
	Node*head=new Node();
	head->data=4;
	head->next=NULL;
	for(int i=1;i<5;i++){
		AddHead(head,i);
	}
}
