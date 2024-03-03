#include <iostream>
using namespace std;

void merge(int arr[], int low, int mid, int high)
{
  int n1 = mid - low + 1;
  int n2 = high - mid;

  int arr2[n1], arr3[n2];
  for (int i = 0; i < n1; i++)
  {
    arr2[i] = arr[low + i];
  }
  for (int i = 0; i < n2; i++)
  {
    arr3[i] = arr[mid + 1 + i];
  }

  int i = 0, j = 0, k = low;
  while (i < n1 && j < n2)
  {
    if (arr2[i] < arr3[j])
    {
      arr[k++] = arr2[i++];
    }
    else if (arr2[i] > arr3[j])
    {
      arr[k++] = arr3[j++];
    }
    else
    {
      arr[k++] = arr2[i++];
      j++;
    }
  }

  while (i < n1)
  {
    arr[k++] = arr2[i++];
  }
  while (j < n2)
  {
    arr[k++] = arr3[j++];
  }
}

void mergeSort(int arr[], int low, int high)
{
  if (low < high)
  {
    int mid = (low + high) / 2;
    mergeSort(arr, low, mid);
    mergeSort(arr, mid + 1, high);

    merge(arr, low, mid, high);
  }
}

int main()
{
  int n = 10;
  int arr[] = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
  mergeSort(arr, 0, 10);
  cout << "After Sorting: " << endl;
  for (int i = 0; i < n; i++)
  {
    cout << arr[i] << " ";
  }
  return 0;
}
