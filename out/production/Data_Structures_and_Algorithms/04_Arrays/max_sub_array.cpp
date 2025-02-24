#include <iostream>
#include <climits>
using namespace std;

int maxCrossingSum(int nums[], int low, int mid, int high)
{
  int sum = 0;
  int left_sum = INT_MIN;
  for (int i = mid; i >= low; i--)
  {
    sum += nums[i];
    left_sum = max(left_sum, sum);
  }

  sum = 0;
  int right_sum = INT_MIN;
  for (int i = mid + 1; i <= high; i++)
  {
    sum += nums[i];
    right_sum = max(sum, right_sum);
  }

  return max(right_sum, left_sum);
}

int maxSubArray(int nums[], int low, int high)
{
  if (low == high)
    return nums[low];
  else
  {
    int mid = (low + high) / 2;
    int left_max = maxSubArray(nums, low, mid);
    int right_max = maxSubArray(nums, mid + 1, high);
    int crossind_sum = maxCrossingSum(nums, low, mid, high);

    return max(left_max, max(right_max, crossind_sum));
  }
}

int main()
{
  int nums[] = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
  int size = sizeof(nums) / sizeof(nums[0]);

  int result = maxSubArray(nums, 0, size - 1);
  cout << "Maximum subarray sum: " << result << endl;

  return 0;
}
