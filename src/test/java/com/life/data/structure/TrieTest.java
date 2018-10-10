/**
 * Copyright © 2017, Beijing XitianQujing Technology Co., Ltd.
 * @Title: TrieTest.java
 * @Package com.life.data.structure
 * @Description: Trie测试类
 * @Author: ViaX-yanglin
 * @Date: 2018年9月30日 下午4:49:59
 * @Version V1.0
 * @Copyright: 2018 All Rights Reserved.北京西天取经科技有限公司
 */
package com.life.data.structure;

import org.junit.Test;

import com.life.data.structure.tree.Trie;

/**
 * @Title: TrieTest
 * @Description: Trie测试类
 * @Author: ViaX-yanglin
 * @Date: 2018年9月30日 下午4:49:59
 * 
 * @Copyright: 2018 All Rights Reserved.北京西天取经科技有限公司
 */
public class TrieTest {

	@Test
	public void trieTest() {
		Trie<Integer> trie=new Trie<>();
		trie.insert("hello", 10).insert("world", 20).insert("wolf", 15)
			.insert("hi", 3).insert("world", 9)
			.insert("insert", 4).insert("in", 3);
		System.out.println(trie);
		System.out.println(trie.get("insert3"));
		//System.out.println(trie.contains("ins"));
	}
}
