package com.zyf.shiro.service;

import com.zyf.shiro.model.Type;

import java.util.List;

public interface TypeService {
    public List<Type> queryByType(String type);
    public List<Type> queryAll();
}
