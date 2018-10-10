/**
 * Copyright © 2017, Beijing XitianQujing Technology Co., Ltd.
 * @Title: AVLTreeTest.java
 * @Package com.life.data.structure
 * @Description: avl tree测试类
 * @Author: ViaX-yanglin
 * @Date: 2018年10月9日 下午5:23:39
 * @Version V1.0
 * @Copyright: 2018 All Rights Reserved.北京西天取经科技有限公司
 */
package com.life.data.structure;

import org.junit.Test;

import com.life.data.structure.tree.AVLTree;

/**
 * @Title: AVLTreeTest
 * @Description: avl tree测试类
 * @Author: ViaX-yanglin
 * @Date: 2018年10月9日 下午5:23:39
 * 
 * @Copyright: 2018 All Rights Reserved.北京西天取经科技有限公司
 */
public class AVLTreeTest {

	@Test
	public void avlTreeTest() {
		AVLTree<Integer> tree=new AVLTree<>();
		tree.add(2).add(5).add(8).add(10).add(15).add(12).add(18).add(11).displayMid().remove(18).displayMid()
			.removeMax().displayMid().removeMin().displayMid();
	}
}
