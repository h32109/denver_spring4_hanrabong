package com.hanrabong.web.services;


import org.springframework.stereotype.Component;

import com.hanrabong.web.domains.HCustDTO;

@Component 
public interface HCustService {
	
	public int countHCusts();
	public HCustDTO login(HCustDTO param);
	public void join(HCustDTO param);
	public boolean idCheck(HCustDTO param);
	
}
