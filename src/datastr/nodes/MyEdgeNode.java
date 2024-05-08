package datastr.nodes;

public class MyEdgeNode {
    private int indexOfNeighbour;
    private float weight; // var izveidot citus parametrus
    private MyEdgeNode next = null;
    private MyEdgeNode previous = null;

    public int getIndexOfNeighbour() {
        return indexOfNeighbour;
    }

    public void setIndexOfNeighbour(int indexOfNeighbour) {
        if (indexOfNeighbour > 0) {
            this.indexOfNeighbour = indexOfNeighbour;
        }else {
            this.indexOfNeighbour = -1;
        }
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        if (weight > 0.0f && weight < 41000) {
            this.weight = weight;
        }
        else {
            this.weight = 0.0f;
        }

    }

    public MyEdgeNode getNext() {
        return next;
    }

    public void setNext(MyEdgeNode next) {
        this.next = next;
    }

    public MyEdgeNode getPrevious() {
        return previous;
    }

    public void setPrevious(MyEdgeNode previous) {
        this.previous = previous;
    }


    public MyEdgeNode(int indexOfNeighbour, float weight) {
        setIndexOfNeighbour(indexOfNeighbour);
        setWeight(weight);
    }

    @Override
    public String toString() {
        return weight + "km";
    }
}
