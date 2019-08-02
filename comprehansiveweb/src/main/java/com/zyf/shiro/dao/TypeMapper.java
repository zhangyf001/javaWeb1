package com.zyf.shiro.dao;


import com.zyf.shiro.model.Type;

import java.util.List;

public interface TypeMapper {
	public List<Type> queryByType(String type);
	public List<Type> queryAll();
}
