package eleforest.leet;


public class FindMinimumInRotatedSortedArray {
	/*
	153_Find_minimum_in_Rotated_Sorted_Array
	 */
	public static int findMin(int[] a) {
		if (a == null) return -1;
		int l = 0;
		int r = a.length - 1;
		int n = a.length;
		while (l < r) {
			int m = l + (r - l) / 2;
			if (a[m] < a[n - 1]) { // left a[m] < a[r]
				if (m - 1 >= 0 && a[m] < a[m - 1]) {
					return a[m];
				}
				r = m;
			} else {    // right
				l = m;
			}
		}
		return a[l];
	}
}