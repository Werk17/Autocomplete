/******************************************************************************
 *  Name: Charles Werk  
 *
 *  Hours to complete assignment (optional): 8
 *
 ******************************************************************************/

Programming Assignment 2: Autocomplete


/******************************************************************************
 *  Describe how your firstIndexOf() method in BinarySearchDeluxe.java
 *  finds the first index of a key that equals the search key.
 *****************************************************************************/

First, we checked if the inputs were non-null values and then did a check
for the first element in the a[] array with the given key. If the elements are the same, then return the first index (0 in this case).
If not the first item, then continually check using the Binary Search Algorithm. Everything is similar to traditional binary search, except 
that the middle element and the item immediately to the left of it are being checked if they are the same. If they are the same, then decrease the midpoint
by 1 and check again. If they are not the same, then the binary search will continue as expected by manipulating the hi, lo, and mid variables. 
In theory, the leftmost element that matches the given keyword will be the first index that equals the key. 


/******************************************************************************
 *  What is the order of growth of the number of compares (in the
 *  worst case) that each of the operations in the Autocomplete
 *  data type make, as a function of the number of terms n and the
 *  number of matching terms m?  (Big-Oh notation)
 *
 *  Recall that with order-of-growth notation, you should discard
 *  leading coefficients and lower-order terms, e.g., m^2 + m log n.
 *****************************************************************************/

constructor: O(n^2)  
Initialize and copy over all elements of local terms to class terms. Then sort the array using Arrays.sort ( worst case is nearly sorted which is linear)

allMatches(): O(NlogN) 
Based on binary search when retrieving items. However, the matches[] array will get created based on difference of the last index and the first index 
which becomes M-items to include into a smaller array, but not as big as original. 

numberOfMatches(): O(NlogN)
This method refers to the binary deluxe which is (logN) time to retrieve first matching item and (logN) to get the last matching item and return the difference




/******************************************************************************
 *  Known bugs / limitations.
 *****************************************************************************/
 

/******************************************************************************
 *  Describe whatever help (if any) that you received.
 *  Don't include readings or lectures, but do include
 *  any help from people (including course staff, lab TAs,
 *  classmates, and friends) and attribute them by name.
 *
 *  Also include any resources (including the web) that you may
 *  may have used in creating your design.
 *****************************************************************************/

Had help with Lindsay (TA) with implementing the Term comparators and proper syntax  e.g. compare(v.query), w.query).
Also had help with Doug (Instructor) about implementing the binary search algorithm into the binary search deluxe class.


/******************************************************************************
 *  Describe any serious problems you encountered.
 *****************************************************************************/


Had issues with my orderByPrefix function that allowed the program to run for small prefixes like "b", "be", but broke when searching for "because". 
I fixed it by reworking the class to check each sub1 and sub2 alone instead of multiple cases of an if statement that checked them at the same time. 
Another troublesome feature was to check whether the midpoint in binary search deluxe was equal to the left or right items and to proceed accordingly.
Sometimes, the output will lose some formatting on certain queries such as "ro". the last element gets squeezed to the left. 



/******************************************************************************
 *  List any other comments here. Feel free to provide any feedback
 *  on how much you learned from doing the assignment, and whether
 *  you enjoyed doing it.
 *****************************************************************************/


