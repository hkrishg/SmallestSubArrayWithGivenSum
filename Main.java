class Main {

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
    // [3, 4, 1, 1, 6], sum=8 ------- > output = 3 as [1,1,6]
    int result = Main.smallestSubArrayWithGivenSum(8, new int[] { 3, 4, 1, 1, 6 });
    System.out.println("----" + result);
  }

}