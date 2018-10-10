/**
 * Copyright © 2017, Beijing XitianQujing Technology Co., Ltd.
 * @Title: Set.java
 * @Package com.life.data.structure.set
 * @Description: set接口
 * @Author: ViaX-yanglin
 * @Date: 2018年9月28日 下午2:30:48
 * @Version V1.0
 * @Copyright: 2018 All Rights Reserved.北京西天取经科技有限公司
 */
package com.life.data.structure.set;

/**
 * @Title: Set
 * @Description: set接口
 * @Author: ViaX-yanglin
 * @Date: 2018年9月28日 下午2:30:48
 * 
 * @Copyright: 2018 All Rights Reserved.北京西天取经科技有限公司
 */
public interface Set<E> {

	Integer getSize();
	
	boolean isEmpty();
	
	boolean contains(E e);
	
	Set<E> add(E e);
	
	Set<E> remove(E e);
	
	Set<E> display();
}
