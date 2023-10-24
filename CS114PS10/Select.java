import java.util.Random;

public class Select {

  static Random rm;

  public static void main(String[] args) {

  }

  public int select(int[] A, int i, int j, int q) { // select qth smallest
    if (i == j)
      return A[i];
    // int pivotindex = (int) (Math.random() * (j - i + 1)) + i; // Pick a random
    // pivot
    int pivotindex = (j - i) / 2;
    swap(A, pivotindex, j); // Stick pivot at end

    // k will be the first position in the right subarray
    int k = partition(A, i - 1, j, A[j]);
    swap(A, k, j); // Put pivot in place

    int sz = k - i;
    if (q == sz + 1)
      return A[k];
    else if (q <= sz)
      return select(A, i, k - 1, q);
    else
      return select(A, k + 1, j, q - sz - 1);
  }

  static int partition(int[] A, int l, int r, int pivot) {
    do { // Move bounds inward until they meet
      while (A[++l] < pivot)
        ;
      while ((r != 0) && (A[--r] >= pivot))
        ;
      swap(A, l, r); // Swap out-of-place values
    } while (l < r); // Stop when they cross
    swap(A, l, r); // Reverse last, wasted swap
    return l; // Return first position in right partition
  }

  private static void swap(int[] A, int i, int j) {
    int temp = A[j];
    A[j] = A[i];
    A[i] = temp;
  }
}
