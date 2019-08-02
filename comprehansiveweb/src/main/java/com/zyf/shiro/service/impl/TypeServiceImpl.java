package com.zyf.shiro.service.impl;


import com.zyf.shiro.dao.TypeMapper;
import com.zyf.shiro.model.Type;
import com.zyf.shiro.service.TypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service("typeService")
public class TypeServiceImpl implements TypeService {
	@Resource
	private TypeMapper typeMapper;
	public List<Type> queryByType(String type) {

		return typeMapper.queryByType(type);
	}
	public  List<Type> queryAll(){
		return  typeMapper.queryAll();
	}
}
