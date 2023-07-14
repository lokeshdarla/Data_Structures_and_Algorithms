## **Why performance analysis?**

Performance analysis is crucial because it ensures software runs efficiently and meets user needs. Good performance is essential for user satisfaction and the overall success of a software application.

## **Given two algorithms for a task, how do we find out which one is better?**

One naïve way of doing this is – to implement both the algorithms and run the two programs on your computer for different inputs and see which one takes less time. There are many problems with this approach for the analysis of algorithms.

- It might be possible that for some inputs, the first algorithm performs better than the second. And for some inputs second performs better.
- It might also be possible that for some inputs, the first algorithm performs better on one machine, and the second works better on another machine for some other inputs.

> Asymptotic Analysis is a method of analyzing algorithms by evaluating their performance based on the input size, rather than measuring the actual running time. It focuses on how the time or space required by an algorithm increases as the input size grows.
> 

**For example**, let us consider the search problem (searching a given item) in a sorted array.

The solution to above search problem includes:

- **Linear Search** (order of growth is linear)
- **Binary Search** (order of growth is logarithmic).

To understand how Asymptotic Analysis solves the problems mentioned above in analyzing algorithms,

- let us say:
    - we run the Linear Search on a fast computer A and
    - Binary Search on a slow computer B and
    - pick the constant values for the two computers so that it tells us exactly how long it takes for the given machine to perform the search in seconds.
- Let’s say the constant for A is 0.2 and the constant for B is 1000 which means that A is 5000 times more powerful than B.
- For small values of input array size n, the fast computer may take less time.
- **But, after a certain value of input array size, the Binary Search will definitely start taking less time compared to the Linear Search even though the Binary Search is being run on a slow machine**.

## **Does Asymptotic Analysis always work?**

Asymptotic Analysis is the best available method for analyzing algorithms, but it is not perfect. It allows us to compare algorithms based on their growth rates, but it ignores constants, which can be important in specific cases. Additionally, Asymptotic Analysis assumes input sizes larger than a constant value, so there might be situations where an algorithm with slower asymptotic performance is actually faster for small inputs. Therefore, while Asymptotic Analysis is valuable, it has limitations and may not always accurately determine the best algorithm for a particular situation.
