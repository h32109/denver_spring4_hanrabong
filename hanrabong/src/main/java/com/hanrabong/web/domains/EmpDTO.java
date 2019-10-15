package com.hanrabong.web.domains;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data @Component
public class EmpDTO implements Serializable{
	private static final long serialVersionUID= 1L;

	private String cnum, cid, cpw, cname, gen, birth, skinProb, skinType, child, addr, tel, cpoint;
}



