/**
 * Copyright © 2017, Beijing XitianQujing Technology Co., Ltd.
 * @Title: SetTest.java
 * @Package com.life.data.structure
 * @Description: 集合测试类
 * @Author: ViaX-yanglin
 * @Date: 2018年9月28日 下午3:34:19
 * @Version V1.0
 * @Copyright: 2018 All Rights Reserved.北京西天取经科技有限公司
 */
package com.life.data.structure;

import org.junit.Test;

import com.life.data.structure.set.BinarySeachTreeSet;
import com.life.data.structure.set.LinkedListSet;

/**
 * @Title: SetTest
 * @Description: 集合测试类
 * @Author: ViaX-yanglin
 * @Date: 2018年9月28日 下午3:34:19
 * 
 * @Copyright: 2018 All Rights Reserved.北京西天取经科技有限公司
 */
public class SetTest {

	@Test
	public void linkedlistSetTest() {
		LinkedListSet<Integer> linkedListSet=new LinkedListSet<>();
		linkedListSet.add(5).add(5).add(3).add(3).add(2).add(6).add(4).display();
	}
	
	@Test
	public void binarySearchTreeSetTest() {
		BinarySeachTreeSet<Integer> treeSet=new BinarySeachTreeSet<>();
		treeSet.add(5).add(5).add(3).add(3).add(2).add(6).add(4).display();
	}
}
