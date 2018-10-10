/**
 * Copyright © 2017, Beijing XitianQujing Technology Co., Ltd.
 * @Title: Trie.java
 * @Package com.life.data.structure.tree
 * @Description: Trie树的实现
 * @Author: ViaX-yanglin
 * @Date: 2018年9月30日 下午3:14:33
 * @Version V1.0
 * @Copyright: 2018 All Rights Reserved.北京西天取经科技有限公司
 */
package com.life.data.structure.tree;

import java.util.TreeMap;

/**
 * @Title: Trie
 * @Description: Trie树的实现
 * @Author: ViaX-yanglin
 * @Date: 2018年9月30日 下午3:14:33
 * 
 * @Copyright: 2018 All Rights Reserved.北京西天取经科技有限公司
 */
public class Trie<E> {
	
	private Node dummyHead=new Node();
	private int size=0;
	private int nodeSize=0;
	
	public int getSize() {
		return size;
	}
	
	//添加字符串
	public Trie<E> insert(String key,E value){
		insert(key, value, 0, dummyHead);
		return this;
	}
	
	//添加key的index字符到以node为根节点的树上
	private void insert(String key,E value,int index,Node node) {
		
		//key在index的字符
		Character currentChar=key.charAt(index);
		Node currentNode=node.next.get(currentChar);
		
		if (index==key.length()-1) {
			if (currentNode==null) {
				size++;
				//已经到了key的最后一个字符
				currentNode=new Node(currentChar,value);
				nodeSize++;
			}else if (currentNode!=null&&!value.equals(currentChar)) {
				//修改指定的key的值
				currentNode.value=value;
			}
			node.next.put(currentChar, currentNode);
			return;
		}
		
		//不存在该字符
		if (currentNode==null) {
			currentNode=new Node(currentChar);
			node.next.put(currentChar, currentNode);
			nodeSize++;
		}
		
		insert(key, value, index+1, currentNode);
	}
	
	//获取指定key对应的value
	public E get(String key) {
		return get(key, 0, dummyHead.next.get(key.charAt(0)));
	}
	
	//判断指定的key是否存在
	public boolean contains(String key) {
		return get(key)!=null?true:false;
	}
	
	//判断key在index位置的字符是否在以node为根节点的树上
	private E get(String key,int index,Node node) {
		Character c=key.charAt(index);
		if (node==null||!c.equals(node.key)) {
			return null;
		}
		if (index==key.length()-1&&c.equals(node.key)&&node.value!=null) {
			return node.value;
		}else if (index==key.length()-1) {
			return null;
		}
		return get(key, index+1, node.next.get(key.charAt(index+1)));
	}
	
	//Trie节点
	private class Node{
		Character key;
		E value;
		TreeMap<Character, Node> next;
		public Node() {
			this(null);
		}
		public Node(Character key, E value) {
			this.key = key;
			this.value = value;
			this.next=new TreeMap<>();
		}
		public Node(Character key) {
			this(key, null);
		} 
	}

	@Override
	public String toString() {
		return "Trie [size=" + size + ",nodeSize="+nodeSize+"]";
	}
}
