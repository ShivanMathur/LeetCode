class Solution {
    class Pair{
        int row;
        int col;
        int time;

        public Pair(int row, int col, int time){
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }

    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }

        Queue<Pair> queue = new LinkedList<>();
        
        int n = grid.length;
        int m = grid[0].length;

        int[][] visited = new int[n][m];
        int countFresh = 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == 2){
                    queue.add(new Pair(i, j, 0));
                    visited[i][j] = 2;
                }
                else{
                    visited[i][j] = 0;
                }
                if(grid[i][j] == 1){
                    countFresh++;
                }
            }
        }

        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};
        
        int count = 0;
        int time_required = 0;

        while(!queue.isEmpty()){
            Pair p = queue.poll();
            int r = p.row;
            int c = p.col;
            int t = p.time;

            time_required = Math.max(time_required, t);

            for(int i=0; i<4; i++){
                int nrow = r + drow[i];
                int ncol = c + dcol[i];

                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m 
                && visited[nrow][ncol] == 0 && grid[nrow][ncol] == 1){
                    queue.add(new Pair(nrow, ncol, t+1));
                    visited[nrow][ncol] = 2;
                    count++;
                }
            }
        }

        System.out.println(count + " " + countFresh);

        if(count != countFresh){
            return -1;
        }

        return time_required;
    }
}