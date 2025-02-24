#include <iostream>
using namespace std;

void selectionSort(int arr[], int n)
{
  for (int i = 0; i < n - 1; i++) // c1 * (n - 1) times
  {
    int min = i;                    // c2 n - 1 times
    for (int j = i + 1; j < n; j++) // c3 * n * (n - i) times
    {
      if (arr[j] < arr[min])
      {
        min = j;
      }
    }

    int temp = arr[i]; // c4 * (n - 1) times
    arr[i] = arr[min];
    arr[min] = temp;
  }
}

int main()
{
  int n = 10;
  int arr[] = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
  selectionSort(arr, 10);
  cout << "After Sorting: " << endl;
  for (int i = 0; i < n; i++)
  {
    cout << arr[i] << " ";
  }
  return 0;
}
