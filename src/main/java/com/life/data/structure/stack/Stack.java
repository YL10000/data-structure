/**
 * Copyright © 2017, Beijing XitianQujing Technology Co., Ltd.
 * @Title: Stack.java
 * @Package com.life.data.structure.stack
 * @Description: 栈的实现
 * @Author: ViaX-yanglin
 * @Date: 2018年9月25日 下午5:52:15
 * @Version V1.0
 * @Copyright: 2018 All Rights Reserved.北京西天取经科技有限公司
 */
package com.life.data.structure.stack;

/**
 * @Title: Stack
 * @Description: 栈的实现
 * @Author: ViaX-yanglin
 * @Date: 2018年9月25日 下午5:52:15
 * 
 * @Copyright: 2018 All Rights Reserved.北京西天取经科技有限公司
 */
public interface Stack<E> {

	public int getSize();
	
	public int getCapacity();
	
	public boolean isEmpty();
	
	//压栈
	public Stack<E> push(E e);
	
	//出栈
	public E pop();
	
	//查看栈顶元素
	public E peek();
	
	//打印查看
	public Stack<E> display();
}
