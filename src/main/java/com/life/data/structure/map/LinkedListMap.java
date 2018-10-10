/**
 * Copyright © 2017, Beijing XitianQujing Technology Co., Ltd.
 * @Title: LinkedListMap.java
 * @Package com.life.data.structure.map
 * @Description: 使用链表实现map
 * @Author: ViaX-yanglin
 * @Date: 2018年9月28日 下午4:23:39
 * @Version V1.0
 * @Copyright: 2018 All Rights Reserved.北京西天取经科技有限公司
 */
package com.life.data.structure.map;

/**
 * @Title: LinkedListMap
 * @Description: 使用链表实现map
 * @Author: ViaX-yanglin
 * @Date: 2018年9月28日 下午4:23:39
 * 
 * @Copyright: 2018 All Rights Reserved.北京西天取经科技有限公司
 */
public class LinkedListMap<K,V> implements Map<K, V> {

	//使用链表作为map的底层数据存储
	private LinkedList<K,V> list=new LinkedList<>();
	
	@Override
	public int getSize() {
		return list.getSize();
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	@Override
	public boolean contains(K key) {
		return list.contains(key);
	}

	@Override
	public Map<K, V> put(K key, V value) {
		list.add(key, value);
		return this;
	}

	@Override
	public V remove(K key) {
		return list.remove(key);
	}

	@Override
	public V get(K key) {
		return list.get(key);
	}

	@Override
	public String toString() {
		StringBuffer buffer=new StringBuffer();
		buffer.append("LinkedListMap [size=" + getSize() + "]");
		return buffer.toString();
	}

	@Override
	public Map<K, V> display() {
		System.out.println(this.toString());
		list.display();
		return this;
	}
	
	//定义map底层的数据存储结构链表
	private class LinkedList<K,V>{
		
		//链表的虚拟头结点
		private Node<K, V> dummyHead=new Node<K,V>(null,null,null);
		
		private int size=0;
		
		public int getSize() {
			return size;
		}
		
		public boolean isEmpty() {
			return size==0;
		}
		
		public void add(K key,V value) {
			//如果不存在key对应的节点
			if (!contains(key)) {
				//在链表头部进行添加
				dummyHead.next=new Node<K,V>(key, value, dummyHead.next);
				size++;
				return;
			}else {
				//否则修改该节点的值为新值
				get(key,dummyHead.next).value=value;
			}
		}
		
		public V remove(K key) {
			//如果不包含该key对应的节点，直接返回null
			if (!contains(key)) {
				return null;
			}
			Node<K,V> removeNode=remove(key, dummyHead);
			return removeNode!=null?removeNode.value:null;
		}
		
		//删除以node为头结点的链表中的key节点
		private Node<K, V> remove(K key,Node<K, V> node){
			//没有找到该节点
			if (node==null) {
				return node;
			}
			
			if (node.next!=null&&key.equals(node.next.key)) {
				//待删除的节点
				Node<K, V> removeNode=node.next;
				node.next=node.next.next;
				size--;
				return removeNode;
			}
			return remove(key, node.next);
		}
		
		public V get(K key) {
			Node<K, V> node=get(key,dummyHead.next);
			return node!=null?node.value:null;
		}
		
		public boolean contains(K key) {
			return get(key)!=null;
		}
		
		private Node<K, V> get(K key,Node<K,V> node){
			if (node==null) {
				return node;
			}
			if (key.equals(node.key)) {
				return node;
			}
			return get(key,node.next);
		}
		
		public void display() {
			Node<K, V> currentNode=dummyHead.next;
			StringBuffer buffer=new StringBuffer();
			while  (currentNode!=null) {
				buffer.append("{"+currentNode.key+":"+currentNode.value+"}->");
				currentNode=currentNode.next;
			}
			buffer.append("NULL");
			System.out.println(buffer);
		}
		
		//定义map节点
		private class Node<K,V>{
			public K key;
			public V value;
			public Node<K, V> next;
			public Node(K key, V value,Node<K, V> next) {
				this.key = key;
				this.value = value;
				this.next = next;
			}
		}
	}
}
