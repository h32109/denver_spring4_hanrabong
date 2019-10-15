package com.hanrabong.web.seviceImpls;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hanrabong.web.mappers.EmpMapper;
import com.hanrabong.web.services.EmpService;

@Service
public class EmpServiceImpl implements EmpService{
	@Autowired EmpMapper empMapper;

	@Override
	public int countEmps() {
		return empMapper.countEmps();
	}

}
