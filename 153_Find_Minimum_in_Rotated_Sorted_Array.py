#Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
#(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
#Find the minimum element.
#You may assume no duplicate exists in the array.
import sys

def find_minimum(sorted_arr):
    min = sorted_arr[0]
    for ele in sorted_arr:
        if ele < min:
            min = ele
            break
    return min

def find_minimum_recursive(sorted_arr):
    pivot = int(len(sorted_arr)/2)
    print sorted_arr, pivot
    if sorted_arr[pivot] > sorted_arr[pivot + 1]:
        return sorted_arr[pivot + 1]
    elif sorted_arr[0] > sorted_arr[pivot]:
        return find_minimum_recursive(sorted_arr[0:pivot + 1])
    else:
        return find_minimum_recursive(sorted_arr[pivot + 1:])        
        

def main():
    if len(sys.argv) != 2:
        raise Exception("Input rotated sorted array as '3,4,5,1,2'")
    print find_minimum_recursive(sys.argv[1].split(","))



if __name__ == "__main__":
    try:
        sys.exit(main())
    except  Exception as e:
        print e
        sys.exit(1)
