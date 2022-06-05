class Solution {
    boolean[] onPath;         //log the current path of traversal
    boolean[] visited;        //log the nodes visited
    boolean conflict = false; //whether the graph has cycle
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);
    
        visited = new boolean[numCourses];
        onPath = new boolean[numCourses];
        
        for (int i = 0; i < numCourses; i++) {
            traverse(graph, i);
        }
    
        //if no conflict then by default !conflict means a pass
        return !conflict;
    }
    
    //construct the graph using an adjacency list
    public List<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new LinkedList[numCourses];
        
        for (int i = 0; i < numCourses; i++) {
        graph[i] = new LinkedList<>();
    }
        
        for(int[] p : prerequisites){
            int target = p[0];
            int prereq = p[1];
            
            graph[target].add(prereq);
        }
        
        return graph;
    }

    public void traverse(List<Integer>[] graph, int node){
        if (onPath[node]) {
            conflict = true;
        }

        if (visited[node] || conflict) {
            return;
        }
        
        visited[node] = true;
        onPath[node] = true;
        
        for (int t : graph[node]) {
            traverse(graph, t);
        }
        
        //clear the when before leaving the node
        onPath[node] = false;
    }
}