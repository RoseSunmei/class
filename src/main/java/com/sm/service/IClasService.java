package com.sm.service;

import com.sm.entities.Clas;

public interface IClasService extends IBaseService<Clas> {
	
	boolean findByclasNum(String clasNum);
	
	boolean findByclasName(String clasName);
	
}
