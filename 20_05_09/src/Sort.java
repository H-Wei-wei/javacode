
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class Sort {

    // 归并排序
    public static void mergeSort(int[] array) {
        mergeSortHelper(array,0,array.length);
    }

    private static void mergeSortHelper(int[] array, int left, int right) {
        // [ 0, array.length)
        if(right - left <= 1) {
            return;
        }
        int mid = (left + right) / 2;
        // [0,mid)
        mergeSortHelper(array,left,mid);
        // [mid, right)
        mergeSortHelper(array,mid,right);
        merge(array,left,mid, right);
    }

    private static void merge(int[] array, int left,int mid, int right) {
        // [ 0, mid)
        // [ mid, right)
        int cur1 = left;
        int cur2 = mid;
        // 临时空间可以容纳 两个数组合并以后的结果
        int[] output = new int[right - left];
        // 当前 output 容纳了几个数据
        int outputIndex = 0;
        while (cur1 < mid && cur2 < right) {
            if(array[cur1] <= array[cur2]) {
                output[outputIndex] = array[cur1];
                cur1++;
                outputIndex++;
            }else {
                output[outputIndex] = array[cur2];
                cur2++;
                outputIndex++;
            }
        }
        while(cur1 < mid) {
            output[outputIndex] = array[cur1];
            cur1++;
            outputIndex++;
        }
        while(cur2 < right) {
            output[outputIndex] = array[cur2];
            cur2++;
            outputIndex++;
        }
        // 再将临时空间中的数据拷贝到原数组中
        for(int i = 0; i < right-left; i++) {
            array[left + i] = output[i];
        }

    }

    // 快速排序
    public static void quickSortByLoop(int[] array) {
        Stack<Integer> stack = new Stack<>();
        // [ 0, array.length-1]
        stack.push(0);
        stack.push(array.length-1);
        while(!stack.isEmpty()) {
            int right = stack.pop();
            int left = stack.pop();
            if(left >= right) {
                continue;
            }
            int index = partition(array,left,right);
            // 右子树入栈
            stack.push(index + 1);
            stack.push(right);
            // 左子树入栈
            stack.push(left);
            stack.push(index - 1);
        }
    }
    private static int partition(int[] array, int left, int right) {
        int baseValue = array[right];
        int i = left;
        int j = right;
        while(i < j){
            // 1.从左往右找一个比基准值大的值
            while(i < j && array[i] <= baseValue) {
                i++;
            }
            // 此时 i 指向大于基准值的元素
            // 2.找一个比基准值小的值
            while(i < j && array[j] >= baseValue) {
                j--;
            }
            // 此时 j 指向小于基准值的元素
            // 3.交换 i 和 j 位置元素
            if(i < j) {
                swap(array, i,j);
            }
        }
        // i 和 j 重合
        // 交换 i 位置元素和 基准值
        swap(array, i, right);
        return i;
    }

    public static void swap(int[] array, int a, int b) {
        int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }

    public static void main(String[] args) {
        /*ArrayList<Integer> list = new ArrayList<>();
        list.add(7);
        list.add(4);
        list.add(5);
        list.add(2);
        list.add(9);
        list.add(1);
        list.add(3);

        // 对抽象类进行排序
        Collections.sort(list);
        System.out.println(list);

        // 对数组进行排序
        int[] array = {3,2,6,5,7,9,8,1};
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));*/

        int[] array = {3,5,8,2,9,7,6,1,4};
        //quickSortByLoop(array);
        mergeSort(array);
        System.out.println(Arrays.toString(array));
    }
}
