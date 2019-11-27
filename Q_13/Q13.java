import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Q13 {


    //use for the BFS traversal
    private Queue<GraphNode> queue = new LinkedList<GraphNode>();
    //use for the DFS traversal
    private Stack<GraphNode> stack = new Stack<GraphNode>();
    private ArrayList<GraphNode> nodes = new ArrayList<GraphNode>();

    public void addEdge(GraphNode node, GraphNode neighbour) {
        if (!hasNeighbour(node, neighbour)) {
            node.addneighbours(neighbour);
        }
        if (!hasNeighbour(neighbour, node)) {
            neighbour.addneighbours(node);
        }
        if (!hasNode(node)) {
            nodes.add(node);
        }
        if (!hasNode(neighbour)) {
            nodes.add(neighbour);
        }
    }

    //reset the visisted of the node
    public void resetVisited() {
        for (int i = 0; i < nodes.size(); i++) {
            nodes.get(i).visited = false;
        }
    }

    public void show() {
        for (int i = 0; i < nodes.size(); i++) {
            System.out.print("Node " + nodes.get(i).name.toString() + " has neighbors: ");
            for (int j = 0; j < nodes.get(i).neighbours.size(); j++) {
                if (j != nodes.get(i).neighbours.size() - 1) {
                    System.out.print(nodes.get(i).neighbours.get(j).name.toString() + ", ");
                } else {
                    System.out.print(nodes.get(i).neighbours.get(j).name.toString());
                }
            }
            System.out.println("");
        }

    }

    public boolean hasNeighbour(GraphNode node, GraphNode neighbour) {
        boolean hasNeighbour = false;
        if (node.neighbours.isEmpty()) {
            hasNeighbour = false;
        } else {
            for (int i = 0; i < node.neighbours.size(); i++) {
                if (node.neighbours.get(i).name.toString().equals(neighbour.name.toString())) {
                    hasNeighbour = true;
                }
            }
        }
        return hasNeighbour;
    }

    public boolean hasNode(GraphNode node) {
        boolean hasNode = false;
        if (nodes.isEmpty()) {
            hasNode = false;
        } else {
            for (int i = 0; i < nodes.size(); i++) {
                if (nodes.get(i).name.toString().equals(node.name.toString())) {
                    hasNode = true;
                }
            }
        }
        return hasNode;
    }

    public void dfs(GraphNode node) {
        System.out.println("The DFS traversal of the graph (starting from Node " + node.name + ") : ");
        stack.add(node);
        while (!stack.isEmpty()) {
            GraphNode element = stack.pop();
            if (!element.visited) {
                System.out.print(element.name + " ");
                element.visited = true;
            }

            List<GraphNode> neighbours = element.getNeighbours();
            for (int i = neighbours.size()-1; i >= 0; i--) {
                GraphNode n = neighbours.get(i);
                if (n != null && !n.visited) {
                    stack.add(n);
                }
            }
        }
        System.out.println("");
    }


    public void bfs(GraphNode node) {
        queue.add(node);
        node.visited = true;
        System.out.println("The BFS traversal of the graph (starting from Node " + node.name + ") : ");
        while (!queue.isEmpty()) {

            GraphNode element = queue.remove();
            System.out.print(element.name + " ");
            List<GraphNode> neighbours = element.getNeighbours();
            for (int i = 0; i < neighbours.size(); i++) {
                GraphNode n = neighbours.get(i);
                if (n != null && !n.visited) {
                    queue.add(n);
                    n.visited = true;

                }
            }

        }
        System.out.println("");
    }

    public static void main(String arg[]) {

        Q13 graph = new Q13();

        GraphNode node1 = new GraphNode("1");
        GraphNode node2 = new GraphNode("2");
        GraphNode node3 = new GraphNode("3");
        GraphNode node4 = new GraphNode("4");
        GraphNode node5 = new GraphNode("5");
        GraphNode node6 = new GraphNode("6");
        GraphNode node7 = new GraphNode("7");

        graph.addEdge(node1, node2);
        graph.addEdge(node1, node3);
        graph.addEdge(node2, node4);
        graph.addEdge(node2, node5);
        graph.addEdge(node3, node5);
        graph.addEdge(node3, node7);
        graph.addEdge(node4, node6);
        graph.addEdge(node6, node7);
        
        graph.show();
        graph.bfs(node1);
        graph.resetVisited();
        graph.dfs(node1);
        graph.resetVisited();

    }
}
