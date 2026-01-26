class Solution {
    public int findCircleNum(int[][] isConnected) {
        
        // Create Adjacency List
        int n = isConnected.length;
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();

        for(int i=0; i<n; i++){
            adjList.add(new ArrayList<>());
            for(int j=0; j<n; j++){
                if( i != j && isConnected[i][j] == 1){
                    adjList.get(i).add(j);
                }
            }
        }

        int[] visited = new int[n];
        int provinces = 0;

        for(int city=0; city<n; city++){
            if(visited[city] == 0){
                provinces++;
                dfs(city, visited, adjList);
            }
        }

        return provinces;
    }

    private void dfs(int city, int[] visited, ArrayList<ArrayList<Integer>> adjList){
        visited[city] = 1;
        for(int neighbour : adjList.get(city)){
            if(visited[neighbour] == 0){
                dfs(neighbour, visited, adjList);
            }
        }

    }
}