package com.tfm.algorithm;

/**
 * 二分查找法
 */
public class BinarySearch {
    public static void main(String[] args){
        int params[] = {1,2,3,3,3,3,7,8};
        int target = 3;
        int result = binarySearchRight(params,target);
        System.out.println(result);
    }
    /**
     * 二分查找法 全封闭边界[]
     */
    public static int binarySearch(int args[],int target){
        int left = 0;
        int right= args.length-1;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(args[mid]==target){
                return mid;
            }else if(args[mid]<target){
                left = mid +1;
            }else if(args[mid]>target){
                right= mid -1;
            }
        }
        return -1;
    }

    /**
     * 二分查找法全封闭边界[],搜索左边界
     * @param args
     * @param target
     * @return
     */
    public static int binarySearchLeft(int args[],int target){
        int left = 0;
        int right= args.length-1;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(args[mid]==target){
                right=mid-1;
            }else if(args[mid]<target){
                left = mid +1;
            }else if(args[mid]>target){
                right= mid-1;
            }
        }
        if(left>args.length||args[left]!=target){
            return -1;
        }
        return left;
    }

    /**
     * 二分查找法全封闭边界[],搜索右边界
     * @param args
     * @param target
     * @return
     */
    public static int binarySearchRight(int args[],int target){
        int left = 0;
        int right= args.length-1;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(args[mid]==target){
                left=mid+1;
            }else if(args[mid]<target){
                left = mid +1;
            }else if(args[mid]>target){
                right= mid-1;
            }
        }
        if(right<0||args[right]!=target){
            return -1;
        }
        return right;
    }
}
