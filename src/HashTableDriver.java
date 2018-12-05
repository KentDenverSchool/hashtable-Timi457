public class HashTableDriver{
public static void main(String[] args) {
        //System.out.println(200 % 180);
        //System.out.println(2069 % 180);

        HashTable hT = new HashTable(10);
        System.out.println("Trying to get the value from an empty table. expected result: null ");
        System.out.println(hT.get("timi"));
        System.out.println("put (tiny, timea alexandra ryan) into table. expected result = true");
        System.out.println(hT.put("tiny", "timea alexandra ryan"));
        System.out.println("put (ariel, althea cohen-porter) into table. expected result = true");
        System.out.println(hT.put("ariel", "althea cohen-porter"));
        System.out.println("put (lambchop, liam chief daniel) into table. expected result = true");
        System.out.println(hT.put("lambchop", "liam chief daniel"));
        System.out.println("Get tiny out of table. expected result  = timea alexandra ryan");
        System.out.println(hT.get("tiny"));
        }}