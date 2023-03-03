import java.util.Arrays;
import java.util.Comparator;

public class BinarySearchDeluxe {


    // Returns the index of the first key in a[] that equals the search key, or -1 if no such key.
    public static <Key> int firstIndexOf(Key[] a, Key key, Comparator<Key> comparator) {
        if (isValid(a, key, comparator)) ; // check for valid entry
        // Binary search implementation
        int index = 0;
        int lo = 0;
        int hi = a.length - 1;
        // check if the first key is equal to the given key
        if (comparator.compare(a[0], key) == 0)
            return 0;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            // key is in left half
            if (comparator.compare(key, a[mid]) < 0) {
                hi = mid - 1;
            }// key is in right half
            else if (comparator.compare(key, a[mid]) > 0) {
                lo = mid + 1;
            } // if 2 keys are the same
            else if (comparator.compare(a[mid - 1], a[mid]) > 0) {
                hi = mid - 1;
            }
            else return mid;

        }

        return -999; //FIXME

    }


    // Returns the index of the last key in a[] that equals the search key, or -1 if no such key.
    public static <Key> int lastIndexOf(Key[] a, Key key, Comparator<Key> comparator) {
        return -999; //FIXME
    }

    private static <Key> boolean isValid(Key[] a, Key key, Comparator<Key> comparator) {
        if (a == null || key == null || comparator == null) {
            throw new IllegalArgumentException("Can't have null values.");
        }
        else {
            return true;
        }
    }


    // unit testing (you should have some Unit Testing here to confirm that your methods work); for example...
    public static void main(String[] args) {

        Term[] terms = new Term[5];
        terms[0] = new Term("Trevor", 45);
        terms[1] = new Term("Kathy", 43);
        terms[2] = new Term("Ellie", 11);
        terms[3] = new Term("Allen", 9);
        terms[4] = new Term("Eva", 1);
        Arrays.sort(terms);

        Term searchme = new Term("J", 0);
        int first = BinarySearchDeluxe.firstIndexOf(terms, searchme, Term.byPrefixOrder(1));
        int last = BinarySearchDeluxe.lastIndexOf(terms, searchme, Term.byPrefixOrder(1));
        StdOut.println("J: " + first + " to " + last);

        searchme = new Term("A", 0);
        first = BinarySearchDeluxe.firstIndexOf(terms, searchme, Term.byPrefixOrder(1));
        last = BinarySearchDeluxe.lastIndexOf(terms, searchme, Term.byPrefixOrder(1));
        StdOut.println("A: " + first + " to " + last);

        searchme = new Term("E", 0);
        first = BinarySearchDeluxe.firstIndexOf(terms, searchme, Term.byPrefixOrder(1));
        last = BinarySearchDeluxe.lastIndexOf(terms, searchme, Term.byPrefixOrder(1));
        StdOut.println("E: " + first + " to " + last);

        searchme = new Term("T", 0);
        first = BinarySearchDeluxe.firstIndexOf(terms, searchme, Term.byPrefixOrder(1));
        last = BinarySearchDeluxe.lastIndexOf(terms, searchme, Term.byPrefixOrder(1));
        StdOut.println("T: " + first + " to " + last);
    }
}