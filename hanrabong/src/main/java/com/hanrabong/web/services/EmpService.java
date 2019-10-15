package com.hanrabong.web.services;

import java.util.List;

import org.springframework.stereotype.Component;

import com.hanrabong.web.domains.DeptDTO;
import com.hanrabong.web.domains.EmpDTO;

@Component 
public interface EmpService {
	
	public int countEmps();
	
}
