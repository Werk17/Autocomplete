import java.util.Arrays;

public class Autocomplete {
    Term[] terms;

    // Initializes the data structure from the given array of terms.
    public Autocomplete(Term[] terms) {
        if (terms == null)
            throw new NullPointerException("Term cannot be a null value.");
        this.terms = new Term[terms.length];
        // copy items over to global terms
        for (int i = 0; i < terms.length; i++) {
            this.terms[i] = terms[i];
        }
        Arrays.sort(this.terms);

    }

    // Returns all terms that start with the given prefix, in descending order of
    // weight.
    public Term[] allMatches(String prefix) {

        if (prefix == null)
            throw new NullPointerException("Value cannot be null for Prefix");
        int firstIndex = BinarySearchDeluxe.firstIndexOf(terms, new Term(prefix, 0),
                Term.byPrefixOrder(prefix.length()));
        // if there is nothing that matches the given prefix
        if (firstIndex == -1)
            return new Term[0];
        // get the last item matching prefix
        int lastIndex = BinarySearchDeluxe.lastIndexOf(terms, new Term(prefix, 0), Term.byPrefixOrder(prefix.length()));
        // initialize array with only matches based on number of matches
        Term[] matches = new Term[lastIndex - firstIndex + 1];
        // get all the matches by saving current term and going to next term
        for (int i = 0; i < matches.length; i++) {
            matches[i] = terms[firstIndex++];
        }
        // descending order based on weight
        Arrays.sort(matches, Term.byReverseWeightOrder());
        return matches;
    }

    // Returns the number of terms that start with the given prefix.
    public int numberOfMatches(String prefix) {
        if (prefix == null)
            throw new NullPointerException("Cannot have a null value for prefix");
        int firstIndex = BinarySearchDeluxe.firstIndexOf(terms, new Term(prefix, 0),
                Term.byPrefixOrder(prefix.length()));
        int lastIndex = BinarySearchDeluxe.lastIndexOf(terms, new Term(prefix, 0),
                Term.byPrefixOrder(prefix.length()));
        // same when initizing array of matching terms + 1 with offset of indexing
        return lastIndex - firstIndex + 1;
    }

    // A sample client for unit testing
    public static void main(String[] args) {

        // read in the terms from a file
        String filename = args[0];
        In in = new In(filename);
        int N = in.readInt();
        Term[] terms = new Term[N];
        int i;
        for (i = 0; i < N; i++) {
            long weight = in.readLong(); // read the next weight
            in.readChar(); // scan past the tab
            String query = in.readLine(); // read the next query
            terms[i] = new Term(query, weight); // construct the term
        }

        // read in queries from standard input and print out the top k matching terms
        int k = Integer.parseInt(args[1]);
        Autocomplete autocomplete = new Autocomplete(terms);
        while (StdIn.hasNextLine()) {
            String prefix = StdIn.readLine();
            Term[] results = autocomplete.allMatches(prefix);
            for (i = 0; i < Math.min(k, results.length); i++)
                StdOut.println(results[i]);
        }
    }
}