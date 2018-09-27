/**
 * Copyright © 2017, Beijing XitianQujing Technology Co., Ltd.
 * @Title: RecursionDemoTest.java
 * @Package com.life.data.structure.recursion
 * @Description: 递归使用测试类
 * @Author: ViaX-yanglin
 * @Date: 2018年9月11日 上午11:49:51
 * @Version V1.0
 * @Copyright: 2018 All Rights Reserved.北京西天取经科技有限公司
 */
package com.life.data.structure.recursion;

import java.util.ArrayList;

import org.junit.Test;

/**
 * @Title: RecursionDemoTest
 * @Description: 递归使用测试类
 * @Author: ViaX-yanglin
 * @Date: 2018年9月11日 上午11:49:51
 * 
 * @Copyright: 2018 All Rights Reserved.北京西天取经科技有限公司
 */
public class RecursionDemoTest {

	RecursionDemo recursionDemo=new RecursionDemo();
	
	@Test
	public void fabonacciTest() {
		for(int i=0;i<10;i++) {
			System.out.print(recursionDemo.getN(i)+",");
		}
	}
	
	@Test
	public void towerTest() {
		recursionDemo.tower(4,"原塔","临时塔","目标塔");
	}
	
	@Test
	public void bagTest() {
		int[] arr=new int[] {4,5,8,9,3,1,6,10};
		recursionDemo.bag(arr, 15, new ArrayList<>(), 0);
		/*for(int i=0;i<arr.length;i++) {
			System.out.println(i);
			recursionDemo.bag(arr, 15, new ArrayList<>(), i);
		}*/
	}
}
