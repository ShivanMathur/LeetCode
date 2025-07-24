class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Form a graph
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for(int i=0; i<numCourses; i++){
            adjList.add(new ArrayList<>());
        }

        // Create the adjacency list: u -> v
        int m = prerequisites.length;
        for(int i=0; i<m; i++){
            adjList.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        // Find indegree for all the nodes
        int[] indegree = new int[numCourses];
        for(int i=0; i<numCourses; i++){
            for(int it : adjList.get(i)){
                System.out.println(it);

                indegree[it]++;
            }
        }

        // Topological Sort || Kahn's Algorithm
        Queue<Integer> queue = new LinkedList<>();

        for(int i=0; i<numCourses; i++){
            if(indegree[i] == 0){
                queue.add(i);
            }
        }

        List<Integer> topo = new ArrayList<>();
        while(!queue.isEmpty()){
            int node = queue.poll();
            topo.add(node);

            for(int it : adjList.get(node)){
                indegree[it]--;
                if(indegree[it] == 0){
                    queue.add(it);
                }
            }
        }

        if(topo.size() == numCourses){
            return true;
        }

        return false;
    }
}