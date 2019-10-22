package com.hanrabong.web.seviceImpls;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hanrabong.web.domains.HCustDTO;
import com.hanrabong.web.mappers.HCustMapper;
import com.hanrabong.web.services.HCustService;

@Service
public class HCustServiceImpl implements HCustService{
	@Autowired HCustMapper hCustMapper;

	@Override
	public int countHCusts() {
		return hCustMapper.countHCusts();
	}

	@Override
	public HCustDTO login(HCustDTO param) {
		return hCustMapper.selectUserById(param);
	}

	@Override
	public void join(HCustDTO param) {
		hCustMapper.insertHCust(param);
	}
	
	@Override
	public boolean idCheck(HCustDTO param) {
		boolean result = true;
		if(hCustMapper.selectUserById(param)==null) {
			result=false;
		}
		return result;
	}
	
}
