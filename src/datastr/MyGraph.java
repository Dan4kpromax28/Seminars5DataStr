package datastr;

import datastr.nodes.MyEdgeNode;
import datastr.nodes.MyVerticeNode;

public class MyGraph<Ttype> {
    private MyVerticeNode[] vertices;
    private final int GRAPH_DEFAULT_SIZE = 10;
    private int size = GRAPH_DEFAULT_SIZE;
    private int counter = 0;

    public MyGraph() {
        vertices = new MyVerticeNode[size];
    }

    public MyGraph(int inputSize) {
        if (inputSize > 0) {
            size = inputSize;
        }
        vertices = new MyVerticeNode[size];
    }

    public boolean isEmpty() {
        return (counter == 0);
    }

    public boolean isFull() {
        return (counter == size);
    }

    public int howManyElements() {
        return counter;
    }

    private void resize() {
        int newSize = (counter <= 100) ? size * 2 : (int) (size * 1.5);
        MyVerticeNode[] verticesNew = new MyVerticeNode[newSize];
        for (int i = 0; i < size; i++) {
            vertices[i] = verticesNew[i];
        }

        vertices = verticesNew;
        System.gc();
        size = newSize;
    }


    // TODO pievienot jauno virsotni grafam

    public void addVertices(Ttype element) throws Exception {
        if (element == null) throw new Exception("There is a problem ");
        if (isFull()) resize();

        // parbaude ka sada virsotne neeksiste
        if (searchVertices(element) != -1) {
            throw new Exception("This vertice is already in the graph");
        } else {
            MyVerticeNode newNode = new MyVerticeNode<Ttype>(element);
            vertices[counter++] = newNode;
        }
    }

    private int searchVertices(Ttype element) {
        for (int i = 0; i < counter; i++) {
            if (vertices[i].getElement() == element) {
                return i;
            }
        }
        return -1;
    }

    public void addEdge(Ttype verticeFrom, Ttype verticeTo, float weight) throws Exception {
        if (verticeFrom == null || verticeTo == null || weight <= 0 || weight >= 41000)
            throw new Exception("There is a problem ");
        if (verticeFrom.equals(verticeTo))
            throw new Exception("It is not possible to create an edge to  the same vertice ");

        int indexFrom = searchVertices(verticeFrom);
        int indexTo = searchVertices(verticeTo);

        if (indexFrom == -1 || indexTo == -1) {
            throw new Exception("There is no such vertice in the graph");
        }

        MyEdgeNode newEdgeNode = new MyEdgeNode(indexTo, weight);
        //sis bus pirmais cela bloks sai virsotnei
        if (vertices[indexFrom].getFirstEdgeNode() == null) {
            vertices[indexFrom].setFirstEdgeNode(newEdgeNode);
        } else {
            MyEdgeNode firstEdgeNode = vertices[indexFrom].getFirstEdgeNode();
            newEdgeNode.setNext(firstEdgeNode);
            firstEdgeNode.setPrevious(newEdgeNode);
            firstEdgeNode = newEdgeNode;

            //TODO darbibas ar previous
        }

    }

    public void print() throws Exception {
        if (isEmpty()) throw new Exception("Graph is empty");
        for (int i = 0; i < counter; i++) {
            System.out.println(vertices[i].getElement());
            MyEdgeNode temp = vertices[i].getFirstEdgeNode();
            while (temp!= null) {
                System.out.println(vertices[temp.getIndexOfNeighbour()].getElement() + " " + temp.getWeight() + "km; ");
                temp = temp.getNext();
            }
            System.out.println();
        }
    }


}
