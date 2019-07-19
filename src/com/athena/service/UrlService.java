package com.athena.service;

import java.util.List;

import com.athena.pojo.Url;

public interface UrlService {
	List<Url> selByRid(int rid);
	
	List<Url> showAll();
}
