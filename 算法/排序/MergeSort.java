public class Merge extends Sort {

    @Override
    public void sort(int[] nums) {
        mergesort(nums, new int[nums.length], 0, nums.length - 1);
    }

    private void mergesort(int[] nums, int[] temp, int leftStart, int rightEnd) {
        if (leftStart >= rightEnd) { return; }

        int mid = (leftStart + rightEnd) / 2;
        mergesort(nums, temp, leftStart, mid);
        mergesort(nums, temp, mid + 1, rightEnd);
        mergehalf(nums, temp, leftStart, rightEnd);

        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }

    private void mergehalf(int[] nums, int[] temp, int leftStart, int rightEnd) {
        int leftEnd = (leftStart + rightEnd) / 2;
        int rightStart = leftEnd + 1;
        int size = rightEnd - leftStart + 1;

        int left = leftStart;
        int right = rightStart;
        int index = leftStart;

        while (left <= leftEnd && right <= rightEnd) {
            if (nums[left] <= nums[right]) {
                temp[index++] = nums[left++];
            } else {
                temp[index++] = nums[right++];
            }
        }

        // copy remaining element from the left side
        System.arraycopy(nums, left, temp, index, leftEnd - left + 1);

        // copy remaining element from the right side
        System.arraycopy(nums, right, temp, index, rightEnd - right + 1);

        System.arraycopy(temp, leftStart, nums, leftStart, size);
    }
}
