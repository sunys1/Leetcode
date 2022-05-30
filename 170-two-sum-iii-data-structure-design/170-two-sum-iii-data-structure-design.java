class TwoSum {
    List<Integer> numList;
    HashMap<Integer,Integer> map;
    public TwoSum() {
        numList = new ArrayList<>();
        map = new HashMap<>();
    }
    
    public void add(int number) {
        numList.add(number);
        map.put(number, map.getOrDefault(number, 0) + 1);
    }
    
    public boolean find(int value) {
        for(int e : numList){
            int other = value - e;
            if(map.containsKey(other)){
                if(other == e && map.get(other) > 1) return true;
                if(other != e && map.get(other) > 0) return true;
            }
        }
        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */