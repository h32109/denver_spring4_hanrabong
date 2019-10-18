package com.hanrabong.web.services;

import java.util.List;

import org.springframework.stereotype.Component;

import com.hanrabong.web.domains.HAdminDTO;
import com.hanrabong.web.domains.HCustDTO;

@Component 
public interface EmpService {
	
	public int countHCusts();
	
}
