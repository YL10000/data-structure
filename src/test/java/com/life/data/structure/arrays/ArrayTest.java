/**
 * Copyright © 2017, Beijing XitianQujing Technology Co., Ltd.
 * @Title: ArrayTest.java
 * @Package com.life.data.structure.arrays
 * @Description: 数组测试类
 * @Author: ViaX-yanglin
 * @Date: 2018年8月26日 下午5:33:29
 * @Version V1.0
 * @Copyright: 2018 All Rights Reserved.北京西天取经科技有限公司
 */
package com.life.data.structure.arrays;

import org.junit.Test;

/**
 * @Title: ArrayTest
 * @Description: 数组测试类
 * @Author: ViaX-yanglin
 * @Date: 2018年8月26日 下午5:33:29
 * 
 * @Copyright: 2018 All Rights Reserved.北京西天取经科技有限公司
 */
public class ArrayTest {
	
	

	@Test
	public void operateWithIndex() {
		OperationWithIndex array=new OperationWithIndex(10);
		array.insert(4);
		array.insert(5);
		array.insert(2);
		array.insert(3);
		
		array.display();
		
		array.remove(2);
		array.display();
		
		System.out.println(array.get(2));
	}
	
	
	@Test
	public void operateNoIndex() {
		OperationNoIndex array=new OperationNoIndex(10);
		array.insert(4);
		array.insert(5);
		array.insert(2);
		array.insert(3);
		
		array.display();
		
		array.remove(5);
		array.display();
		
		System.out.println(array.get(2));
	}
	
	@Test
	public void operateNoIndexRepeatable() {
		OperationNoIndexRepeatable array=new OperationNoIndexRepeatable(10);
		array.insert(4);
		array.insert(5);
		array.insert(2);
		array.insert(4);
		array.insert(3);
		array.insert(5);
		array.insert(3);
		
		array.display();
		
		array.remove(5);
		array.display();
		
		System.out.println(array.get(4));
	}
}
