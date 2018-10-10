/**
 * Copyright © 2017, Beijing XitianQujing Technology Co., Ltd.
 * @Title: BinarySearchTreeMap.java
 * @Package com.life.data.structure.map
 * @Description: 以二分搜索树为底层存储的map
 * @Author: ViaX-yanglin
 * @Date: 2018年9月28日 下午6:36:34
 * @Version V1.0
 * @Copyright: 2018 All Rights Reserved.北京西天取经科技有限公司
 */
package com.life.data.structure.map;

import com.life.data.structure.queue.LinkListQueue;
import com.life.data.structure.queue.Queue;

/**
 * @Title: BinarySearchTreeMap
 * @Description: 以二分搜索树为底层存储的map
 * @Author: ViaX-yanglin
 * @Date: 2018年9月28日 下午6:36:34
 * 
 * @Copyright: 2018 All Rights Reserved.北京西天取经科技有限公司
 */
public class BinarySearchTreeMap<K extends Comparable<K>,V> implements Map<K, V> {
	
	private BinarySearchTree<K,V> tree=new BinarySearchTree<>();
	
	@Override
	public int getSize() {
		return tree.getSize();
	}

	@Override
	public boolean isEmpty() {
		return tree.isEmpty();
	}

	@Override
	public Map<K, V> put(K key, V value) {
		tree.add(key, value);
		return this;
	}

	@Override
	public V remove(K key) {
		return tree.remove(key);
	}

	@Override
	public V get(K key) {
		return tree.get(key);
	}
	
	@Override
	public String toString() {
		return "BinarySearchTreeMap [size=" + getSize() + "]";
	}

	@Override
	public Map<K, V> display() {
		System.out.println(this.toString());
		tree.displayLayerOrder();
		return this;
	}

	@Override
	public boolean contains(K key) {
		return tree.contains(key);
	}
	
	private class BinarySearchTree<K extends Comparable<K>,V>{
		
		
		private Node<K, V> root;
		
		private int size;
		
		public int getSize() {
			return size;
		}
		
		public boolean isEmpty() {
			return size==0;
		}
		
		public void add(K key,V value){
			root=add(key, value,root);
		}
		
		private Node<K, V> add(K key,V value,Node<K, V> node) {
			if (node==null) {
				node=new Node<K,V>(key,value);
				size++;
				return node;
			}
			
			if (key.compareTo(node.key)>0) {
				node.right=add(key, value, node.right);
			}else if (key.compareTo(node.key)<0) {
				node.left=add(key, value, node.left);
			}else {
				//如果存在key,将赋值新值
				node.value=value;
			}
			return node;
		}
		
		public boolean contains(K key) {
			//如果根节点为空，直接返回false
			if (root==null) {
				return false;
			}
			return contains(key,root);
		}
		
		//判断以node为根节点的tree是否包含key
		private boolean contains(K key,Node<K,V> node) {
			if (key.compareTo(node.key)==0) {
				return true;
			}else if (key.compareTo(node.key)>0&&node.right!=null) {
				return contains(key,node.right);
			}else if (key.compareTo(node.key)<0 && node.left!=null) {
				return contains(key, node.left);
			}
			return false;
		}
		
		public V get(K key) {
			Node<K, V> node=get(key, root);
			return node!=null?node.value:null;
		}
		
		private Node<K,V> get(K key,Node<K,V> node) {
			if (node==null) {
				return node;
			}
			if (key.compareTo(node.key)==0) {
				return node;
			}else if (key.compareTo(node.key)>0) {
				return get(key, node.right);
			}else {
				return get(key, node.left);
			}
		}
		
		public V remove(K key) {
			//查询要删除的元素
			Node<K,V> removeNode=get(key, root);
			//删除指定的元素
			root=remove(key, root);
			//将删删除的元素进行返回
			return removeNode!=null?removeNode.value:null;
		}
		
		public Node<K, V> remove(K key,Node<K,V> node){
			if (node==null) {
				return node;
			}
			
			if (key.compareTo(node.key)==0) {
				if (node.left==null) {
					size--;
					return node.right;
				}else if (node.right==null) {
					size--;
					return node.left;
				}else {
					//既有左节点又有右节点,查找右节点下的最小节点
					Node<K, V> minNode=findMin(node.right);
					return minNode;
				}
				
			}else if (key.compareTo(node.key)>0) {
				node.right=remove(key, node.right);
				return node;
			}else {
				node.left=remove(key, node.left);
				return node;
			}
		}
		
		//查找以node为根节点的tree下的最小的节点
		private Node<K, V> findMin(Node<K,V> node){
			if (node.left==null) {
				return node;
			}
			return findMin(node.left);
		}
		
		//按层序输出
		public void displayLayerOrder() {
			if (root!=null) {
				Queue<Node<K, V>> queue=new LinkListQueue<>();
				queue.enQueue(root);
				while (!queue.isEmpty()) {
					Node<K, V> node=queue.deQueue();
					System.out.println("{"+node.key+":"+node.value+"}");
					if (node.left!=null) {
						queue.enQueue(node.left);
					}
					if (node.right!=null) {
						queue.enQueue(node.right);
					}
				}
			}
		}
		
		//二分搜索树节点
		private class Node<K extends Comparable<K>,V>{
			public K key;
			public V value;
			public Node<K, V> left;
			public Node<K, V> right;
			public Node(K key, V value) {
				this.key = key;
				this.value = value;
			}
		}
	}
}
