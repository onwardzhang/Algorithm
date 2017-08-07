public class Solution {
    // copy their answers
//     public List<String> findItinerary(String[][] tickets) {
//         for (String[] ticket : tickets)
//             targets.computeIfAbsent(ticket[0], k -> new PriorityQueue()).add(ticket[1]);
//         visit("JFK");
//         return route;
//     }

//     Map<String, PriorityQueue<String>> targets = new HashMap<>();
//     List<String> route = new LinkedList();

//     void visit(String airport) {
//         while(targets.containsKey(airport) && !targets.get(airport).isEmpty())
//             visit(targets.get(airport).poll());
//         route.add(0, airport);
//     }
    
//     public List<String> findItinerary(String[][] tickets) {
//         Map<String, PriorityQueue<String>> targets = new HashMap<>();
//         for (String[] ticket : tickets)
//             targets.computeIfAbsent(ticket[0], k -> new PriorityQueue()).add(ticket[1]);
//         List<String> route = new LinkedList();
//         Stack<String> stack = new Stack<>();
//         stack.push("JFK");
//         while (!stack.empty()) {
//             while (targets.containsKey(stack.peek()) && !targets.get(stack.peek()).isEmpty())
//                 stack.push(targets.get(stack.peek()).poll());
//             route.add(0, stack.pop());
//         }
//         return route;
//     }
    
    Map<String, PriorityQueue<String>> flights;
    LinkedList<String> path;

    public List<String> findItinerary(String[][] tickets) {
        flights = new HashMap<>();
        path = new LinkedList<>();
        for (String[] ticket : tickets) {
            flights.putIfAbsent(ticket[0], new PriorityQueue<>());
            flights.get(ticket[0]).add(ticket[1]);
        }
        dfs("JFK");
        return path;
    }

    public void dfs(String departure) {
        PriorityQueue<String> arrivals = flights.get(departure);
        while (arrivals != null && !arrivals.isEmpty())
            dfs(arrivals.poll());
        path.addFirst(departure);
    }
    // // failed, doesn't work when there are duplicates flights
    // public List<String> findItinerary(String[][] tickets) {
    //     if (tickets == null || tickets.length == 0 || tickets[0].length == 0) {
    //         return null;
    //     }
    //     Map<String, List<String>> neighborsMap = new HashMap<>();
    //     Map<String, Boolean> edgesMap = new HashMap<>();
    //     for (String[] ticket : tickets) {
    //         if (!neighborsMap.containsKey(ticket[0])) {
    //             neighborsMap.put(ticket[0], new ArrayList<String>());
    //         }
    //         neighborsMap.get(ticket[0]).add(ticket[1]);
    //         edgesMap.put(ticket[0] + '-' + ticket[1], false);
    //     }
    //     for (List<String> neighbors : neighborsMap.values()) {
    //         Collections.sort(neighbors);
    //     }
    //     List<String> res = new LinkedList<>();
    //     List<String> path = new LinkedList<>();
    //     path.add("JFK");
    //     dfsHelper("JFK", neighborsMap, edgesMap, res, path);
    //     return res;
    // }
    // private void dfsHelper(String node, Map<String, List<String>> neighborsMap, Map<String, Boolean> edgesMap, List<String> res, List<String> path) {
    //     if (path.size() == edgesMap.size() + 1) {
    //         for (String s : path) {
    //             res.add(s);
    //         }
    //         return;
    //     }
    //     if (res.size() != 0) { // otherwise, will return all possible Itineraries
    //         return;
    //     }
    //     if (!neighborsMap.containsKey(node)) {
    //         return;
    //     }
    //     for (String neigh : neighborsMap.get(node)) {
    //         String edge = node + '-' + neigh;
    //         if (!edgesMap.get(edge)) {
    //             edgesMap.put(edge, true);
    //             path.add(neigh);
    //             dfsHelper(neigh, neighborsMap, edgesMap, res, path);
    //             path.remove(path.size() - 1);
    //             edgesMap.put(edge, false);
    //         }
    //     }
    // }
}