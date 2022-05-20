class LRUCache {
    //LinkedHashMap is ordered and the items are accessible at O(1) complexity
    private LinkedHashMap<Integer, Integer>map = new LinkedHashMap<>();
    private int cap;
    
    public LRUCache(int capacity) {
        cap = capacity;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        updateRecentAccess(key);
        return map.get(key);
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.put(key, value);
            updateRecentAccess(key);
            return;
        }
        
        if (map.size() >= cap) {
            //when exceeding the capacity, the least used item should be removed
            int oldestKey = map.keySet().iterator().next();
            map.remove(oldestKey);
        }
        map.put(key, value);
    }
    
    //nodes close to the tail of the list are recently accessed
    public void updateRecentAccess(int key){
        int val = map.get(key);
        map.remove(key);
        map.put(key,val);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */