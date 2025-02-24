#include <iostream>
using namespace std;

void insertionSort(int arr[], int n)
{
  for (int j = 0; j < n; j++)
  {
    int key = arr[j];
    int i = j - 1;
    while (i >= 0 && arr[i] > key)
    {
      arr[i + 1] = arr[i];
      i = i - 1;
    }
    arr[i + 1] = key;
  }
}

int main()
{
  int n = 10;
  int arr[] = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
  insertionSort(arr, 10);
  cout << "After Sorting: " << endl;
  for (int i = 0; i < n; i++)
  {
    cout << arr[i] << " ";
  }
  return 0;
}
