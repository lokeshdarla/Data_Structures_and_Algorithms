# Worst, Average, and Best Case Time Complexities

---

We will take an example of Linear Search and analyze it using Asymptotic analysis.

We can have three cases to analyze an algorithm:

1. Worst Case
2. Average Case
3. Best Case

Below is the algorithm for performing a linear search:

```cpp
// Linearly search x in arr[].
// If x is present then return the index,
// otherwise return -1
int search(int arr[], int n, int x)
{
    int i;
    for (i=0;i<n;i++){
        if(arr[i]==x){
            return i;
        }
    }
    return -1;
}

// Driver program to test the above functions
int main(){
    int arr[]={2,8,12,9};
    int x=12;
    int n=sizeof(arr)/sizeof(arr[0]);
    printf("%d is present in %d index",x,search(arr,n,x));
    getchar();
    return 0;
}
```

- **Worst Case Analysis:** In worst-case analysis, we calculate the upper bound on the running time of an algorithm. We identify the scenario that requires the maximum number of operations to be executed. For example, in linear search, the worst case occurs when the element being searched is not present in the array. The worst-case time complexity of linear search is O(N), where N is the number of elements in the array.
- **Average Case Analysis:** In average case analysis, we consider all possible inputs and calculate the computing time for each input. We then sum up these values and divide the sum by the total number of inputs. This approach requires knowledge or prediction of the distribution of cases. For linear search, assuming a uniform distribution, we sum all cases and divide by (N+1) to determine the average case time complexity.

    ![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/7ffd56f4-3f2b-4a2c-b80f-2386329b3eb0/Untitled.png)

- **Best Case Analysis:** Best case analysis involves calculating the lower bound on the running time of an algorithm. It focuses on the scenario that requires the minimum number of operations to be executed. In the case of linear search, the best case occurs when the element being searched is found at the first location. The number of operations in the best case is constant and not dependent on the size of the input. Therefore, the best-case time complexity for linear search is O(1).

**Summary:**

- Worst-case analysis determines the maximum running time of an algorithm.
- Average case analysis considers all possible inputs and calculates the average running time.
- Best case analysis determines the minimum running time of an algorithm.
- Each type of analysis provides insights into different scenarios and helps evaluate the performance characteristics of an algorithm.

### Example:

In C++:

```cpp
#include <bits/stdc++.h>
using namespace std;

// Linearly search x in arr[].
// If x is present then return the index,
// otherwise return -1
int search(int arr[], int n, int x)
{
   int i;
   for (i = 0; i < n; i++) {
       if (arr[i] == x)
           return i;
   }
   return -1;
}

// Driver's Code
int main()
{
   int arr[] = { 1, 10, 30, 15 };
   int x = 30;
   int n = sizeof(arr) / sizeof(arr[0]);

   // Function call
   cout << x << " is present at index "
        << search(arr, n, x);

   return 0;
}
```

In Java:

```java
import java.util.Scanner;

public class linearsearch {
    public static void main(String[] args) {
        int[] numbers = { 1, 2, 3, 4, 5 };
        int size = 5;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the key element you want to search: ");
        int key = scanner.nextInt();

        // Call the linearSearch method and store the result
        int index = linearSearch(numbers, size, key);

        // Check if the element was found or not
        if (index != -1) {
            System.out.println(key + " is found at index " + index);
        } else {
            System.out.println(key + " is not found in the array.");
        }
    }

    public static int linearSearch(int[] arr, int size, int key) {
        for (int i = 0; i < size; i++) {
            if (arr[i] == key) {
                return i; // Return the index if the key is found
            }
        }
        return -1; // Return -1 if the key is not found
    }
}
```

**Time Complexity Analysis: (In Big-O notation)**

- **Best Case:** O(1) — This will take place if the element to be searched is on the first index of the given list. So, the number of comparisons, in this case, is 1.
- **Average Case:** O(n) — This will take place if the element to be searched is on the middle index of the given list.
- **Worst Case:** O(n) — This will take place if:
    - The element to be searched is on the last index.
    - The element to be searched is not present on the list.

**Important Points:**

- Most of the time, we do the worst-case analysis to analyze algorithms. In the worst analysis, we guarantee an upper bound on the running time of an algorithm, which is a good piece of information.
- The average case analysis is not easy to do in most practical cases and it is rarely done. In the average case analysis, we must know (or predict) the mathematical distribution of all possible inputs.
- The Best Case analysis is bogus. Guaranteeing a lower bound on an algorithm doesn't provide any information as, in the worst case, an algorithm may take years to run.
