package com.generic;

import java.util.Random;

public class JavaUtility {
	
	/**
	 * returns random number
	 * @return
	 */
	public String getRandomNum() {
		Random ran=new Random();
		int num = ran.nextInt(100);
		
		return num+"";
	}

}
