class Solution {
    public int findCircleNum(int[][] isConnected) {
        int[] visited = new int[isConnected.length];
        int provinces = 0;

        for(int city=0; city<isConnected.length; city++){
            if(visited[city] == 0){
                dfs(isConnected, visited, city);
                provinces++;
            }
        }

        return provinces;
    }

    public void dfs(int[][] isConnected, int[] visited, int city){
        visited[city] = 1;
        for(int neighbour=0; neighbour<isConnected[0].length; neighbour++){
            if(visited[neighbour] != 1 && isConnected[city][neighbour] == 1){
                dfs(isConnected, visited, neighbour);
            }
        }
    }
}