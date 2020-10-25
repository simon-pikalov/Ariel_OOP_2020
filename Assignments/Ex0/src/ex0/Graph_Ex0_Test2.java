package ex0;
/**
 * This is a simple test class to test Ex0 functionality & performance.
 * Note: This is not a JUnit test - and should surely be, to be fixed in Ex1.
 *
 * output example (4 years ols slow computer):
 *
 * Running tests for Ex0 - this may take up to 10 seconds!
 *
 * 0) test0   pass: true
 * 1) test1   pass: true
 * 2) test2()   pass: true
 * 3) test2()   pass: true
 * 4) test2(a)   pass: true
 * 5) test9(a)   pass: true
 * 6) test9(b)   pass: true
 * 7) test_n(a)   pass: true
 * 8) test_n(b)   pass: true
 * 9) test_n(a)   pass: true
 * 10) test_n(b)   pass: true
 * 11) test_n(a)   pass: true
 * 12) test_n(b)   pass: true
 * 13) test_n(a)   pass: true
 * 14) test_n(b)   pass: true
 * 15) test_connectivity0   pass: true
 * 16) test_connectivity1   pass: true
 * 17) test_connectivity2   pass: true
 * 18) test_path   pass: true
 * 19) runtime test:   pass: true
 * number of Errors: 0 of 20 tests, time: 3.914 seconds
 * grade: 100
 *
 * Process finished with exit code 0
 *
 *
 */

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class Graph_Ex0_Test2 {
    private static Random _rnd = null;
    private static int _errors = 0, _tests = 0;
    private static String _log = "";

    /**
     * Simple main, run all the tests.
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("Running tests for Ex0 - this may take up to 10 seconds!");
        long start = new Date().getTime();
        test0();
        test1();
        test2();
        test2a();
        test9();
        test_n(10,9,1,1,1);
        test_n(100,235,1,47,1);
        test_n(1000,3400,2,19,1);
        int no = 1000*50, ed = 302650;
        test_n(no, ed,3,9,1000);
        test_connectivity(100,1);
        test_path(10,1);
        long end = new Date().getTime();
        double dt = (end-start)/1000.0;
        boolean t = dt<10;
        test("runtime test: ",t, true);
        System.out.println(_log);
        double g = 100.0*(_tests-_errors)/_tests;
        System.out.println("number of Errors: "+_errors+" of "+_tests+" tests, time: "+dt+" seconds");
        System.out.println("grade: "+(int)g);
    }

    /**
     * Generate a random graph with v_size nodes and e_size edges
     * @param v_size
     * @param e_size
     * @param seed
     * @return
     */
    public static graph graph_creator(int v_size, int e_size, int seed) {
        graph g = new Graph_DS();
        _rnd = new Random(seed);
        for(int i=0;i<v_size;i++) {
            node_data n = new NodeData();
            g.addNode(n);
        }
        // Iterator<node_data> itr = V.iterator(); // Iterator is a more elegant and generic way, but KIS is more important
        node_data[] nodes = nodes(g);
        while(g.edgeSize() < e_size) {
            int a = nextRnd(0,v_size);
            int b = nextRnd(0,v_size);
            int i = nodes[a].getKey();
            int j = nodes[b].getKey();
            g.connect(i,j);
        }
        return g;
    }

    /**
     * Simple empty test
     */
    public static void test0() {
        graph g0 = graph_creator(0, 0, 1);
      //  System.out.println(g0);
        graph_algorithms ga0 = new Graph_Algo();
        ga0.init(g0);
        boolean b = ga0.isConnected();
        test("test0 ", b, true);
    }

    /**
     * Simple single node graph
     */
    public static void test1() {
        graph g0 = graph_creator(1, 0, 1);
    //    System.out.println(g0);
        graph_algorithms ga0 = new Graph_Algo();
        ga0.init(g0);
        boolean b = ga0.isConnected();
        test("test1 ", b, true);
    }

    /**
     * graph with two nodes and no edges - not connected
     */
    public static void test2() {
        graph g0 = graph_creator(2, 0, 1);
     //   System.out.println(g0);
        graph_algorithms ga0 = new Graph_Algo();
        ga0.init(g0);
        boolean b = ga0.isConnected();
        test("test2() ", b, false);
        test("test2() ", b, false);

    }
    /**
     * graph with two nodes and a single edge - connected
     */
    public static void test2a() {
        graph g0 = graph_creator(2, 1, 1);
        graph_algorithms ga0 = new Graph_Algo();
        ga0.init(g0);
        boolean b = ga0.isConnected();
        test("test2(a) ", b, true);
    }

    /**
     * small graph test (|V|=10, |E|=30), remove edges and a node:
     * so the updates graph will have (|V|=9, |E|=21)
     */
    public static void test9() {
        graph g10 = graph_creator(10,30,1);
        node_data[] nodes = nodes(g10);
        int a0 = nodes[0].getKey();
        int a1 = nodes[1].getKey();
        int a2 = nodes[2].getKey();
        g10.removeEdge(a0,a1);
        g10.removeEdge(a2,a0);
        g10.removeEdge(a2,a1);
        g10.removeNode(a2);
        g10.removeNode(a2);
        int re = 9;
        test("test9(a) ", re, g10.nodeSize());
        re = 21;
        test("test9(b) ", re, g10.edgeSize());
    }

    /**
     * testing graph generation and connectivity
     * @param size - number of nodes
     * @param edge - number of edges
     * @param seed - the random seed
     * @param tt - number of times for removing a group of nodes
     * @param jump - the group of nodes to be removed
     */
    public static void test_n(int size, int edge, int seed, int tt, int jump) {
        graph g = graph_creator(size, edge, seed);
        graph_algorithms ga = new Graph_Algo();
        ga.init(g);
        node_data[] nodes = nodes(g);
        int i=0;
        boolean b = true;
        while(i<tt) {
          b &= ga.isConnected();
          for(int x=0;x<jump;x++) {
              int s = g.nodeSize();
              int r = nextRnd(0, s);
              int key = nodes[r].getKey(); // bug fix
              g.removeNode(key);
          }
        //  System.out.println(""+i+") "+g.nodeSize()+"  con: "+b);
          i++;
        }
       test("test_n(a) ",b, true);
        b = ga.isConnected();
        test("test_n(b) ",b, false);
    }

    /**
     * test connectivity & shortest path of a double-list like graph
     * @param size
     * @param seed
     */
    public static void test_connectivity(int size, int seed) {
        graph g = graph_creator(size,0,seed);
        graph_algorithms ga = new Graph_Algo();
        ga.init(g);
        node_data[] nodes = nodes(g);
        for(int i=2;i<size;i++) {
            node_data n0 = nodes[i-2];
            node_data n1 = nodes[i-1];
            node_data n2 = nodes[i];
            g.connect(n0.getKey(), n1.getKey());
            g.connect(n0.getKey(), n2.getKey());
        }
        int dist = ga.shortestPathDist(nodes[0].getKey(), nodes[size-1].getKey());
        test("test_connectivity0 ",dist, size/2);
        int ind = nodes[size/2].getKey();
        g.removeNode(ind);
        dist = ga.shortestPathDist(nodes[0].getKey(), nodes[size-1].getKey());
        test("test_connectivity1 ",dist, size/2);
        g.removeNode(ind+1);
        dist = ga.shortestPathDist(nodes[0].getKey(), nodes[size-1].getKey());
        test("test_connectivity2 ",dist, -1);
    }

    /**
     * Simple test of shortest path
     * @param size
     * @param seed
     */
    public static void test_path(int size, int seed) {
        graph g = graph_creator(size,0,seed);
        graph_algorithms ga = new Graph_Algo();
        ga.init(g);
        node_data[] nodes = nodes(g);
        for(int i=2;i<size;i++) {
            node_data n0 = nodes[i-2];
            node_data n1 = nodes[i-1];
            node_data n2 = nodes[i];
            g.connect(n0.getKey(), n1.getKey());
            g.connect(n0.getKey(), n2.getKey());
        }
        List<node_data> path = ga.shortestPath(nodes[0].getKey(), nodes[size-1].getKey());
        test("test_path ",path.size(), size/2+1);
    }
    ////////////////////// Private Functions /////////////////////
    private static void test(String test, boolean val, boolean req) {
        test(test, ""+val, ""+req);
    }
    private static void test(String test, int val, int req) {
        test(test, ""+val, ""+req);
    }
    private static void test(String test, String val, String req) {
        boolean ans = true;
        ans = val.equals(req);
        String tt = _tests+") "+test+"  pass: "+ans;
        _log += "\n"+tt;
        if(!ans) {
            _errors++;
            String err = "  ERROR("+_errors+") "+val+"!="+req;
            System.err.println(tt+err);
            _log += err;

        }
        _tests++;
    }
    private static int nextRnd(int min, int max) {
        double v = nextRnd(0.0+min, (double)max);
        int ans = (int)v;
        return ans;
    }
    private static double nextRnd(double min, double max) {
        double d = _rnd.nextDouble();
        double dx = max-min;
        double ans = d*dx+min;
        return ans;
    }
    /**
     * Simple method for returning an array with all the node_data of the graph,
     * Note: this should be using an  Iterator<node_edge> to be fixed in Ex1
     * @param g
     * @return
     */
    private static node_data[] nodes(graph g) {
        int size = g.nodeSize();
        Collection<node_data> V = g.getV();
        node_data[] nodes = new node_data[size];
        V.toArray(nodes); // O(n) operation
        return nodes;
    }
}
