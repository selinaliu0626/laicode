import java.util.*;

//After the event, our company will take the students out for dinner.
// The restaurant has a large round table that can fit the whole party.
// We want to know if we can arrange the students so that the names of all students
// around the table form an “infinite loop.” For each pair of neighboring students s1 and s2,
// the last letter of s1’s name must be identical to the first letter of s2’s name.
//
//For example, “ALICE” and “ERIC” can sit together, but “ALICE” and “BOB” cannot.
//Given an array of names, determine if it is possible to arrange the students at the round table in this way.
//
//Input: an array of names. Each name contains capital letters only.
//
//Output: true or false.
//
//Example
//
//Input: String[] = {“ALICE”, “CHARLES”, “ERIC”, “SOPHIA”}
//
//Output: true
//
public class InfiniteLoopAroundtheDinnerTable {
    //method 1: use graph
    //in this method
    //time: n^2  ->for build graph and find loop both are n*(n-1)
    //space:
    static class GraphNode{
        String name;
        List<GraphNode> neighbors;
        boolean visited;
        GraphNode(String name){
            this.name = name;
            this.neighbors = new ArrayList<>();
        }
    }
    private void  buildGraph(String[] names,GraphNode[] graphNodes) {
        //initial the graph
        for (int i = 0; i < names.length; i++) {
            names[i] = names[i].toUpperCase();
            graphNodes[i] = new GraphNode(names[i]);
        }
        //update the neis
        for (int i = 0; i < graphNodes.length; i++) {
            List<GraphNode> neighbors = graphNodes[i].neighbors;
            String name = graphNodes[i].name;
            for (int j = 0; j < graphNodes.length; j++) {
                String nei = graphNodes[j].name;
                if (j != i && nei.charAt(0) == name.charAt(name.length() - 1)) {
                    neighbors.add(graphNodes[j]);
                }
            }
        }
    }
        // find loop to make sure can they seat as chain in a round table
        public boolean findLoop(String[] names){
            if(names.length<=1){
                return false;
            }
            GraphNode[] graphNodes = new GraphNode[names.length];
            buildGraph(names,graphNodes);
            return dfs(graphNodes[0],graphNodes[0],graphNodes.length);
        }

    private boolean dfs(GraphNode node, GraphNode start, int length) {
        //base case
        if(length ==0) {
            return node == start;
        }
        if(node.visited) {
            return false;
        }
        //recursion rule
        node.visited =true;
        boolean loop = false;
        List<GraphNode> neighbors = node.neighbors;
        for(GraphNode nei:neighbors) {
            loop = dfs(nei, start, length - 1);
            if (loop) {
                return true;
            }
        }
        //back track
        node.visited = false;

        return loop;
    }





    //method 2: swap permutation method
    public boolean canChain(String[] names) {
        return helper(names,1);
    }

    private boolean helper(String[] names, int index) {
        //base case
        if (index == names.length) {
            return connected(names[index - 1], names[0]);
        }

            //rule
            for (int i = index; i < names.length; i++) {
                if (connected(names[index - 1], names[i])) {
                    swap(names, index, i);
                    if (helper(names, index + 1)) {
                        return true;
                    }
                    swap(names,index,i);
                }
            }
            return false;
        }

    private void swap(String[] names, int i, int j) {
        String temp = names[i];
        names[i] = names[j];
        names[j] = temp;
    }

    private boolean connected(String a, String b) {
        return a.charAt(a.length()-1) ==b.charAt(0);
    }


    public static void main(String[] args) {
        InfiniteLoopAroundtheDinnerTable il = new InfiniteLoopAroundtheDinnerTable();
        String[] names = {"ALICE","CHARLES","SOPHIA","ERIC"};
        boolean res = il.canChain(names);
        //boolean res =il.findLoop(names);
        System.out.println(res);
    }
}
//o(n!)
//space O(n);


