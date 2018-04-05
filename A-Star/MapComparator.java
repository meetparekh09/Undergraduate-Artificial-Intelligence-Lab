/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package astar;

import java.util.Comparator;

/**
 *
 * @author 131080017
 */
public class MapComparator implements Comparator<NodeTuple>{

    @Override
    public int compare(NodeTuple o1, NodeTuple o2) {
        return o1.functionValue - o2.functionValue;
    }


    
}
