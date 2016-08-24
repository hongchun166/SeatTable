package com.qfdqc.views.demo.a;

import java.util.List;

public class Test {

	public static void main(String[] args){
		BeanUtils util = new BeanUtils();
		List<UserBean> list = util.getList();
		util.start(list);
	}
}
