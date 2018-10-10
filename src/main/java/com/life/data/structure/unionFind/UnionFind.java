/**
 * Copyright © 2017, Beijing XitianQujing Technology Co., Ltd.
 * @Title: UnionFind.java
 * @Package com.life.data.structure.unionFind
 * @Description: 并查集
 * @Author: ViaX-yanglin
 * @Date: 2018年10月10日 下午5:56:33
 * @Version V1.0
 * @Copyright: 2018 All Rights Reserved.北京西天取经科技有限公司
 */
package com.life.data.structure.unionFind;

/**
 * @Title: UnionFind
 * @Description: 并查集
 * 		主要解决：连接问题
 * 		主要操作： 查找两个节点是否相连
 * 				将两个节点进行连接
 * @Author: ViaX-yanglin
 * @Date: 2018年10月10日 下午5:56:33
 * 
 * @Copyright: 2018 All Rights Reserved.北京西天取经科技有限公司
 */
public interface UnionFind {

	int getSize();
	
	boolean isConnected(int p,int q);
	
	void union(int p,int q);
}
