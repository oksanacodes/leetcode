## Declaration - array
If we store strings which only contains letter a to z, we can declare an array whose size is 26 in each node to store 
its children nodes. And for a specific character c, we can use `c - 'a'` 
as the index to find the corresponding child node in the array.
````java
class TrieNode {
// change this value to adapt to different cases
public static final N = 26;
public TrieNode[] children = new TrieNode[N];

    // you might need some extra values according to different cases
};
````
It is really fast to visit a child node. It is comparatively easy to visit a specific child since we can easily 
transfer a character to an index in most cases. But not all children nodes are needed. So there might be some waste of space.

## Declaration - map
We can declare a hashmap in each node. The key of the hashmap are characters and the value is the corresponding child node.

````java
class TrieNode {
    public Map<Character, TrieNode> children = new HashMap<>();
    
    // you might need some extra values according to different cases
}
````
It is even easier to visit a specific child directly by the corresponding character. 
But it might be a little slower than using an array. However, it saves some space since we only store the children 
nodes we need. It is also more flexible because we are not limited by a fixed length and fixed range.

## Complexity
Time complexity : O(m), where m is the key length.
In each iteration of the algorithm, we either examine or create a node in the trie till we reach the end of the key.
This takes only m operations.

Space complexity : O(m).
In the worst case newly inserted key doesn't share a prefix with the the keys already inserted in the trie.
We have to add m new nodes, which takes us O(m) space.