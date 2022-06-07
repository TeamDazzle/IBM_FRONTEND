package com.ibm.service;

import java.util.List;

import com.ibm.entity.Screen;

public interface ScreenService {
	
	int save(Screen s);
	
	Screen fetch(int sId);
	

	List<Screen> list();

}
