package practice;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

enum Color {
    RED, GREEN
}

abstract class Tree {

    private int value;
    private Color color;
    private int depth;

    public Tree(int value, Color color, int depth) {
        this.value = value;
        this.color = color;
        this.depth = depth;
    }

    public int getValue() {
        return value;
    }

    public Color getColor() {
        return color;
    }

    public int getDepth() {
        return depth;
    }

    public abstract void accept(TreeVis visitor);
}

class TreeNode extends Tree {

    private ArrayList<Tree> children = new ArrayList<>();

    public TreeNode(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitNode(this);

        for (Tree child : children) {
            child.accept(visitor);
        }
    }

    public void addChild(Tree child) {
        children.add(child);
    }
}

class TreeLeaf extends Tree {

    public TreeLeaf(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitLeaf(this);
    }
}

abstract class TreeVis
{
    public abstract int getResult();
    public abstract void visitNode(TreeNode node);
    public abstract void visitLeaf(TreeLeaf leaf);

}

class SumInLeavesVisitor extends TreeVis {
	int leavesSum = 0;
	
	@Override
    public int getResult() {
        return leavesSum;
    }

	@Override
    public void visitNode(TreeNode node) {
    }

	@Override
    public void visitLeaf(TreeLeaf leaf) {
    	leavesSum+=leaf.getValue();
    }
}

class ProductOfRedNodesVisitor extends TreeVis {
	private long redNodesProduct=1;
	private final int M = 1000000009;
	
	@Override
    public int getResult() {
        return (int) redNodesProduct;
    }

    @Override
    public void visitNode(TreeNode node) {
    	if(node.getColor() == Color.RED)
    	{
    		redNodesProduct=(redNodesProduct*node.getValue()) % M;
    	}
    }

    @Override
    public void visitLeaf(TreeLeaf leaf) {
    	if(leaf.getColor() == Color.RED)
    	{
    		redNodesProduct=(redNodesProduct*leaf.getValue()) % M;
    	}
    }
}

class FancyVisitor extends TreeVis {
	private int noLeafEvenDepthSum=0;
	private int greenLeavesSum=0;
	
	@Override
    public int getResult() {
        return Math.abs(noLeafEvenDepthSum - greenLeavesSum);
    }

	@Override
    public void visitNode(TreeNode node) {
    	if(node.getDepth()%2 == 0)
    	{
    		noLeafEvenDepthSum+=node.getValue();
    	}
    }

	@Override
    public void visitLeaf(TreeLeaf leaf) {
    	if(leaf.getColor() == Color.GREEN)
    	{
    		greenLeavesSum+=leaf.getValue();
    	}
    }
}

class nodesInfoClass
{
    Tree treeNode;
    int nodeColor;
    
}

public class TreeVisitorPattern
{
	private static int[] values;
	private static Color[] colors;
	private static Map<Integer, HashSet<Integer>> edges;
	
    public static Tree solve() {
       Scanner scan = new Scanner(System.in);
       int noNodes = scan.nextInt();
       values = new int[noNodes];
       for(int i=0; i<noNodes; i++)
       {
    	   values[i]=scan.nextInt();
       }
       
       colors = new Color[noNodes];
       for(int i=0; i<noNodes; i++)
       {
    	   colors[i]=scan.nextInt()==0?Color.RED:Color.GREEN;
       }
       
       edges = new HashMap<>(); 
       
       for(int i=0; i<noNodes-1; i++)
       {
    	   int u = scan.nextInt();
    	   int v = scan.nextInt();
    	   
    	   HashSet<Integer> uNeighbours = edges.get(u);
    	   if(uNeighbours == null)
    	   {
    		   uNeighbours = new HashSet<Integer>();
    		   edges.put(u, uNeighbours);
    	   }
    	   uNeighbours.add(v);
    	   
    	   HashSet<Integer> vNeighbours = edges.get(v);
    	   if(vNeighbours == null)
    	   {
    		   vNeighbours = new HashSet<Integer>();
    		   edges.put(v, vNeighbours);
    	   }
    	   vNeighbours.add(u);
       }
       scan.close();
       
       if(noNodes == 1)
       {
    	   return new TreeLeaf(values[0], colors[0], 0);
       }
       
       TreeNode root = new TreeNode(values[0], colors[0], 0);
       addChildren(root, 1);
       return root;
    }
    
    public static void addChildren(TreeNode parent, Integer nodeNo)
    {
        for(Integer connectTo : edges.get(nodeNo))
        {
        	HashSet<Integer> set = edges.get(connectTo);
			if(set.contains(nodeNo))
			{
				HashSet<Integer> newSet = new HashSet<>();
				newSet.addAll(set);
				newSet.remove(nodeNo);

				edges.put(connectTo, newSet);
			}
            //edges.get(connectTo).remove(nodeNo);
            HashSet<Integer> grandChildren = edges.get(connectTo);
            Tree child;
            if(grandChildren != null && !grandChildren.isEmpty())
            {
                child = new TreeNode(values[connectTo - 1], colors[connectTo-1], parent.getDepth()+1);
            }
            else
            {
                child = new TreeLeaf(values[connectTo - 1], colors[connectTo-1], parent.getDepth()+1);
            }
            
            parent.addChild(child);
            
            if(child instanceof TreeNode)
            {
                addChildren((TreeNode) child, connectTo);
            }
        }
	}


    public static void main(String[] args) {
      	Tree root = solve();
		SumInLeavesVisitor vis1 = new SumInLeavesVisitor();
      	ProductOfRedNodesVisitor vis2 = new ProductOfRedNodesVisitor();
      	FancyVisitor vis3 = new FancyVisitor();

      	root.accept(vis1);
      	root.accept(vis2);
      	root.accept(vis3);

      	int res1 = vis1.getResult();
      	int res2 = vis2.getResult();
      	int res3 = vis3.getResult();

      	System.out.println(res1);
     	System.out.println(res2);
    	System.out.println(res3);
	}
}