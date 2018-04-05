/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package astar;

/**
 *
 * @author 131080017
 */
public class NodeTuple {
    int node;
    int functionValue;

    public NodeTuple(int node, int functionValue) {
        this.node = node;
        this.functionValue = functionValue;
    }

    public int getNode() {
        return node;
    }

    public int getFunctionValue() {
        return functionValue;
    }

    public void setNode(int node) {
        this.node = node;
    }

    public void setFunctionValue(int functionValue) {
        this.functionValue = functionValue;
    }

    @Override
    public String toString() {
        return "NodeTuple{" + "node=" + node + ", functionValue=" + functionValue + '}';
    }
    
    
}
