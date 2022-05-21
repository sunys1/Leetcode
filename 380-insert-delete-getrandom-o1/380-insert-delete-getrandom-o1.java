class RandomizedSet {
    //declare an ArrayList to store the elements
    List<Integer>set;
    //declare a HashMap to store the val:index pairs
    HashMap<Integer, Integer>map;
    Random rand;
    public RandomizedSet() {
        set = new ArrayList<>();
        map = new HashMap<>();
        rand = new Random();
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val)) return false;
        set.add(val);
        map.put(val, set.size() - 1);
        return true;
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val)) return false;
        
        int index = map.get(val);
        //swap the last element to index
        int last = set.get(set.size()-1);
        set.set(index, last);
        set.remove(set.size()-1);
        map.put(last, index);
        map.remove(val);
        
        return true;
    }
    
    public int getRandom() {
        return set.get(rand.nextInt(set.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */