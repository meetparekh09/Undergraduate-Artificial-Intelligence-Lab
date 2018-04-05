/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package astar;

import java.util.*;

/**
 *
 * @author 131080017
 */
public class AStar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PriorityQueue pe = new PriorityQueue(50, new MapComparator() );
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of nodes :: ");
        int node = sc.nextInt();
        int [][]graph = new int[node][node];
        int heuristic[] = new int[node];
        boolean visited[] = new boolean[node];
        boolean open[] = new boolean[node];
        NodeTuple allNodes[] = new NodeTuple[node];
        
        
        for (int i = 0; i < node; i++) {
            allNodes[i] = new NodeTuple(i, -1);
            for (int j = 0; j < node; j++)
                graph[i][j] = -1;
        }
        
        System.out.println("Enter the number of edges :: ");
        int edges = sc.nextInt();
        
        for (int i = 0; i < edges; i++) {
            System.out.println("Enter Node1 Node2 and Distance :: ");
            int node1 = sc.nextInt();
            int node2 = sc.nextInt();
            int dist = sc.nextInt();
            graph[node1][node2] = graph[node2][node1] = dist;
        }
        
        System.out.println("Enter goal :: ");
        int goal = sc.nextInt();
        
        for(int i = 0; i < node; i++) {
            if(i == goal) {
                heuristic[i] = 0;
                continue;
            }
            System.out.println("Enter heuristic distance for "+ i+" :: ");
            heuristic[i] = sc.nextInt();
        }
        
        open[0] = true;
        int actualValue, fn;
        NodeTuple currentTuple = null;
        allNodes[0].setFunctionValue(heuristic[0]);
        pe.add(allNodes[0]);
        while(!pe.isEmpty()) {
            currentTuple = (NodeTuple) pe.poll();
            if(currentTuple.node == goal) break;
            int currentNode = currentTuple.node;
            visited[currentNode] = true;
            for(int i = 0; i < node; i++) {
                if(graph[currentNode][i] != -1 && !visited[i]) {
                    actualValue = currentTuple.functionValue - heuristic[currentNode] + graph[currentNode][i];
                    fn = actualValue + heuristic[i];
                    if(open[i] && fn < allNodes[i].functionValue) {
                        if(pe.remove(allNodes[i]));
                        else System.out.println("Super Error!!!!!!!!!!");
                        allNodes[i].functionValue = fn;
                        pe.add(allNodes[i]);
                    } else {
                        open[i] = true;
                        allNodes[i].functionValue = fn;
                        pe.add(allNodes[i]);
                    }
                }
            }
        }
        if(currentTuple != null) System.out.println(currentTuple.functionValue);
    }
    
}
