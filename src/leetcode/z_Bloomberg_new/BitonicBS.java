package leetcode.z_Bloomberg_new;

public class BitonicBS {
    static int asceSearch(int[] arr, int low, int high, int key) {
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == key) return mid;
            if (arr[mid] > key) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    static int descSearch(int[] arr, int low, int high, int key) {
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == key) {
                return mid;
            }
            if (arr[mid] < key) {
                high = mid + 1;
            }
        }
        return -1;
    }

    static int findBitonicPoint(int[] arr, int n, int left, int right) {
        int mid;
        mid = left + (right - left) / 2;
        if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) return mid;
        else {
            if (arr[mid] > arr[mid - 1] && arr[mid] < arr[mid + 1]) {
                findBitonicPoint(arr, n, mid, right);
            } else {
                if (arr[mid] < arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                    findBitonicPoint(arr, n, left, mid);
                }
            }
        }
        return mid;
    }

    int search(int[] arr, int n, int key, int index) {
        if (key > arr[index]) {
            return -1;
        } else if (key == arr[index]) {
            return index;
        } else {
            int temp = asceSearch(arr, 0, index - 1, key);
            if (temp != -1) {
                return temp;
            }
            return descSearch(arr, index + 1, n - 1, key);
        }
    }

    public int mainFunc(int[] arr, int key) {
        int len = arr.length;
        int left = 0;
        int right = len - 1;
        int index = findBitonicPoint(arr, len, left, right);
        return search(arr, len, key, index);
    }
}
