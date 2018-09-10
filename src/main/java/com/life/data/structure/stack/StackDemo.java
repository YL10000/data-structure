/**
 * Copyright © 2017, Beijing XitianQujing Technology Co., Ltd.
 * @Title: StackDemo.java
 * @Package com.life.data.structure.stack
 * @Description: 栈的使用
 * @Author: ViaX-yanglin
 * @Date: 2018年9月4日 下午3:07:22
 * @Version V1.0
 * @Copyright: 2018 All Rights Reserved.北京西天取经科技有限公司
 */
package com.life.data.structure.stack;

import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Title: StackDemo
 * @Description: 栈的使用
 * @Author: ViaX-yanglin
 * @Date: 2018年9月4日 下午3:07:22
 * 
 * @Copyright: 2018 All Rights Reserved.北京西天取经科技有限公司
 */
public class StackDemo {

	//使用栈实现字符串的反转
	public String reverse(String content) {
		char[] bs=content.toCharArray();
		MyStack<Character> myStack=new MyStack<>(20);
		
		//将原字符串的按字符顺序依次压入栈中
		for(char c:bs) {
			myStack.push(new Character(c));
		}
		StringBuffer buffer=new StringBuffer();
		
		//从栈中将字符依次弹出
		while (!myStack.isEmpty()) {
			buffer.append(myStack.pop());
		}
		return buffer.toString();
	}
	
	//检查表达式中的括号是否成对出现
	public boolean checkBrackets(String expression) {
		MyStack<Character> myStack=new MyStack<>(20);
		char[] cs=expression.toCharArray();
		for(int i=0;i<cs.length;i++) {
			char c=cs[i];
			if (c=='{'||c=='('||c=='[') {
				//如果是左括号直接压入栈中
				myStack.push(new Character(c));
			}else if(c==')') {
				//如果是右小括号，首先判断是不是和左括号对应
				if (myStack.peek().charValue()!='(') {
					System.out.println("位置"+i+"多了')'");
					return false;
				}else {
					//如果和小括号对象，直接将小括号弹出
					myStack.pop();
				}
			}else if (c==']') {
				//如果是右中括号，
				if (myStack.peek().charValue()!='[') {
					System.out.println("位置"+i+"多了']'");
					return false;
				}else {
					myStack.pop();
				}
			}else if (c=='}') {
				if (myStack.peek().charValue()!='{') {
					System.out.println("位置"+i+"多了'}'");
					return false;
				}else {
					myStack.pop();
				}
			}
		}
		return true;
	}
	
	//中缀表达式转后缀表达式
	public String infixToPostfix(String infixExpression) {
		MyStack<String> numStack=new MyStack<>(20);
		//操作符栈
		MyStack<Operator> operatorStack=new MyStack<>(20);
		StringTokenizer tokenizer=new StringTokenizer(infixExpression,"+,-,*,/,(,)",true);
		while (tokenizer.hasMoreTokens()) {
			String token=tokenizer.nextToken();
			//如果是数字，直接压入栈中
			if (isNum(token)) {
				numStack.push(token);
			}else if (isOperator(token)) {
				Operator currentOperator=new Operator(token);
				
				//如果操作符栈为空或者当前的操作优先级大于操作符栈顶的操作符的优先级，直接压入操作符栈中
				if (operatorStack.isEmpty()||currentOperator.priority>operatorStack.peek().priority) {
					operatorStack.push(currentOperator);
				}else {
					//如果当前操作符优先级小于栈顶操作符的优先级且栈顶不是左括号，进行计算
					while (!operatorStack.isEmpty()&&currentOperator.priority<=operatorStack.peek().priority&&!operatorStack.peek().character.equals("(")) {
						String rightNum=numStack.pop();
						String leftNum=numStack.pop();
						numStack.push(leftNum+rightNum+operatorStack.pop().character);
					}
					operatorStack.push(currentOperator);
				} 
				
				//如果是右括号，就将括号中的先进行计算
				if (token.equals(")")) {
					operatorStack.pop();
					while (!operatorStack.peek().character.equals("(")) {
						String rightNum=numStack.pop();
						numStack.push(numStack.pop()+rightNum+operatorStack.pop().character);
					}
					operatorStack.pop();
				}
			}
		}
		
		String rightNum=numStack.pop();
		while (!numStack.isEmpty()) {
			numStack.push(numStack.pop()+rightNum+operatorStack.pop().character);
			rightNum=numStack.pop();
		}
		return rightNum;
	}
	
	//判断是不是操作符
	public boolean isOperator(String token) {
		return token.equals("+")||token.equals("-")||token.equals("*")||token.equals("/")||token.equals(")")||token.equals("(");
	}
	
	//构造操作对象
	private class Operator{
		
		//操作符
		private String character;
		
		//操作符优先级
		private int priority;

		public Operator(String character) {
			super();
			this.character = character;
			if (character.equals("+")||character.equals("-")) {
				this.priority=1;
			}else if (character.equals("*")||character.equals("/")) {
				this.priority=2;
			}else if (character.equals(")")) {
				this.priority=3;
			}else if (character.equals("(")) {
				this.priority=3;
			}
			
		}
	}
	
	//判断是不是数字
	private boolean isNum(String token) {
		Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(token);
        if( !isNum.matches() ){
            return false;
        }
		return true;
	}
	
	//计算中缀表达式的值
	public double calculateInfixExpression(String infixExpression) {
		//将中缀表达式转换为后缀表达式
		String postfixExpression=infixToPostfix(infixExpression);
		return calculatePostfixExpression(postfixExpression);
	}
	
	//计算后缀表达式的值
	public double calculatePostfixExpression(String postfixExpression) {
		char[] cs=postfixExpression.toCharArray();
		MyStack<Double> myStack=new MyStack<>(20);
		for(char c:cs) {
			if (isNum(String.valueOf(c))) {
				myStack.push(Double.valueOf(String.valueOf(c)));
			}else {
				Double rightNum=myStack.pop();
				if (c=='+') {
					myStack.push(myStack.pop()+rightNum);
				}else if (c=='-') {
					myStack.push(myStack.pop()-rightNum);
				}else if (c=='*') {
					myStack.push(myStack.pop()*rightNum);
				}else if (c=='/') {
					myStack.push(myStack.pop()/rightNum);
				}
			}
		}
		return myStack.pop();
	}
}
