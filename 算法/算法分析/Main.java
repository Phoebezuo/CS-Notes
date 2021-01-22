public class Main{
    public static void main(String[] args) {
        int[] nums = new int[] {-2,4,5,-3};
        ThreeSum ts;
        int result;

        ts = new ThreeSumSlow();
        result = ts.count(nums);
        System.out.println("three sum slow output: " + result);

        ts = new ThreeSumBinarySearch();
        result = ts.count(nums);
        System.out.println("three sum binary search output: " + result);

        ts = new ThreeSumTwoPointer();
        result = ts.count(nums);
        System.out.println("three sum two pointers output: " + result);
    }
}
