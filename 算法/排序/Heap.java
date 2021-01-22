import java.util.*;
// https://www.youtube.com/watch?v=j-DqQcNPGbE&ab_channel=%E9%BB%84%E6%B5%A9%E6%9D%B0

public class Heap extends Sort {

    @Override
    public void sort(int[] nums) {
        int size = nums.length;

        // Build heap
        // index of last non-leaf node = size / 2 - 1
        for (int i = size / 2 - 1; i >= 0; i--)
            heapify(nums, size, i);

        // One by one extract the max element from heap and
        // replace it with outer leaf
        for (int i = size - 1; i >= 0; i--) {
            swap(nums, i, 0);

            // call max heapify on the reduced heap
            heapify(nums, i, 0);
        }
    }

    // To heapify a subtree with node i
    void heapify(int[] nums, int heapSize, int i) {
        int max = i; // Initialize max as root
        int leftChildIdx = 2 * i + 1;
        int rightChildIdx = 2 * i + 2;

        // If left child is larger than root
        if (leftChildIdx < heapSize && nums[leftChildIdx] > nums[max])
            max = leftChildIdx;

        // If right child is larger than max so far
        if (rightChildIdx < heapSize && nums[rightChildIdx] > nums[max])
            max = rightChildIdx;

        // If max is not root
        if (max != i) {
            swap(nums, i, max);

            // Recursive call to  heapify the sub-tree
            heapify(nums, heapSize, max);
        }
    }
}
