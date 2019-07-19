package com.athena.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.athena.mapper.MenuMapper;
import com.athena.pojo.Menu;
import com.athena.service.MenuService;

@Service
public class MenuServiceImpl implements MenuService {
	
	@Resource
	private MenuMapper menuMapper;
	
	
	@Override
	public List<Menu> showMenu(int rid) {
		return menuMapper.selByRid(rid, 0);
	}

}
