class LRUCache {

    /* Brute Force Approach
    TC: O(n) for each put() and get() operation
    SC: O(n)

    private ArrayList<int[]> cache;
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new ArrayList<>();
    }
    
    public int get(int key) {
        // Check if the key exist in the ArrayList.
        for(int i=0; i<cache.size(); i++){
            // If the key is found
            if(cache.get(i)[0] == key){
                // First, store the (key, value) array in temp.
                // Next, remove from the cache as it has been used recently.
                // Add it to the last in the cache, again.
                int[] temp = cache.remove(i);
                cache.add(temp);
                return temp[1];
            }
        }

        // If not found, return -1
        return -1;
    }
    
    public void put(int key, int value) {
        
        // First check if the pair exist in the cache
        for(int i=0; i<cache.size(); i++){
            // If found
            if(cache.get(i)[0] == key){
                // First store the pair in temp array and remove from the ArrayList.
                // Update the temp's 1st index value as it may be updated to something new.
                // Next, add it to the cache again.
                int[] temp = cache.remove(i);
                temp[1] = value;
                cache.add(temp);
                return;
            }
        }

        // If the cache is full, remove the 1st pair to make space for new pair to be added
        if(cache.size() == capacity){
            cache.remove(0);
        }
        // If the cache is not full or space is made for new pair to store,
        // Add it to the cache ArrayList
        cache.add(new int[]{key, value});
    }
    */

    /*
    Doubly Linked List Approach
    */

    class DLLNode{
        int key;
        int val;
        DLLNode next;
        DLLNode prev;

        DLLNode(int key, int val){
            this.key = key;
            this.val = val;
            this.next = null;
            this.prev = null;
        }
    }

    DLLNode head = new DLLNode(-1, -1);
    DLLNode tail = new DLLNode(-1, -1);

    int capacity;
    HashMap<Integer, DLLNode> cache;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();

        head.next = tail;
        tail.prev = head;        
    }

    public void insertion(DLLNode node){
        DLLNode temp = head.next;
        node.next = temp;
        node.prev = head;

        head.next = node;
        temp.prev = node;  
    }

    public void deletion(DLLNode node){
        DLLNode front = node.next;
        DLLNode back = node.prev;

        back.next = front;
        front.prev = back;
    }
    
    public int get(int key) {
        if(cache.containsKey(key)){
            DLLNode node = cache.get(key);
            int val = node.val;

            cache.remove(key);
            deletion(node);
            insertion(node);

            cache.put(key, head.next);
            return val;
        }

        return -1;
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)){
            DLLNode node = cache.get(key);

            cache.remove(key);

            deletion(node);
        }

        if(cache.size() == capacity){
            cache.remove(tail.prev.key);
            deletion(tail.prev);
        }

        insertion(new DLLNode(key, value));
        cache.put(key, head.next);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */