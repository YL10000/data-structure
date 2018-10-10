/**
 * Copyright © 2017, Beijing XitianQujing Technology Co., Ltd.
 * @Title: BinarySearchTreeTest.java
 * @Package com.life.data.structure.tree
 * @Description: 二分搜索树测试类
 * @Author: ViaX-yanglin
 * @Date: 2018年9月27日 上午11:46:02
 * @Version V1.0
 * @Copyright: 2018 All Rights Reserved.北京西天取经科技有限公司
 */
package com.life.data.structure;

import org.junit.Test;

import com.life.data.structure.tree.BinarySearchTree;

/**
 * @Title: BinarySearchTreeTest
 * @Description: 二分搜索树测试类
 * @Author: ViaX-yanglin
 * @Date: 2018年9月27日 上午11:46:02
 * 
 * @Copyright: 2018 All Rights Reserved.北京西天取经科技有限公司
 */
public class BinarySearchTreeTest {

	@Test
	public void binarySearchTreeTest() {
		Integer[] nums=new Integer[] {5,3,4,7,9,6,8,2,10};
		BinarySearchTree<Integer> tree=new BinarySearchTree<>();
		for(Integer num:nums) {
			tree.add(num);
		}
		//tree.displayMidOrder().displayPreOrder().displayPostOrder().displayLayerOrder();
		//tree.removeMin().displayLayerOrder().removeMax().displayLayerOrder();
		//tree.displayLayerOrder();
		
		tree.remove(4).displayLayerOrder();
		
		
		//System.out.println(tree.contains(9));
		//System.out.println(tree.contains(10));
		
		//System.out.println(tree.findMax());
		//System.out.println(tree.findMin());
	}
}
