class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        MonotonicQueue window = new MonotonicQueue();
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (i < k - 1) {
                //fill in the first k-1 positions
                window.push(nums[i]);
            } else {
                // the window advances and receives a new element
                window.push(nums[i]);
                // register current max number
                res.add(window.max());
                // remove the number at the beginning of the window
                window.pop(nums[i - k + 1]);
            }
        }
        
        //return the result array
        int[] arr = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            arr[i] = res.get(i);
        }
        
        return arr;
    }
}

class MonotonicQueue {
    LinkedList<Integer> maxq = new LinkedList<>();
    public void push(int n) {
        // remove all elements smaller than n
        while (!maxq.isEmpty() && maxq.getLast() < n) {
            maxq.pollLast();
        }
        // push n into the end of the queue
        maxq.addLast(n);
    }
    
    public int max() {
        return maxq.getFirst();
    }
    
    public void pop(int n) {
        if (n == maxq.getFirst()) {
            maxq.pollFirst();
        }
    }
}