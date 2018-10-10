/**
 * Copyright © 2017, Beijing XitianQujing Technology Co., Ltd.
 * @Title: BinarySearchTree.java
 * @Package com.life.data.structure.tree
 * @Description: 二分搜索树
 * @Author: ViaX-yanglin
 * @Date: 2018年9月27日 上午11:10:40
 * @Version V1.0
 * @Copyright: 2018 All Rights Reserved.北京西天取经科技有限公司
 */
package com.life.data.structure.tree;

import com.life.data.structure.queue.LinkListQueue;

/**
 * @Title: BinarySearchTree
 * @Description: 二分搜索树
 * @Author: ViaX-yanglin
 * @Date: 2018年9月27日 上午11:10:40
 * 
 * @Copyright: 2018 All Rights Reserved.北京西天取经科技有限公司
 */
public class BinarySearchTree<E extends Comparable<E>> {
	
	//根节点
	private Node<E> root;
	
	//节点数
	private int size;
	
	public Integer getSize() {
		return size;
	}
	
	public Boolean isEmpty() {
		return size==0;
	}
	
	//添加节点
	public BinarySearchTree<E> add(E e){
		root=add(e, root);
		size=0;
		return this;
	}
	
	private Node<E> add(E e,Node<E> node) {
		if (node==null) {
			size++;
			return new Node<E>(e);
		}
		if (e.compareTo(node.e)>0) {
			node.right=add(e, node.right);
		}else if (e.compareTo(node.e)<0) {
			node.left=add(e, node.left);
		}
		return node;
	}
	
	//tree 中序遍历
	public BinarySearchTree<E> displayMidOrder() {
		System.out.println("———————————中序遍历—————————————");
		displayMidOrder(root,0);
		return this;
	}
	
	private void displayMidOrder(Node<E> node,Integer depth) {
		if (node==null) {
			System.out.println(generateDepthString(depth)+node);
			return;
		}else {
			displayMidOrder(node.left,depth+1);
			System.out.println(generateDepthString(depth)+node.e);
			displayMidOrder(node.right,depth+1);
		}
	}
	
	//tree 前序遍历
	public BinarySearchTree<E> displayPreOrder() {
		System.out.println("———————————前序遍历—————————————");
		displayPreOrder(root, 0);
		return this;
	}
	
	private void displayPreOrder(Node<E> node,Integer depth) {
		if (node==null) {
			System.out.println(generateDepthString(depth)+node);
			return;
		}
		System.out.println(generateDepthString(depth)+node.e);
		displayPreOrder(node.left, depth+1);
		displayPreOrder(node.right, depth+1);
	}
	
	//后序遍历
	public BinarySearchTree<E> displayPostOrder(){
		System.out.println("———————————后序遍历—————————————");
		displayPostOrder(root, 0);
		return this;
	}
	
	private void displayPostOrder(Node<E> node,int depth) {
		if (node==null) {
			System.out.println(generateDepthString(depth)+node);
			return;
		}
		displayPostOrder(node.left, depth+1);
		displayPostOrder(node.right, depth+1);
		System.out.println(generateDepthString(depth)+node.e);
	}
	
	//层序搜索，借助栈，每次操作一个元素的时候将其右节点和左节点入栈
	public BinarySearchTree<E> displayLayerOrder(){
		System.out.println("———————————层序遍历—————————————");
		if (root==null) {
			return this;
		}
		LinkListQueue<Node<E>> queue=new LinkListQueue<>();
		queue.enQueue(root);
		while (!queue.isEmpty()) {
			Node<E> currentNode=queue.deQueue();
			System.out.println(currentNode.e);
			if (currentNode.left!=null) {
				queue.enQueue(currentNode.left);
			}
			if (currentNode.right!=null) {
				queue.enQueue(currentNode.right);
			}
		}
		return this;
	}
	
	//判断是否包含指定的节点
	public boolean contains(E e) {
		return contains(e,root);
	}
	
	//判读以node为根节点的tree下是否包含e
	private boolean contains(E e,Node<E> node) {
		if (node.e.equals(e)) {
			return true;
		}
		if (e.compareTo(node.e)<0&&node.left!=null) {
			return contains(e,node.left);
		}else if (e.compareTo(node.e)>0 && node.right!=null) {
			return contains(e, node.right);
		}
		return false;
	}
	
	//查找最小值
	public E findMin() {
		if (size==0) {
			throw new IllegalArgumentException("findMin fialer,the tree is mepty");
		}
		return findMin(root).e;
	}
	
	//查找以node为根节点的tree下的最小节点
	private Node<E> findMin(Node<E> node) {
		if (node.left==null) {
			return node;
		}
		return findMin(node.left);
	}
	
	//查找最大值
	public E findMax() {
		if (size==0) {
			throw new IllegalArgumentException("findMax fialer,the tree is mepty");
		}
		return findMax(root).e;
	}
	
	//查找以node为根节点的tree下的最大值
	private Node<E> findMax(Node<E> node){
		if (node.right==null) {
			return node;
		}
		return findMax(node.right);
	}
	
	//删除最小节点
	public BinarySearchTree<E> removeMin(){
		if (size==0) {
			throw new IllegalArgumentException("removeMin failer , the tree is empty");
		}
		root=removeMin(root);
		return this;
	}
	
	//删除已node为根节点的tree的最小节点
	private Node<E> removeMin(Node<E> node){
		if (node.left==null) {
			size--;
			return node.right;
		}
		node.left=removeMin(node.left);
		return node;
	}
	
	//删除最大节点
	public BinarySearchTree<E> removeMax(){
		if (size==0) {
			throw new IllegalArgumentException("removeMax failer , the tree is empty");
		}
		root=removeMax(root);
		return this;
	}
	
	//删除以node为根节点的最大节点
	private Node<E> removeMax(Node<E> node){
		if (node.right==null) {
			size--;
			return node.left;
		}
		node.right=removeMax(node.right);
		return node;
	}
	
	//删除指定的节点
	public BinarySearchTree<E> remove(E e){
		remove(e, root);
		return this;
	}
	
	private Node<E> remove(E e,Node<E> node){
		if (node==null) {
			return null;
		}
		
		if (e.compareTo(node.e)<0) {
			node.left=remove(e, node.left);
		}else if (e.compareTo(node.e)>0) {
			node.right=remove(e, node.right);
		}else {
			//如果待删除的节点没有右节点，直接将左节点作为当前结点
			if (node.right==null) {
				size--;
				return node.left;
			}
			
			//如果待删除节点没有左节点，直接将右节点作为当前结点
			if (node.left==null) {
				size--;
				return node.right;
			}
			
			//如果待删除节点既有左节点又有右节点，可以找到以右节点为根的tree的最小值作为当前结点，也可以找到以左节点为根节点的tree的最大节点作为当前结点
			Node<E> successor=findMin(node.right);
			successor.right=removeMin(node.right);
			successor.left=node.left;
			return successor;
			
		}
		
		
		return node;
	}
	
	//树形深度字符串
	private String generateDepthString(int depth) {
		StringBuffer buffer=new StringBuffer();
		for(int i=0;i<depth;i++) {
			buffer.append("--");
		}
		return buffer.toString();
	}
	
	//树形节点
	@SuppressWarnings("hiding")
	private class Node<E>{
		public E e;
		public Node left;
		public Node right;
		public Node(E e) {
			super();
			this.e = e;
		}
		@Override
		public String toString() {
			return "Node [e=" + e + "]";
		}
	}
}
