/**
 * Copyright © 2017, Beijing XitianQujing Technology Co., Ltd.
 * @Title: RecursionDemo.java
 * @Package com.life.data.structure.recursion
 * @Description: 递归的使用
 * @Author: ViaX-yanglin
 * @Date: 2018年9月11日 下午2:29:19
 * @Version V1.0
 * @Copyright: 2018 All Rights Reserved.北京西天取经科技有限公司
 */
package com.life.data.structure.recursion;

import java.util.List;

/**
 * @Title: RecursionDemo
 * @Description: 递归的使用
 * @Author: ViaX-yanglin
 * @Date: 2018年9月11日 下午2:29:19
 * 
 * @Copyright: 2018 All Rights Reserved.北京西天取经科技有限公司
 */
public class RecursionDemo {

	//斐波拉契数列
	public int getN(int n) {
		if (n<1) {
			return 0;
		}else if (n==1) {
			return 1;
		}else {
			//第三个数为前面两个数之和
			return getN(n-1)+getN(n-2);
		}
	}
	
	//汉塔塔问题
	public void tower(int topN,String src,String temp,String target) {
		if (topN==1) {
			System.out.println("将"+topN+"从"+src+"移动到"+target);
		}else {
			//1.将topn-1作为一个整体放入到temp,将topn移动到target中
			tower(topN-1, src, target, temp);
			
			//2.把topn移动到target
			System.out.println("将"+topN+"从"+src+"移动到"+target);
			
			//3.将topn-1移动到dest
			tower(topN-1, temp, src, target);
		}
	}
	
	//背包问题
	public void bag(int[] arr,int target,List<Integer> result,int currentIndex) {
		for(int i=currentIndex;i<arr.length;i++) {
			System.out.println("index---"+i);
			if (i==currentIndex) {
				continue;
			}
			if (arr[i]>target) {
				continue;
			}else if (arr[i]==target) {
				result.add(arr[i]);
				System.out.println("------find one -------");
				result.forEach(it->System.out.print(it+","));
				System.out.println();
				System.out.println("--------------");
				result.clear();
			}else {
				result.add(arr[i]);
				bag(arr, target-arr[i], result, ++currentIndex);
			}
		}
		
		/*if (currentIndex==arr.length) {
			return;
		}
		if (arr[currentIndex]>target) {
			this.bag(arr, target, result, ++currentIndex);
		}else if (arr[currentIndex]==target) {
			result.add(arr[currentIndex]);
			System.out.println("------find one -------");
			result.forEach(it->System.out.print(it+","));
			System.out.println();
			System.out.println("--------------");
			result.clear();
		}else {
			result.add(arr[currentIndex]);
			this.bag(arr, target-arr[currentIndex], result, ++currentIndex);
		}*/
	}
}
