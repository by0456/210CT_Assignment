import java.util.ArrayList;
import java.util.List;
public class GraphNode {
    String name;
        List<GraphNode> neighbours;
        boolean visited;

        GraphNode(String name) {
            this.name = name;
            this.neighbours = new ArrayList<>();
            this.visited = false;

        }
        
        public void addneighbours(GraphNode neighbourNode) {
            this.neighbours.add(neighbourNode);
        }

        public List<GraphNode> getNeighbours() {
            return neighbours;
        }

}
