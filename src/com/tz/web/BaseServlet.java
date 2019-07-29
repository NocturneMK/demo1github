package com.tz.web;

import java.io.IOException;
import java.lang.reflect.Method;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("all")//抑制
public class BaseServlet extends HttpServlet {
	//简化代码方法二：
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			//1、获取请求的method的名称
			String methodName = request.getParameter("method");
			//2、获得当前被访问的对象的字节码对象
			Class clazz = this.getClass(); // ProductServlet.class  
			//3.获得当前字节码对象中的指定方法
			Method  method =  clazz.getMethod(methodName, HttpServletRequest.class,HttpServletResponse.class);
			//4.执行相应的方法
			method.invoke(this, request,response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
