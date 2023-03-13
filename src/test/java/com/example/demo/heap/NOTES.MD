## A Heap has the following properties:
1. Insertion of an element into the Heap has a time complexity of O(logN);
2. Deletion of an element from the Heap has a time complexity of O(logN);
3. The maximum/minimum value in the Heap can be obtained with O(1) time complexity.

# Construct an empty Min Heap
PriorityQueue<Integer> minHeap = new PriorityQueue<>();

# Construct an empty Max Heap
PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());