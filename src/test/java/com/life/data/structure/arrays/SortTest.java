/**
 * Copyright © 2017, Beijing XitianQujing Technology Co., Ltd.
 * @Title: SortTest.java
 * @Package com.life.data.structure.arrays
 * @Description: 简单排序测试类
 * @Author: ViaX-yanglin
 * @Date: 2018年9月4日 下午1:56:22
 * @Version V1.0
 * @Copyright: 2018 All Rights Reserved.北京西天取经科技有限公司
 */
package com.life.data.structure.arrays;

import java.util.Arrays;

import org.junit.Test;

/**
 * @Title: SortTest
 * @Description: 简单排序测试类
 * @Author: ViaX-yanglin
 * @Date: 2018年9月4日 下午1:56:22
 * 
 * @Copyright: 2018 All Rights Reserved.北京西天取经科技有限公司
 */
public class SortTest {

	int[] array=new int[] {1,45,32,8,23,5,14};
	
	@Test
	public void bubbleSort() {
		array=new Sort().bubbleSort(array);
		
		Arrays.stream(array).forEach((t)->{
			System.out.print(t+",");
		});
	}
	
	@Test
	public void bubbleSort2() {
		array=new Sort().bubbleSort2(array);
		
		Arrays.stream(array).forEach((t)->{
			System.out.print(t+",");
		});
	}
	
	@Test
	public void selectSortTest() {
		array=new Sort().selectSort(array);
		
		Arrays.stream(array).forEach((t)->{
			System.out.print(t+",");
		});
	}
	
	@Test
	public void insertSortTest() {
		array=new Sort().insertSort(array);
		
		Arrays.stream(array).forEach((t)->{
			System.out.print(t+",");
		});
	}
	
	@Test
	public void insertSort2Test() {
		array=new Sort().insertSort2(array);
		
		Arrays.stream(array).forEach((t)->{
			System.out.print(t+",");
		});
	}
}
