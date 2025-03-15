import java.util.Map;
import java.util.TreeMap;

import java.util.TreeSet;
import java.util.Iterator;

/**
 *
 * TreeMap vs. TreeSet
 *
 * TreeMaps and TreeSets have similarities.
 *
 * - TreeMap implements a sorted collection which is implemented on Java's Map interface.
 *   They store <key, vales> pairs, and which sorted on key / value pairs. No dup keys allowed.
 * - TreeSet implements a sorted collection which is implemented on Java's Set Interface, so
 *   behaves like a set, which does not allow duplicates. Values are stored in value sorted order.
 *
 * Similarities:
 *  1. Both store sorted data.
 *  2. Both are non-synchronized collections - only important if using parallel threads
 *  3. Both support iteration of the collection
 *
 *  Differences:
 *  1. In how store data. TreeSet stores value in ascending order, TreeMap store a key/value pair
 *     in ascending order.
 *  2. In how navigate data. TreeSet implemented on Java's NavigableSet, TreeMap implemented on
 *     NavigableMap.
 *  3. In how deal with duplicates. TreeSet allows NO duplicates, TreeMap allows duplicates
 *     (just no dup keys)
 *
 *  Think of TreeMap as keeping mappings between key and values on a sorted order of key, while
 *  TreeSet just keep one element sorted.
 *
 **/


public class Main {

    public static void main(String[] args) {

        ///////////////////////////////////////////////////////////
        //
        //  TreeMap Class
        //
        ///////////////////////////////////////////////////////////

        TreeMap<Integer, String> treemap = new TreeMap<>();

        /*
         * Insert Elements in TreeMap, utilizes methods:
         * - put() - puts a k/v in  map, if k already exists, will overwrite value with new value.
         * - putIfAbsent() - puts k/v in the map if key is not already there.
         * - putAll() - puts a list of k/v in map
         */

        System.out.println("Sample code inserting elements in TreeMap");

        // using put()  - inserts key/value
        treemap.put(2, "Two");
        treemap.put(3, "Three");
        treemap.put(7, "Seven");

        // putting duplicate key - will overwrite (replace) old value
        treemap.put(3, "THREE");

        // using putIfAbsent() - inserts key/value if key is not present
        treemap.putIfAbsent(6, "Six");

        //using putAll() - inserts all entries from specified map to this map
        TreeMap<Integer, String> numbers = new TreeMap<>();
        numbers.put(1, "One");
        numbers.put(5, "Five");

        treemap.putAll(numbers);

        System.out.println("   TreeMap values: " + treemap);


        /*
         * Access TreeMap Elements, utilizes methods:
         * - entrySet()
         * - keySet()
         * - values()
         * - getKey()
         * - getValue()
         * - getOrDefault()
         */

        System.out.println();
        System.out.println("Sample code accessing elements in TreeMap");

        System.out.println("   Key/Value mappings: " + treemap.entrySet());    // Using entrySet
        System.out.println("   Keys: " + treemap.keySet());                    // Using KeySet
        System.out.println("   Values: " + treemap.values());                  // Using Values

        // Another ex. iterating over the collection (recall TreeMap is implemented on java Map class)
        System.out.print("   Key/Value Mappings using for loop: [");
        for (Map.Entry<Integer, String> entry : treemap.entrySet() )
            System.out.print(entry.getKey() + "=" + entry.getValue() + ", ");
        System.out.println("]");

        // Get a single key/value pair
        String value = treemap.get(2);
        System.out.println("   Using Get() for value key '2': " + value);


        value = treemap.getOrDefault(1, "Use_This_Value_if_Key_Not_Found");
        System.out.println("   Using GetOfDefault() with key of '1': " + value);

        // If key is not found, as in this case, returns the default string
        value = treemap.getOrDefault(10, "Use_This_Value_if_Key_Not_Found");
        System.out.println("   Using GetOfDefault() with key of '10': " + value);


        /*
         * Remove TreeMap elements, utilizes method:
         * - remove()
         */

        System.out.println();
        System.out.println("Sample code removing elements");

        treemap.remove(3);              // remove  key/value pair with just using key

        treemap.remove(2, "Two");            // remove key/value pair, both params must match
        treemap.remove(1, "ONE");            // remove key/value pair, both params must match (this case does not)

        // Print TreeMap, the above removal of key 1 should have returned false as "One" != "ONE"
        System.out.println("   TreeMap values: " + treemap);


        /*
         * Replace TreeMap Elements, utilizes method:
         * - replace()
         */

        System.out.println();
        System.out.println("Sample code replacing elements");

        // Replaces value which has a key value of 5
        treemap.replace(5, "FIVE");

        // Replaces iff key and value also matches. Only the 2nd statement below will fail
        treemap.replace(6, "Six", "UPDATED SIX");       // This will update the value
        treemap.replace(7, "SEVEN", "UPDATED SEVEN");   // this will NOT update the value

        System.out.println("   TreeMap values: " + treemap);

        /*
         * Additional Navigation / Auxiliary methods, utilize methods:
         * - firstKey()
         * - lastKey()
         * - firstEntry()
         * - lastEntry()
         * - higherKey()
         * - higherEntry()
         * - lowerKey()
         * - lowerEntry()
         */

        System.out.println();
        System.out.println("Sample code on additional navigation/auxiliary methods");

        System.out.println("   First key   : " + treemap.firstKey());
        System.out.println("   Last Key    : " + treemap.lastKey());
        System.out.println("   First Entry : " + treemap.firstEntry());
        System.out.println("   Last Entry  : " + treemap.lastEntry());
        System.out.println();
        System.out.println("   Using higherKey(5)   : " + treemap.higherKey(5));
        System.out.println("   Using higherEntry(5) : " + treemap.higherEntry(5));
        System.out.println("   Using lowerKey(5)    : " + treemap.lowerKey(5));
        System.out.println("   Using lowerEntry(5)  : " + treemap.lowerEntry(5));

        /*
         * Other methods (see TreeMap Library Documentation)
         * - pollFirstEntry() - returns and removes teh entry associated with first key of map
         * - pollLastEntry() - returns and removes the entry associated with the last key of the map
         * - headMap() - returns all the key/value parts of a treemap before a specified key
         * - tailMap() - returns all the key/value pairs of a treemap starting from a specified key
         * - subMap() - returns all key/value pairs between 2 keys
         */



        ///////////////////////////////////////////////////////////
        //
        //  TreeSet Class
        //
        ///////////////////////////////////////////////////////////

        TreeSet<Integer> numberSet = new TreeSet<>();
        TreeSet<Integer> evenNumberSet = new TreeSet<>();

        /*
         * Insert elements to a TreeSet, utilize methods:
         * - add() - add element
         * - addAll() - add all in set passed as param
         */

        System.out.println();
        System.out.println("STARTING TreeSet Sample code, Starting with adding elements");

        evenNumberSet.add(2);
        evenNumberSet.add(4);
        evenNumberSet.add(6);

        numberSet.add(1);
        numberSet.add(3);
        numberSet.add(5);

        numberSet.addAll ( evenNumberSet );

        System.out.println("New TreeSet: " + numberSet);

        /*
         * Accessing TreeSet elements, utilize the iterator() method
         */

        System.out.println();
        System.out.println("Accessing TreeSet elements using iterator");

        Iterator<Integer> itr = numberSet.iterator();
        System.out.print("TreeSet using iterator: ");
        while (itr.hasNext() ) {
            System.out.print( itr.next() + ", ");
        }
        System.out.println();


        /*
         * Removing TreeSet elements, utilize methods:
         * - remove() - remove one element
         * - removeAll() - remove all elements from set
         */

        System.out.println();
        System.out.println("Removing TreeSet elements");

        numberSet.remove(2);             // Removing 2
        numberSet.removeAll( numberSet );   // Remove all elements

        System.out.println("TreeSet should be empty: " + numberSet );


        /*
         * Misc. Navigation of TreeSet elements, utilize methods:
         * - first() - returns first element from sorted order
         * - last() - returns last element form sorted order
         */

        System.out.println();
        System.out.println("Misc. navigation of  TreeSet elements");

        numberSet.add(1);
        numberSet.add(2);
        numberSet.add(3);
        numberSet.add(4);
        numberSet.add(5);
        numberSet.add(8);

        int first = numberSet.first();
        int last  = numberSet.last();

        System.out.println("First value: " + first + "  Last value: " + last);

        /*
         * TreeSet methods: ceiling(), floor(), higher() and lower() methods
         * - ceiling - returns the lowest member that is greater the param, if param is in tree, returns param
         * - floor - returns the greatest element less than the param, if param is in tree, returns param
         * - higher - returns the lowest element that is greater than param
         * - lower - returns the greatest value that is less than param
         */

        System.out.println();
        System.out.println("Ceiling, floor, higher, and lower methods of TreeSet");

        System.out.println("   Using ceiling: " + numberSet.ceiling(6));
        System.out.println("   Using floor  : " + numberSet.floor(6));
        System.out.println("   Using higher : " + numberSet.higher(4));
        System.out.println("   Using lower  : " + numberSet.lower(4));


        /*
         * Union, Intersection, and Difference of Sets
         */
        TreeSet<Integer> s1 = new TreeSet<>();
        TreeSet<Integer> s2 = new TreeSet<>();

        System.out.println();
        System.out.println("Exercising UNION, INTERSECTION, and DIFFERENCE of sets");
        // Create 2 sets of {1,2} and {2,3}
        s1.add(1);
        s1.add(2);
        s2.add(2);
        s2.add(3);

        // Union of two sets, s1 = {1,2}, s2 = {2,3}, result will be {1,2,3}
        s1.addAll(s2);
        System.out.println("After union, should be {1,2,3} : " + s1);

        // Intersection of two sets, s1 = {1,2}, s2 = {2,3}, result will be {2}
        s1.remove(3);
        s1.retainAll(s2);
        System.out.println("After intersection, should be {2} : " + s1);

        // Difference of s1 from s2 where s1 = {1,2}, s2 = {2,3}, result will be {1}
        s1.add(1);
        s1.removeAll(s2);
        System.out.println("After difference, should be {1} : " + s1);


        /*
         * Other IMPORTANT methods (see TreeSet Library Documentation)
         * - pollFirst() - returns and removes first element
         * - pollLast() - returns and removes last element
         * - headSet() - returns all the values before the param passed
         * - tailSet() - returns all the values starting from a specified value
         * - subSet() - returns all values pairs between 2 keys
         * - containsAll() - this checks if a set is a subset of another.
         * - clone() - clones a set
         * - contains() - search the set of a value
         * - isEmpty() - checks if empty
         * - size() - returns the size in elements
         * - clear() - removes all elements
         */
    }
}