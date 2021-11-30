package com.ami.study.algorithm;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author wangchendong
 */
public class TopK {

    public static void main(String[] args) {
        int[] arr = {5, 4, 1, 3, 6, 2, 9, 0, 8, 7};
        TopK topK = new TopK();
        int[] leaseNumbersByArray = topK.getLeaseNumbersByArray(arr, 4);
        System.out.print("array: ");
        for (int j : leaseNumbersByArray) {
            System.out.print(j + " ");
        }
        System.out.println();

        int[] leastNumbersByQuickSelect = topK.getLeastNumbersByQuickSelect(arr, 4);
        System.out.print("quick select: ");
        for (int j : leastNumbersByQuickSelect) {
            System.out.print(j + " ");
        }
        System.out.println();

        int[] leastNumbersByHeap = topK.getLeastNumbersByHeap(arr, 4);
        System.out.print("heap: ");
        for (int j : leastNumbersByHeap) {
            System.out.print(j + " ");
        }
        System.out.println();
    }

    public int[] getLeastNumbersByHeap(int[] arr, int k) {
        if (k == 0) {
            return new int[0];
        } else if (k >= arr.length) {
            return arr;
        }
        // 使用一个最大堆（大顶堆）
        // Java 的 PriorityQueue 默认是小顶堆，添加 comparator 参数使其变成最大堆
        Queue<Integer> heap = new PriorityQueue<>(k, (i1, i2) -> Integer.compare(i2, i1));

        for (int e : arr) {
            // 当前数字小于堆顶元素才会入堆
            if (heap.isEmpty() || heap.size() < k || e < heap.peek()) {
                heap.offer(e);
            }
            if (heap.size() > k) {
                heap.poll(); // 删除堆顶最大元素
            }
        }

        // 将堆中的元素存入数组
        int[] res = new int[heap.size()];
        int j = 0;
        for (int e : heap) {
            res[j++] = e;
        }
        return res;
    }

    public int[] getLeaseNumbersByArray(int[] arr, int k) {
        if (k == 0) {
            return new int[0];
        } else if (k >= arr.length) {
            return arr;
        }
        int[] res = new int[k];
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                res[0] = arr[0];
            } else if (i < k) {
                res[i] = arr[i];
                sort(res, i);
            } else if (arr[i] < res[k - 1]) {
                res[k - 1] = arr[i];
                sort(res, k - 1);
            }
        }
        return res;
    }

    void sort(int[] a, int hi) {
        for (int i = hi; i > 0; i--) {
            if (a[i] < a[i - 1]) {
                swap(a, i - 1, i);
            } else {
                return;
            }
        }
    }

    public int[] getLeastNumbersByQuickSelect(int[] arr, int k) {
        if (k == 0) {
            return new int[0];
        } else if (arr.length <= k) {
            return arr;
        }

        // 原地不断划分数组，将最小的k个元素放到数组前面
        partitionArray(arr, 0, arr.length - 1, k);

        int[] result = new int[k];
        System.arraycopy(arr, 0, result, 0, k);

        return result;
    }

    private void partitionArray(int[] arr, int lo, int hi, int k) {
        // 做一次 partition 操作，前m个元素为较小的数
        int m = partition(arr, lo, hi);
        if (k < m) {
            // 最小的 k 个数一定在前 m 个数中，递归划分
            partitionArray(arr, lo, m - 1, k);
        } else if (k > m) {
            // 在右侧数组中寻找最小的 k-m 个数
            partitionArray(arr, m + 1, hi, k);
        }
    }

    int partition(int[] a, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        int v = a[lo];
        while (true) {
            while (a[++i] < v) {
                if (i == hi) {
                    break;
                }
            }
            while (a[--j] > v) {
                if (j == lo) {
                    break;
                }
            }

            if (i >= j) {
                break;
            }
            swap(a, i, j);
        }
        swap(a, lo, j);

        // a[lo .. j-1] <= a[j] <= a[j+1 .. hi]
        return j;
    }

    void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
