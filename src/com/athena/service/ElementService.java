package com.athena.service;

import java.util.List;

import com.athena.pojo.Element;

public interface ElementService {
	List<Element> selByRid(int rid);
}
