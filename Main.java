class Main {

//   Given an array of positive numbers and a positive number ‘S’, find the length of the smallest contiguous subarray whose sum is greater than or equal to ‘S’. Return 0, if no such subarray exists.

// Example 1:

// Input: [2, 1, 5, 2, 3, 2], S=7 
// Output: 2
// Explanation: The smallest subarray with a sum great than or equal to '7' is [5, 2].
// Example 2:

// Input: [2, 1, 5, 2, 8], S=7 
// Output: 1
// Explanation: The smallest subarray with a sum greater than or equal to '7' is [8].

  private static int smallestSubArrayWithGivenSum(int sum, int[] arr) {
    int result = Integer.MAX_VALUE;
    int windowSum = 0;
    int start = 0;
    for (int end = 0; end < arr.length; end++) {
      windowSum += arr[end];
      while (windowSum >= sum) { //shrink the sliding window
        result = Math.min(result, end - start + 1);
        windowSum -= arr[start];
        start++;
      }
    }

    return result == Integer.MAX_VALUE ? 0 : result;

  }

  public static void main(String[] args) {
    int result = Main.smallestSubArrayWithGivenSum(8, new int[] { 3, 4, 1, 1, 6 });
    System.out.println("----" + result);
  }

}