package com.hanrabong.web.mappers;


import org.springframework.stereotype.Repository;

import com.hanrabong.web.domains.HCustDTO;

@Repository
public interface HCustMapper {
	public int countHCusts();
	public HCustDTO selectUserByIdAndPw(HCustDTO param);
	public HCustDTO selectUserById(HCustDTO param);
	public void insertHCust(HCustDTO param);
}
