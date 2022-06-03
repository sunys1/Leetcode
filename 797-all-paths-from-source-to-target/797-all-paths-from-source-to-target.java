class Solution {
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> list = new LinkedList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        traverse(graph, 0, list);
        return res;
    }
    
    public void traverse(int[][] graph, int node, LinkedList<Integer> path){
        path.addLast(node);
        
        if(node == graph.length - 1){
            res.add(new LinkedList<>(path)); 
        }
        
        for(int i : graph[node]){
            traverse(graph, i, path);
        }
        
        path.removeLast();
    }
}