#include <iostream>
using namespace std;

int partition(int arr[], int low, int high)
{
  int pivot = arr[low];
  int i = low;
  int j = high;

  do
  {
    do
    {
      i++;
    } while (arr[i] <= pivot);

    do
    {
      j--;
    } while (arr[j] > pivot);

    if (i < j)
    {
      swap(arr[i], arr[j]);
    }

  } while (i < j);

  swap(arr[low], arr[j]);
  return j;
}

void quickSort(int arr[], int low, int high)
{
  if (low < high)
  {
    int pivot = partition(arr, low, high);
    quickSort(arr, low, pivot);
    quickSort(arr, pivot + 1, high);
  }
}

int main()
{
  int n = 10;
  int arr[] = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
  quickSort(arr, 0, 10);
  cout << "After Sorting: " << endl;
  for (int i = 0; i < n; i++)
  {
    cout << arr[i] << " ";
  }
  return 0;
}
