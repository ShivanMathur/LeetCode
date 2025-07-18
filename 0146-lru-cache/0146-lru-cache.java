class LRUCache {

    /* Brute Force Approach
    */

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

    /*

    public LRUCache(int capacity) {
        
    }
    
    public int get(int key) {
        
    }
    
    public void put(int key, int value) {
        
    }

    */
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */