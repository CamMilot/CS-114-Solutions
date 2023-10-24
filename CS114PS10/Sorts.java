import java.util.ArrayList;

public class Sorts {

    public int kqselect(ArrayList<Integer> A, int i, int j, int k) {
        int pivotIndex = findPivot(A, i, j);
        swap(A, pivotIndex, j);

        int partition = partition(A, i, j, A.get(j));

        if (partition == k - 1) {
            return A.get(partition);
        } else if (partition < k - 1) {
            return kqselect(A, partition + 1, j, k);
        } else {
            return kqselect(A, i, partition - 1, k);
        }
    }

    private int findPivot(ArrayList<Integer> A, int i, int j) {
        int randIndex = (int) (Math.random() * (j - i + 1)) + i;
        return randIndex;
    }

    private int partition(ArrayList<Integer> A, int l, int r, int pivot) {
        do {
            while (A.get(++l).compareTo(pivot) < 0)
                ;
            while ((r != 0) && (A.get(--r).compareTo(pivot) >= 0))
                ;
            swap(A, l, r);
        } while (l < r);
        swap(A, l, r);
        return l;
    }

    private void swap(ArrayList<Integer> A, int i, int j) {
        int temp = A.get(j);
        A.set(j, A.get(i));
        A.set(i, temp);
    }
}