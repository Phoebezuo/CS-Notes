public class Main{

    static int[] nums = new int[] {-2,4,5,-3};
    static ThreeSum ts;

    public static void main(String[] args) {
//        slow();
//        binary_search();
        two_pointers();
    }

    public static void slow() {
        ts = new ThreeSumSlow();
        System.out.println("three sum slow output: " + ts.count(nums));
    }

    public static void binary_search() {
        ts = new ThreeSumBinarySearch();
        System.out.println("three sum binary search output: " + ts.count(nums));
    }

    public static void two_pointers() {
        ts = new ThreeSumTwoPointer();
        System.out.println("three sum two pointers output: " + ts.count(nums));
    }
}
