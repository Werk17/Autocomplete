import java.util.Arrays;
import java.util.Comparator;
import edu.princeton.cs.algs4.StdOut;

public class Term implements Comparable<Term> {
    String QUERY;
    long WEIGHT;

    // Initializes a term with the given query string and weight.
    public Term(String query, long weight) {
        QUERY = query;
        WEIGHT = weight;
        // int QLen = QUERY.length();
    }

    public static Comparator<Term> byReverseWeightOrder() {
        return new Comparator<Term>() {
            public int compare(Term v, Term w) {
                // if v > w
                if (v.WEIGHT > w.WEIGHT)
                    return -1;
                // if w > v
                if (v.WEIGHT < w.WEIGHT)
                    return 1;
                // if v == w
                if (v.WEIGHT == w.WEIGHT)
                    return 0;

                return 0;
            }

        };
    }

    // Compares the two terms in lexicographic order but using only the first r
    // characters of each query.
    public static Comparator<Term> byPrefixOrder(int r) {
        return new Comparator<Term>() {
            String sub1;
            String sub2;

            public int compare(Term v, Term w) {
                if (r > v.QUERY.length()) {
                    sub1 = v.QUERY;
                    sub2 = w.QUERY;
                } else {
                    sub1 = v.QUERY.substring(0, r);
                    sub2 = w.QUERY.substring(0, r);
                }
                return sub1.compareTo(sub2);

            }
        };
    }

    // Compares the two terms in lexicographic order by query.
    public int compareTo(Term that) {
        return QUERY.compareTo(that.QUERY);
    }

    // Returns a string representation of this term in the following format:
    // the weight, followed by a tab, followed by the query.
    public String toString() {
        return (WEIGHT + "\t" + QUERY);
    }

    // unit testing (you should have some Unit Testing here to confirm that your
    // methods work); for example...
    public static void main(String[] args) {
        Term[] terms = new Term[5];
        terms[0] = new Term("Trevor", 45);
        terms[1] = new Term("Kathy", 43);
        terms[2] = new Term("Ellie", 11);
        terms[3] = new Term("Allen", 9);
        terms[4] = new Term("Eva", 1);

        Arrays.sort(terms);
        for (Term t : terms) {
            StdOut.println(t);
        }

        StdOut.println("");
        Arrays.sort(terms, Term.byReverseWeightOrder());
        for (Term t : terms) {
            StdOut.println(t);
        }

        StdOut.println("");
        Arrays.sort(terms, Term.byPrefixOrder(1));
        for (Term t : terms) {
            StdOut.println(t);
        }
    }
}