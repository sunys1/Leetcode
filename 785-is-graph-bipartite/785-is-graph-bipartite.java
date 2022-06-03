class Solution {
    boolean isValid = true; //the indicator
    boolean[] nodes;        //use true, false to divide up the nodes
    boolean[] visited;      //register whether a node is visited
    
    public boolean isBipartite(int[][] graph) {
        //visit the child graph of each node to ensure that all of them are Bipartie.
        int numNodes = graph.length;
        nodes = new boolean[numNodes];
        visited = new boolean[numNodes];
        
        for(int i = 0; i < numNodes; i++){
            //traverse the unvisited nodes
            if(!visited[i]){
                visited[i] = true;
                traverse(graph, i);   
            }
        }
        
        return isValid;
    }
    
    public void traverse(int[][] graph, int node){
        for(int n : graph[node]){
            if(!visited[n]){
                //if not visited, set it as visited; 
                //put it in the opposite set, and traverse its child graph.
                visited[n] = true;
                nodes[n] = !nodes[node];
                traverse(graph, n);
            }else{
                //if visited, check if it is in a different set
                if(nodes[n] == nodes[node]) isValid = false;
            }
        }
    }
}