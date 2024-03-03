#include <stdio.h>
#include <stdlib.h>
struct node
{
  int data;
  struct node *next;
};

struct node *sort_list(struct node *head)
{
  struct node *temp1, *temp2;
  for (temp1 = head; temp1 != NULL; temp1 = temp1->next)
  {
    for (temp2 = temp1->next; temp2 != NULL; temp2 = temp2->next)
    {
      if (temp2->data < temp1->data)
      {
        int x = temp1->data;
        temp1->data = temp2->data;
        temp2->data = x;
      }
    }
  }
  return head;
}

int main()
{
  int n;
  printf("Enter Size: \n");
  scanf("%d", &n);
  int arr[n];
  printf("Enter elements from 0 to 100: \n");
  for (int i = 0; i < n; i++)
    scanf("%d", &arr[i]);

  struct node *AOP[10];
  for (int i = 0; i < 10; i++)
    AOP[i] = NULL;
  for (int i = 0; i < n; i++)
  {
    int id = (arr[i]) / (10);
    struct node *newnode = (struct node *)malloc(sizeof(struct node));
    newnode->data = arr[i];
    newnode->next = NULL;
    if (AOP[id] == NULL)
      AOP[id] = newnode;
    else
    {
      newnode->next = AOP[id];
      AOP[id] = newnode;
    }
  }
  for (int i = 0; i < 10; i++)
    AOP[i] = sort_list(AOP[i]);
  int j = 0;
  for (int i = 0; i < 10; i++)
  {
    struct node *temp = AOP[i];
    while (temp != NULL)
    {
      arr[j++] = temp->data;
      temp = temp->next;
    }
  }
  printf("Sorted array: \n");
  for (int i = 0; i < n; i++)
    printf("%d ", arr[i]);
}
