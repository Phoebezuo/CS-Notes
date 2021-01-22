import java.util.*;

public class Main {

    static int[] nums = { 12, 11, 13, 5, 6, 7 };

    public static void main(String[] args) {
        // SelectionSort();
        // BubbleSort();
        // InsertionSort();
        // ShellSort();
        // MergeSort();
        // QuickSort();
        HeapSort();
    }

    public static void SelectionSort() {
        new Selection().sort(nums);
        System.out.println("Selection: " + Arrays.toString(nums));
    }

    public static void BubbleSort() {
        new Bubble().sort(nums);
        System.out.println("Bubble: " + Arrays.toString(nums));
    }

    public static void InsertionSort() {
        new Insertion().sort(nums);
        System.out.println("Insertion: " + Arrays.toString(nums));
    }

    public static void ShellSort() {
        new Shell().sort(nums);
        System.out.println("Shell: " + Arrays.toString(nums));
    }

    public static void MergeSort() {
        new Merge().sort(nums);
        System.out.println("MergeSort: " + Arrays.toString(nums));
    }

    public static void QuickSort() {
        new Quick().sort(nums);
        System.out.println("QuickSort: " + Arrays.toString(nums));
    }

    public static void HeapSort() {
        new Heap().sort(nums);
        System.out.println("HeapSort: " + Arrays.toString(nums));
    }
}
