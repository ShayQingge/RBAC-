package com.athena.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.athena.pojo.Menu;

public interface MenuMapper {
	List<Menu> selByRid(@Param("rid") int rid,@Param("pid") int pid);
}
