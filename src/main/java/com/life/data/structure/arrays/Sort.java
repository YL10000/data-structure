/**
 * Copyright © 2017, Beijing XitianQujing Technology Co., Ltd.
 * @Title: Sort.java
 * @Package com.life.data.structure.arrays
 * @Description: 简单排序
 * @Author: ViaX-yanglin
 * @Date: 2018年9月3日 下午7:27:31
 * @Version V1.0
 * @Copyright: 2018 All Rights Reserved.北京西天取经科技有限公司
 */
package com.life.data.structure.arrays;

/**
 * @Title: Sort
 * @Description: 简单排序
 * @Author: ViaX-yanglin
 * @Date: 2018年9月3日 下午7:27:31
 * 
 * @Copyright: 2018 All Rights Reserved.北京西天取经科技有限公司
 */
public class Sort {

	
	public int[] bubbleSort(int[] arr) {
		//每次外层循环完，末尾会排好一个元素
		for(int i=arr.length-1;i>0;i--) {
			
			//由于末尾的元素已经是排好序的，只需要对前面的元素进行排序即可
			for(int j=0;j<i;j++) {
				if(arr[j]>arr[j+1]) {
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
		}
		return arr;
	}
	
	
	public int[] bubbleSort2(int[] arr) {
		//每次外层循环取第i个元素与后面的每个元素进行比较，每次循环完一次，前面就会排好一个元素
		for(int i=0;i<arr.length-1;i++) {
			
			//由于前面i个元素已经排好，只需对后面的元素进行排序即可
			for(int j=i;j<arr.length;j++) {
				if(arr[i]>arr[j]) {
					int temp=arr[j];
					arr[j]=arr[i];
					arr[i]=temp;
				}
			}
		}
		return arr;
	}
	
	/**
	 * 
	 * @Title: selectSort
	 * @Description: 选择排序
	 */
	public int[] selectSort(int[] arr) {
		//每次查找后面最小的元素的下标，然后和指定元素进行交换
		for(int i=0;i<arr.length-1;i++) {
			int minIndex=i;
			for(int j=i+1;j<arr.length;j++) {
				if (arr[minIndex]>arr[j]) {
					minIndex=j;
				}
			}
			int temp=arr[i];
			arr[i]=arr[minIndex];
			arr[minIndex]=temp;
		}
		return arr;
	}
	
	public int[] insertSort(int[] arr) {
		
		for(int i=1;i<arr.length;i++) {
			for(int j=i-1;j>0;j--) {
				//使用的冒泡排序进行相邻比较
				if(arr[j]>arr[j+1]) {
					int temp=arr[j+1];
					arr[j+1]=arr[j];
					arr[j]=temp;
				}else {
					break;//跳出内存循环
				}
			}
		}
		return arr;
	}	
	
	
	public int[] insertSort2(int[] arr) {
		
		for(int i=1;i<arr.length;i++) {
			int temp=arr[i];
			int j=i-1;
			for(j=i-1;j>0;j--) {
				//如果j位置上的数大于temp,将jw位置上的数向后移动一位
				if(arr[j]>temp) {
					arr[j+1]=arr[j];
				}else {
					break;//跳出内存循环
				}
			}
			//将j+1位置上的数设置为temp
			arr[j+1]=temp;
		}
		return arr;
	}	
}
