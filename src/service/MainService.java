package service;

import datastr.MyGraph;

public class MainService {
    public static void main(String[] args) {
        MyGraph<String> map = new MyGraph<String>();
        try {
            map.addVertices("Ventspils");
            map.addVertices("Riga");
            map.addVertices("Daugavpils");
            map.addVertices("Liepaja");
            map.addVertices("Jelgava");

            map.addEdge("Ventspils", "Riga", 189);
           // map.addEdge("Ventspils", "Kuldiga", 56.49f);
            map.addEdge("Ventspils", "Daugavpils", 300);
            map.addEdge("Riga", "Daugavpils", 100);

            map.print();

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}
