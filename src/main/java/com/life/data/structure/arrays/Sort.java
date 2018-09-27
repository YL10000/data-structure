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

import java.util.Arrays;

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
	
	//快速排序
	public int[] quickSort(int[] arr) {
		//如果输入为空或者数组的个数为空，直接返回一个空数组
		if (arr==null||arr.length==0) {
			return new int[] {};
		}
		int base=arr[0],//基数
				i=0,//左侧哨兵的坐标
				j=arr.length-1;//右侧哨兵的坐标
		if (i>j) {
			//如果左侧哨兵的坐标大于右侧哨兵的坐标，直接返回
			return arr;
		}
		//从右侧的哨兵向左移动，直到遇到比基准数小的数为止
		while (arr[j]>=base&&i<j) {
			j--;
		}
		//左侧的哨兵向右移动，直到遇到比基准数大的数为止
		while (arr[i]<=base&&i<j) {
			i++;
		}
		
		//当左右哨兵没有碰面
		if (i<j) {
			//交互两个哨兵所在坐标的数据，
			change(arr, i, j);
			//然后继续重复上面的操作
			return quickSort(arr);
		}else {
			//如果左右哨兵碰面，交互中间数和基准数
			change(arr, 0, i);
			int[] result=arr;
			//从交换的中间数据开始，把原数组分为左右两个数组，分别进行重复上面的操作
			if (i>0) {
				//最小的数据在中间，则从中间分为两段，分别进行快速排序
				int[] leftsorted=concat(quickSort(Arrays.copyOfRange(arr, 0, i)), new int[] {base});
				
				int[] rightsorted=quickSort(Arrays.copyOfRange(arr, j+1, arr.length));
				
				//将左右排好序的从新连接为一个新数组
				result=concat(leftsorted, rightsorted);
			}else if (i==0&&j==0&&arr.length>0) {
				//第一位为做小的数据，则将后面的数据进行快速排序
				result=concat(new int[] {arr[0]}, quickSort(Arrays.copyOfRange(arr, 1, arr.length)));
			} 
			return result;
		}
	}
	
	//交互两个位置上的数据
	private void change(int[] arr,int leftIndex,int rightIndex) {
		int temp=arr[leftIndex];
		arr[leftIndex]=arr[rightIndex];
		arr[rightIndex]=temp;
	}
	
	//将两个数组合并为一个数组
	private int[] concat(int[] arr1,int[] arr2) {
		int[] result=Arrays.copyOf(arr1, arr1.length+arr2.length);
		System.arraycopy(arr2, 0, result, arr1.length, arr2.length);
		return result;
	}
	
	//归并排序
	public int[] mergeSort(int[] arr) {
		//如果数组为空，直接返回
		if (arr==null||arr.length==0) {
			return arr;
		}
		if (arr.length==1) {
			//如果数组只有一个元素，直接返回
			return arr;
		}else if (arr.length==2) {
			//如果数组只有两个元素，则进行直接比较后进行交换
			if (arr[0]>arr[1]) {
				change(arr, 0, 1);
			}
			return arr;
		}else {
			//数组有两个以上的元素，则从中间将原数组分为两个小的数组，小数组进行排序后在进行合并为一个大的数组
			int minIndex=arr.length/2;
			int[] leftSorted=mergeSort(Arrays.copyOfRange(arr, 0, minIndex));
			int[] rightSorted=mergeSort(Arrays.copyOfRange(arr, minIndex, arr.length));
			//合并排序好的两个数组
			return merge(leftSorted,rightSorted,arr.length);
		}
	}

	//将左右两边的数组进行归并为一个数组
	private int[] merge(int[] leftSorted, int[] rightSorted,int size) {
		int[] arr=new int[size];
		int leftIndex=0;
		int righIndex=0;
		int arrIndex=0;
		
		while (leftIndex<leftSorted.length&&righIndex<rightSorted.length) {
			//如果左侧的数据大于右边的数据
			if (leftSorted[leftIndex]>rightSorted[righIndex]) {
				arr[arrIndex++]=rightSorted[righIndex++];
			}else if(leftSorted[leftIndex]<rightSorted[righIndex]) {
				arr[arrIndex++]=leftSorted[leftIndex++];
			}else {
				//两边的数据一样，有重复数据
				arr[arrIndex++]=leftSorted[leftIndex++];
				arr[arrIndex++]=rightSorted[righIndex++];
			}
		}
		
		//如果左边有剩余
		while (leftIndex<leftSorted.length) {
			arr[arrIndex++]=leftSorted[leftIndex++];
		}
		
		//如果右边有剩余
		while (righIndex<rightSorted.length) {
			arr[arrIndex++]=rightSorted[righIndex++];
		}
		return arr;
	}
	
	//桶排序
	public void bucketSort(int[] arr) {
		//查找数组中最大输入的位数
		int maxDigit=maxDigit(arr);
		
		//存放数据的桶，每次用0-9的桶来装对应位数上相同的数据
		int[][] temp=new int[10][arr.length];
		
		//记录每个桶中当前元素的个数
		int[] order=new int[10];
		
		//当前排序的位数1：个位，2：十位，3：百位
		int currentDigit=1;
		
		while (currentDigit<=maxDigit) {
			for(int item:arr) {
				//该数据在当前位数上的值
				int index=getDigitValue(item, currentDigit);
				
				//将对应的数据放入到对应的桶中
				temp[index][order[index]]=item;
				
				//将当前桶中的数据个数加1
				order[index]=order[index]+1;
			}
			
			//将数据按桶的顺序返回到原来的数组中
			int k=0;
			for(int i=0;i<temp.length;i++) {
				for(int j=0;j<order[i];j++) {
					int item=temp[i][j];
					arr[k++]=item;
				}
				order[i]=0;
			}
			//继续按下个位进行排序
			currentDigit++;
		}
	}
	
	//查询指定数组中最大数的个数
	private int maxDigit(int[] arr) {
		int maxItem=arr[0];
		for(int item:arr) {
			if (item>maxItem) {
				maxItem=item;
			}
		}
		return Integer.toString(maxItem).length();
	}
	
	//查询指定的数的指定位数上的数字
	private int getDigitValue(int value,int digit) {
		if (digit==1) {
			return (int)(value%Math.pow(10, digit));
		}else {
			int mode= (int)(value%Math.pow(10, digit));
			return mode/(int) Math.pow(10, digit-1);
		}
	}
}
