/**
 * Copyright © 2017, Beijing XitianQujing Technology Co., Ltd.
 * @Title: MyStackTest.java
 * @Package com.life.data.structure.arrays
 * @Description: 栈测试类
 * @Author: ViaX-yanglin
 * @Date: 2018年9月4日 下午2:09:10
 * @Version V1.0
 * @Copyright: 2018 All Rights Reserved.北京西天取经科技有限公司
 */
package com.life.data.structure.arrays;

import org.junit.Test;

import com.life.data.structure.stack.MyStack;
import com.life.data.structure.stack.StackDemo;

/**
 * @Title: MyStackTest
 * @Description: 栈测试类
 * @Author: ViaX-yanglin
 * @Date: 2018年9月4日 下午2:09:10
 * 
 * @Copyright: 2018 All Rights Reserved.北京西天取经科技有限公司
 */
public class MyStackTest {

	@Test
	public void myStackTest() {
		MyStack<Integer> myStack=new MyStack<>(10);
		myStack.push(5).push(6).push(3).push(7);
		System.out.println(myStack.isEmpty());
		System.out.println(myStack.size());
		System.out.println(myStack.pop());
		System.out.println(myStack.size());
		System.out.println(myStack.peek());
		System.out.println(myStack.size());
		System.out.println(myStack.pop());
	}
	
	@Test
	public void stringReverseTest() {
		String content="this is a demo";
		content=new StackDemo().reverse(content);
		System.out.println(content);
	}
	
	@Test
	public void checkBracketsTest() {
		String expression="({1+[[3*3]-(4+2)]})";
		boolean isSuccess=new StackDemo().checkBrackets(expression);
		System.out.println(isSuccess);
	}
	
	@Test
	public void infixToPostfixTest() {
		String infixExpression="(2+3)+(5*8-(9/3+4))-1";
		StackDemo stackDemo=new StackDemo();
		String postfixExpression=stackDemo.infixToPostfix(infixExpression);
		System.out.println(postfixExpression);
		System.out.println(stackDemo.calculatePostfixExpression(postfixExpression));
	}
	
	
}
