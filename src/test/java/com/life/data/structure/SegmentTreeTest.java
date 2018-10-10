/**
 * Copyright © 2017, Beijing XitianQujing Technology Co., Ltd.
 * @Title: SegmentTreeTest.java
 * @Package com.life.data.structure
 * @Description: 线段树测试类
 * @Author: ViaX-yanglin
 * @Date: 2018年9月29日 下午5:53:10
 * @Version V1.0
 * @Copyright: 2018 All Rights Reserved.北京西天取经科技有限公司
 */
package com.life.data.structure;

import org.junit.Test;

import com.life.data.structure.tree.SegmentTree;

/**
 * @Title: SegmentTreeTest
 * @Description: 线段树测试类
 * @Author: ViaX-yanglin
 * @Date: 2018年9月29日 下午5:53:10
 * 
 * @Copyright: 2018 All Rights Reserved.北京西天取经科技有限公司
 */
public class SegmentTreeTest {

	@Test
	public void segmentTreeTest() {
		SegmentTree<Integer> tree=new SegmentTree<>(new Integer[]{2,4,5,6,6,4,3,1,8,7}, (a,b)->a+b);
		tree.display();
		System.out.println("[0-9]="+tree.query(0, 9));
		System.out.println("[3-4]="+tree.query(3, 4));
		System.out.println("[5-7]="+tree.query(5, 7));
		System.out.println("[3-8]="+tree.query(3, 8));
		
		tree.set(4, 9);
		tree.display();
	}
}
