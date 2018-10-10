/**
 * Copyright © 2017, Beijing XitianQujing Technology Co., Ltd.
 * @Title: AVLTree.java
 * @Package com.life.data.structure.tree
 * @Description: avl tree，自平衡二分搜索树
 * @Author: ViaX-yanglin
 * @Date: 2018年10月9日 上午10:29:15
 * @Version V1.0
 * @Copyright: 2018 All Rights Reserved.北京西天取经科技有限公司
 */
package com.life.data.structure.tree;

import com.life.data.structure.arrays.Array;

/**
 * @Title: AVLTree
 * @Description: avl tree，自平衡二分搜索树
 * @Author: ViaX-yanglin
 * @Date: 2018年10月9日 上午10:29:15
 * 
 * @Copyright: 2018 All Rights Reserved.北京西天取经科技有限公司
 */
public class AVLTree<E extends Comparable<E>> {
	
	private Node root;
	
	private Integer size=0;
	
	public int getSize() {
		return size;
	}
	
	//添加元素
	public AVLTree<E> add(E e){
		root=add(e, root);
		return this;
	}
	
	//在以node为根节点的tree下添加node
	private Node add(E e,Node node) {
		if (node==null) {
			node=new Node(e);
			size++;
			return node;
		}
		
		//右边的节点下添加
		if (e.compareTo(node.data)>0) {
			node.right= add(e, node.right);
		}else if (e.compareTo(node.data)<0) {
			//左边的节点下添加
			node.left= add(e, node.left);
		}else {
			//已经存在该节点
			//return node;
		}
		
		return reBalance(node);
	}
	
	//将指定的节点向右旋转(将指定的节点的左子节点作为当前节点，将指定节点作为当前结点的右子节点)
	//  	  y                              x
	//       / \                           /   \
	//      x   T4     向右旋转 (y)        	  z     y
	//     / \       - - - - - - - ->    / \   / \
	//    z   T3                       T1  T2 T3 T4
	//   / \
	// T1   T2
	private Node rightRotate(Node node) {
		Node x=node.left;
		Node T3=x.right;
		x.right=node;
		node.left=T3;
		
		//更新height
		node.height=Math.max(getHeight(node.left), getHeight(node.right))+1;
		x.height=Math.max(getHeight(x.left), getHeight(x.right))+1;
		return x;
	}
	
	//将指定的节点向左旋转（将指定节点的右子节点作为当前节点，将指定节点作为当前节点的左节点）
	//    y                             x
	//  /  \                          /   \
	// T1   x      向左旋转 (y)       	 y     z
	//     / \   - - - - - - - ->   / \   / \
	//   T2  z                     T1 T2 T3 T4
	//      / \
	//     T3 T4
	private Node leftRotate(Node node) {
		Node x=node.right;
		Node T2=x.left;
		x.left=node;
		node.right=T2;
		
		//更新height
		node.height=1+Math.max(getHeight(node.left), getHeight(node.right));
		x.height=1+Math.max(getHeight(x.left),getHeight(x.right));
		return x;
	}
	
	//获取节点的高度
	private int getHeight(Node node) {
		if (node==null) {
			return 0;
		}
		return node.height;
	}
	
	//获取节点的平衡因子(左子树的高度-右子树的高度)
	private int getBalanceFactor(Node node) {
		if (node==null) {
			return 0;
		}else {
			return getHeight(node.left)-getHeight(node.right);
		}
	}
	
	//判断该树是否包含指定的元素
	public boolean contains(E e) {
		return contains(e, root);
	}
	
	//判断以node为根节点的树是否包含指定的元素
	private boolean contains(E e,Node node) {
		if (node==null) {
			return false;
		}
		if (e.compareTo(node.data)==0) {
			return true;
		}else if (e.compareTo(node.data)>0) {
			return contains(e, node.right);
		}else {
			return contains(e, node.left);
		}
	}
	
	public boolean isEmpty() {
		return size==0;
	}
	
	//查找该tree下的最小节点
	public Node findMin() {
		if (isEmpty()) {
			throw new IllegalArgumentException("the avl tree is empty");
		}
		return findMin(root);
	}
	
	//查找以node为根节点的树的最小节点
	private Node findMin(Node node) {
		if (node.left==null) {
			return node;
		}
		return findMin(node.left);
	}
	
	//查找该avl tree下的最大节点
	public Node findMax() {
		if (isEmpty()) {
			throw new IllegalArgumentException("the avl tree is empty");
		}
		return findMax(root);
	}
	
	//查找以node为根的tree的最大节点
	private Node findMax(Node node) {
		if (node.right==null) {
			return node;
		}else {
			return findMax(node.right);
		}
	}
	
	//删除最小节点
	public AVLTree<E> removeMin(){
		if (isEmpty()) {
			throw new IllegalArgumentException("the avl tree is empty");
		}
		root=removeMin(root);
		return this;
	}
	
	//删除以node为根的最小节点
	private Node removeMin(Node node){
		if (node.left==null) {
			size--;
			return node.right;
		}
		node.left=removeMin(node.left);
		return reBalance(node);
	}
	
	//删除最大的节点
	public AVLTree<E> removeMax(){
		if (isEmpty()) {
			throw new IllegalArgumentException("the avl tree is empty");
		}
		root=removeMax(root);
		return this;
	}
	
	//删除以node为根的最大的节点
	private Node removeMax(Node node) {
		if (node.right==null) {
			size--;
			Node leftNode=node.left;
			node.left=null;
			return leftNode;
		}else {
			node.right=removeMax(node.right);
		}
		return reBalance(node);
	}
	
	//删除节点e
	public AVLTree<E> remove(E e){
		root=remove(e, root);
		return this;
	}
	
	//删除以node为根的tree下的节点e
	private Node remove(E e,Node node) {
		//没有找到指定的节点e
		if (node==null) {
			return null;
		}
		Node retNode=null;
		if (e.compareTo(node.data)==0) {
			if (node.right==null) {
				size--;
				return node.left;
			}
			
			if (node.left==null) {
				size--;
				return node.right;
			}
			
			//左右节点都不为空
			//将右册最小的节点替换当前节点
			Node successor=findMin(node.right);
			successor.right=removeMin(node.right);
			//删除最小节点
			successor.left=node.left;
			retNode=successor;
		}else if (e.compareTo(node.data)>0) {
			node.right=remove(e, node.right);
			retNode=node;
			
		}else {
			node.left=remove(e, node.left);
			retNode=node;
		}
		
		return reBalance(retNode);
	}
	
	//重新计算各阶段高度
	private Node reBalance(Node node) {
		//更新height
		node.height=1+Math.max(getHeight(node.left), getHeight(node.right));
		
		//计算平衡因子
		int balanceFactor=getBalanceFactor(node);
		
		//平衡维护
		if (balanceFactor>1&&getBalanceFactor(node.left)>0) {
			//左侧倾斜，向右旋转（LL）
			return rightRotate(node);
		}else if (balanceFactor<-1&&getBalanceFactor(node.right)<=0) {
			//右侧倾斜，向左旋转(RR)
			return leftRotate(node);
		}else if (balanceFactor>1&&getBalanceFactor(node.left)<0) {
			//左侧倾斜，左子树右侧倾斜（LR）
			//		   y					y					z
			//		  /	  				   /				   / \	
			//		 x      首先将x向左旋转        z     将y向右旋转	  x   y	
			//		  \					 /					 	
			//	       z				x					
			node.left=leftRotate(node.left);
			return rightRotate(node);
		}else if (balanceFactor<-1&&getBalanceFactor(node.right)>0) {
			//右侧倾斜，右子树左侧倾斜（RL）
			//		   y					y					z
			//		  	\	  				 \				   / \	
			//		 	x      首先将x向右旋转         z     将y向左旋转      y   x	
			//		   /					   \					 	
			//	      z				            x
			node.right=rightRotate(node.right);
			return leftRotate(node);
		}
		return node;
	}
	
	//判断是不是一个二分搜索树
	public boolean isBinarySearchTree() {
		Array<E> array=new Array<>();
		displayMid(root, 0, array);
		for(int i=0;i<array.getSize()-1;i++) {
			if (array.find(i).compareTo(array.find(i+1))>0) {
				return false;
			}
		}
		return true;
	}
	
	//判断该tree是否平衡
	public boolean isBalance() {
		return isBalance(root);
	}
	
	//判断以node为根节点的树是否平衡
	public boolean isBalance(Node node) {
		if (node==null) {
			return true;
		}
		
		int balanceFactor=getBalanceFactor(node);
		
		//如果一个节点的平衡因子大于1,则不平衡
		if (Math.abs(balanceFactor)>1) {
			return false;
		}
		return isBalance(node.left)&&isBalance(node.right);
	}
	
	
	//中序打印
	public AVLTree<E> displayMid() {
		System.out.println(toString());
		Array<E> array=new Array<>();
		displayMid(root, 0,array);
		System.out.println(array);
		return this;
	}
	
	private void displayMid(Node node,int level,Array<E> array) {
		if (node==null) {
			//System.out.println(generateLevelStr(level)+node);
			return;
		}
		displayMid(node.left, level+1,array);
		//System.out.println(generateLevelStr(level)+node.data);
		array.addLast(node.data);
		displayMid(node.right, level+1,array);
	}
	
	private String generateLevelStr(int level) {
		StringBuffer buffer=new StringBuffer();
		for(int i=0;i<level;i++) {
			buffer.append("----");
		}
		return buffer.toString();
	}
	
	@Override
	public String toString() {
		return "AVLTree [size=" + size + "],isBinarySearchTree:"+isBinarySearchTree()+",isBalace:"+isBalance();
	}

	//avl tree的节点信息
	private class Node{
		public E data;
		public Node left;
		public Node right;
		
		//该节点的高度
		public int height=1;
		public Node(E data) {
			this.data = data;
		}
	}
}
