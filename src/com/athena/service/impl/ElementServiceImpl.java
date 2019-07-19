package com.athena.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.athena.mapper.ElementMapper;
import com.athena.pojo.Element;
import com.athena.service.ElementService;

@Service
public class ElementServiceImpl implements ElementService {
	
	@Resource
	private ElementMapper elementMapper;
	@Override
	public List<Element> selByRid(int rid) {
		return elementMapper.selByRid(rid);
	}

}
