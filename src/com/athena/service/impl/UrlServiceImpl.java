package com.athena.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.athena.mapper.UrlMapper;
import com.athena.pojo.Url;
import com.athena.service.UrlService;

@Service
public class UrlServiceImpl implements UrlService {
	@Resource
	private UrlMapper urlMapper;
	@Override
	public List<Url> selByRid(int rid) {
		return urlMapper.selByRid(rid);
	}
	@Override
	public List<Url> showAll() {
		return urlMapper.selAll();
	}

}

