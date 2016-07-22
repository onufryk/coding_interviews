package com.onufryk.exercise;

import com.onufryk.exercise.struct.ParentalBinaryTree;
import com.onufryk.exercise.struct.TreeNode;

public class Question018 {

	public static void main(String[] args) {
		TreeNode<Character> nodeA = new TreeNode<Character>('A');
		TreeNode<Character> nodeB = new TreeNode<Character>('B');
		TreeNode<Character> nodeC = new TreeNode<Character>('C');
		TreeNode<Character> nodeD = new TreeNode<Character>('D');
		TreeNode<Character> nodeE = new TreeNode<Character>('E');
		TreeNode<Character> nodeF = new TreeNode<Character>('F');
		TreeNode<Character> nodeG = new TreeNode<Character>('G');
		TreeNode<Character> nodeH = new TreeNode<Character>('H');
		TreeNode<Character> nodeI = new TreeNode<Character>('I');
		
		nodeI.parent = nodeE;
		nodeE.right = nodeI;
		
		nodeH.parent = nodeE;
		nodeE.left = nodeH;
		
		nodeE.parent = nodeB;
		nodeB.right = nodeE;
		
		nodeD.parent = nodeB;
		nodeB.left = nodeD;
		
		nodeB.parent = nodeA;
		nodeA.left = nodeB;
		
		nodeF.parent = nodeC;
		nodeC.left = nodeF;
		
		nodeG.parent = nodeC;
		nodeC.right = nodeG;
		
		nodeC.parent = nodeA;
		nodeA.right = nodeC;
		
		
		ParentalBinaryTree<Character> tree = new ParentalBinaryTree<Character>(nodeA);
		//d, b, h, e, i, a, f, c, g.
		tree.traversePreOrder();
		tree.traversePostOrder();
		tree.traverseInOrder();
		
		System.out.println(nodeA.value + " - " + tree.nextNode(nodeA));
		System.out.println(nodeB.value + " - " + tree.nextNode(nodeB));
		System.out.println(nodeC.value + " - " + tree.nextNode(nodeC));
		System.out.println(nodeD.value + " - " + tree.nextNode(nodeD));
		System.out.println(nodeE.value + " - " + tree.nextNode(nodeE));
		System.out.println(nodeF.value + " - " + tree.nextNode(nodeF));
		System.out.println(nodeG.value + " - " + tree.nextNode(nodeG));
		System.out.println(nodeH.value + " - " + tree.nextNode(nodeH));
		System.out.println(nodeI.value + " - " + tree.nextNode(nodeI));
	}

}
