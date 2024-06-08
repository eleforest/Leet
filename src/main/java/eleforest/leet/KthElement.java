package eleforest.leet;

import java.util.Arrays;

/*
TopK element
给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 */
public class KthElement {

    public static class MaxHeap{
        private int [] innerArray;

        public MaxHeap(int [] arr){
            innerArray = Arrays.copyOf(arr, arr.length);
            buildHeap();
        }

        public int poll(){
            int ret = innerArray[0];
            innerArray[0] = Integer.MIN_VALUE;
            buildHeap();
            return ret;
        }

        public int peek(){
            return innerArray[0];
        }

        /*
         * 堆是一个满二叉树
         * 对于根节点，位置为n，2n+1与2n+2是其儿子
         * 反过来，某节点在n，其父在(n-1)/2
         */
        private void buildHeap(){ 
            for(int curr = innerArray.length - 1; curr >= 0; curr --){
                int father = (curr - 1)/2;
                if(father >=0 && innerArray[father] < innerArray[curr]){
                    exchangeValue(father, curr);
                }
            }     
        }
        private void exchangeValue(int idx1, int idx2){

            int temp = 0;
            temp = innerArray[idx1];
            innerArray[idx1] = innerArray[idx2];
            innerArray[idx2] = temp;
        }
        
    }

    public static int kthEle(int[] arr, int k) throws IllegalArgumentException{
        MaxHeap mHeap = new MaxHeap(arr);
        if (k > arr.length){
            throw new IllegalArgumentException("k is larger than array size: " + arr.length);
        }
        int topk = 0;
        for (int idx = 0; idx < k ; idx ++){
            topk = mHeap.poll();
        }
        System.out.println("Top Kth Element of this array is :" +topk);
        return topk;
    }
}

