/**
 * Copyright © 2017, Beijing XitianQujing Technology Co., Ltd.
 * @Title: MapTest.java
 * @Package com.life.data.structure
 * @Description: 自定义map测试类
 * @Author: ViaX-yanglin
 * @Date: 2018年9月28日 下午5:45:13
 * @Version V1.0
 * @Copyright: 2018 All Rights Reserved.北京西天取经科技有限公司
 */
package com.life.data.structure;

import org.junit.Test;

import com.life.data.structure.map.BinarySearchTreeMap;
import com.life.data.structure.map.LinkedListMap;

/**
 * @Title: MapTest
 * @Description: 自定义map测试类
 * @Author: ViaX-yanglin
 * @Date: 2018年9月28日 下午5:45:13
 * 
 * @Copyright: 2018 All Rights Reserved.北京西天取经科技有限公司
 */
public class MapTest {

	@Test
	public void LinkedListMapTest() {
		LinkedListMap<String, Integer> map=new LinkedListMap<>();
		map.put("hello", 3).put("world", 5).put("viax", 10).put("hello", 4).display();
		System.out.println(map.get("hello"));
		System.out.println(map.get("www"));
		System.out.println(map.remove("www"));
		map.display();
		System.out.println(map.contains("viax"));
		System.out.println(map.remove("hello"));
		map.display();
	}
	
	@Test
	public void binarySearchTreeMapTest() {
		BinarySearchTreeMap<String, Integer> map=new BinarySearchTreeMap<>();
		map.put("key2", 3).put("key5", 5).put("key4", 10)
			.put("key2", 4).put("key3", 2).put("key1", 1).put("key6", 4).display();
		System.out.println(map.get("key2"));
		System.out.println(map.get("key7"));
		System.out.println(map.remove("key7"));
		map.display();
		System.out.println(map.contains("key1"));
		System.out.println(map.remove("key4"));
		map.display();
		System.out.println(map.get("key1"));
		map.put("key7", 11).display();
	}
}
