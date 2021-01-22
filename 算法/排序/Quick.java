public class Quick extends Sort {

    @Override
    public void sort(int[] nums) {
        sort(nums, 0, nums.length - 1);
    }

    private void sort(int[] nums, int left, int right) {
        if (left >= right) { return; }

        int pivot = nums[(left + right) / 2];
        int index = partition(nums, pivot, left, right);
        sort(nums, left, index - 1);
        sort(nums, index, right);
    }

    private int partition(int[] nums, int pivot, int left, int right) {
        while (left <= right) {
            // continue to find the element bigger than pivot from the left
            while (nums[left] < pivot) { left++; }

            // continue to find the element smaller than pivot from the right
            while (nums[right] > pivot) { right--; }
            if (left <= right) {
                swap(nums, left, right);
                left++;
                right--;
            }
        }
        return left;
    }
}
