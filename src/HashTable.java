import java.util.ArrayList;

/**
 * Name: Timi Ryan
 * Lab Name: hashTable
 * Lab Purpose: create a hashtable to search data easier and answer questions
 * Date: 11/15/18
 * Collaborators: None
 */


    /*
    # Lab:
    ## Challenge one: (put answer in your comments)
    * Which is a better hashfunction:
    * x % n where n is a large number with several factors
    * x % n where n is a large prime number
    Prove your answer with a simple example.

    A large prime number is a better hashfunction for modulo because as there are no less factors there will be less
    collisions

        200%30 = 20
        200%25 = 0
        200%2  = 0          there are more likely to be collisons with large numbers that have many factors
        200%63 = 11         than with prime numbers
        200%180 = 20

        2069%30 = 29
        2069%25 = 19
        2069%2  = 1
        2069%63 = 53
        2069%24 = 89


    ## Challenge two: (answer in comments)
    Is char values summed % 599 a good hash function for strings? Why or why not?

        No. Although 599 is prime, it is not a good function for strings because if you have strings of the same length
        with the same characters (order doesn't matter as it is summed) you will have collisions.

    ## Challenge three: (answer in comments)
    Take a look at Java's HashMap class and how it produces hashed values.
    (You may have to look at other classes to find the actual mathematical function! Follow the trail of breadcrumbs...)

        The result is multiplied by 31 and then assigned to result (total result)

    for (Object element : a)
        result = 31 * result + (element == null ? 0 : element.hashCode());

    ## Challenge four: (code)
    Implement a HashTable1 for Strings using arrays (caution python users) and a hash function you choose/design.

     */


public class HashTable {
    ArrayList[] sA;
    private int cap;
    private int sfilled;


    public HashTable(int capacity) {
        sfilled = 0;
        cap = capacity;
        sA = new ArrayList[cap];
        for(int i = 0; i < cap; i++){
            sA[i] = new ArrayList();
        }
    }

    public int getSfilled(){
        return sfilled;
    }

    public int getCap(){
        return cap;
    }

    //put hashes the key to an index in your array, and places the value there. Fails if there are collisions/repeat keys.
    public boolean put(String key, String value) {
        int index = hashCode(key);
        sfilled++;
        if (sA[index].add(key)) {
            sA[index].add(value);
            return true;
        }
        if ((sfilled/cap) * 100 > 80){
            cap = cap*2;
            resize(cap);
        }
        return false;
    }

    //get hashes the key to get the index, and returns that element. Returns null if key not found.
    public String get(String key) {
        int index = hashCode(key);
        for (int i = 0; i< sA[index].size(); i+=2){
            if (key.equals(sA[index])){
                return (String)sA[index].get(i+1);
            }
        }
        return null;
    }

    //returns the unique int in the range of the [0, array length)
    private int hashCode(String key) {
        return key.hashCode() % cap;
    }

        /* QUIZ MODIFICATIONS//
    ## Unit Quiz - Building on Hashing

#### First task

    Sometimes we start with a hashing space that is too large or too small for our key set. In these instances we would
    like to be able to make `m` (our **hashspace** or the range of allowed hashed key values) larger to reduce
    collisions or smaller to save memory. To accomplish this you are going to add the following method to your
    data structure:

     */

    //Updates m to the new value. Rehashes all keys
    public void resize(int newM){
        cap = newM;
        ArrayList [] nArr = new ArrayList[cap];
        for(int i = 0; i < sA.length; i++){
            int ind = sA[i].get(0).hashCode();
            nArr[ind] = sA[i];
        }
    }
/*
    #### Second task

    It is time to resolve collisions. There are several different ways to do this, but I am going to encourage you
    to use "chaining." This means that all the keys that hash to the same value will be stored in a new data structure
    that starts at the appropriate index in the your main array. E.g.

| Array  |
            |--------|
            | []     |
            | [K1, V1]     |
            | []     |
            | [K2, V2], [K3, V3]|
            | []     |
            | [K0, V0] |
            | []     |


            **Quick tips:**
            - Given how data is stored in your dictionary, what is the easiest way to just expand that entry in your
    array?
            - Make sure to update your `get`, `put`, and `remove` methods to account for this new behavior.
*/

/*
#### Third task

    Modify your class to double the size of `m` when more than the total number of key-value pairs stored exceeds
     80% of `m`.
*/




}
