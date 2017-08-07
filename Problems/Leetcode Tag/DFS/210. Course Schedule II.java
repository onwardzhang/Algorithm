public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // topological sort
        if (numCourses <= 0) {
            return null;
        }
        // indegree
        int[] indegree = new int[numCourses];
        Map<Integer, List<Integer>> nodeToNexts = new HashMap<>();
        for (int[] pair : prerequisites) {
            indegree[pair[0]]++;
            if (!nodeToNexts.containsKey(pair[1])) {
                nodeToNexts.put(pair[1], new ArrayList<>());
            }
            nodeToNexts.get(pair[1]).add(pair[0]);
        }
        
        int[] res = new int[numCourses];
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int tmp = queue.poll();
            res[count++] = tmp;
            if (!nodeToNexts.containsKey(tmp)) {
                continue;
            }
            for (int next : nodeToNexts.get(tmp)) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }
        if (count != numCourses) {
            return new int[0];
        }
        return res;
    }
}