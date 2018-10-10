/**
 * Copyright © 2017, Beijing XitianQujing Technology Co., Ltd.
 * @Title: Map.java
 * @Package com.life.data.structure.map
 * @Description: TODO(用一句话描述该文件做什么)
 * @Author: ViaX-yanglin
 * @Date: 2018年9月28日 下午4:20:11
 * @Version V1.0
 * @Copyright: 2018 All Rights Reserved.北京西天取经科技有限公司
 */
package com.life.data.structure.map;

/**
 * @Title: Map
 * @Description: 自定义map接口
 * @Author: ViaX-yanglin
 * @Date: 2018年9月28日 下午4:20:11
 * 
 * @Copyright: 2018 All Rights Reserved.北京西天取经科技有限公司
 */
public interface Map<K,V> {

	int getSize();
	
	boolean isEmpty();
	
	//添加元素，如果key存在，进行value覆盖
	Map<K, V> put(K key,V value);
	
	V remove(K key);
	
	V get(K key);
	
	boolean contains(K key);
	
	Map<K, V> display();
}
