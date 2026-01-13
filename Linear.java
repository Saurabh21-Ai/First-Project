public class Linear {
    private int arr [];

    // Constructor
    Linear (int [] arr) {                                       // Necessary while creating object
        this.arr = arr;
    }


    // Getter Array
    public void getValue () {
        System.out.print ("Element in array: ");
        for (int i : this.arr) {                                // Time Complexity: O(n), Space Complexity: O(1)
            System.out.print (i + ", ");
        }
        System.out.println ();
    }

    // Linear Search implementation
    public int linearSearch (int arr [], int value) {           // Time Complexity: O(n), Space Complexity: O(1)
        for (int i : arr) {
            if (i == value) {
                return i;
            }
        }
        return -1;
    }

    public void BubbleSort (int arr []) {                       // Ex- {3, 1, 4, 5, 2} > {1, 3, 4, 2, '5'} > {1, 3, 2, '4, 5'} > {1, 2, '3, 4, 5'}
        int last = arr.length - 1;
        for (int i = 0; i < last; i++) {       // Each loop take O(n), total n - 1 times iteration
            for (int j = 0; j < last - i; j++) {               // Time Complexity: O (n) * O (n) = O (n^2), Space Complexity: O(1)
                
                if (arr [j] > arr [j + 1]) {
                    // Swap arr [j] and arr [j+1]
                    int temp = arr [j];
                    arr [j] = arr [j + 1];                     // Sorted from end
                    arr [j + 1] = temp;
                }
            }
        }
    }

    // Quick sort implementation
    // public void quickSort (int arr [], int low, int high) {
    //     if (low < high) {
    //         int pi = partition (arr, low, high);
         
    //         quickSort (arr, low, pi - 1);
    //         quickSort (arr, pi + 1, high);
    //     }
    // }

    // private int partition (int arr [], int low, int high) {
    //     int pivot = arr [arr.length / 2];   // Pivot element
    //     int j = (low - 1);          // Index of smaller element

    //     for (int i = low; i < high; i++) {
    //         if (arr [i] <= pivot) {
    //             j++;
    //             // Swap arr [i] and arr[j]
    //             int temp = arr [j];
    //             arr [j] = arr [i];
    //             arr [i] = temp;
    //         }
    //     }

    //     // Swap arr [j+1] and arr [high] (or pivot)
    //     int temp = arr [j + 1];
    //     arr [j + 1] = arr [high];
    //     arr [high] = temp;

    //     return j + 1;
    // }


    @Override
    public boolean equals (Object obj) {
        if (obj == this) return true;
        else if (! (obj instanceof Linear)) {
            return false;
        }

        Linear lin = (Linear) obj;
        if (arr.length != lin.arr.length) return false;
        
        for (int i = 0; i < this.arr.length; i++) {
            if (arr [i] != lin.arr [i]) return false;               // Compare each element of both arrays
        }

        return true;
    }

    @Override
    public int hashCode () {
        int hash = 7;
        for (int i : this.arr) {
            hash = 31 * hash + i;
        }
        return hash;
    }

    @Override
    public String toString () {
        
        return "This is Linear class to format array. %n" +
        "Provided methods are: getValue, linearSearch, BubbleSort, QuickSort, equals, hashCode, toString";
    }
}
