package com.battcn.framework.mybatis.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.battcn.framework.mybatis.mapper.BaseMapper;
import com.battcn.framework.mybatis.page.DataGrid;
import com.battcn.framework.mybatis.service.BaseService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public abstract class BaseServiceImpl<T> implements BaseService<T> {

	@Autowired(required = false)
	private BaseMapper<T> mapper;

	@Transactional(rollbackFor = Exception.class)
	@Override
	public boolean insert(T entity) {
		return mapper.insertSelective(entity) > 0;
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public boolean insertSelective(T entity) {
		return mapper.insertSelective(entity) > 0;
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public boolean deleteById(Object key) {
		return mapper.deleteByPrimaryKey(key) > 0;
	}

	@Override
	public Optional<T> selectById(Object key) {
		return Optional.ofNullable(mapper.selectByPrimaryKey(key));
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public boolean updateById(T entity) {
		return mapper.updateByPrimaryKey(entity) > 0;
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public boolean updateSelectiveById(T entity) {
		return mapper.updateByPrimaryKeySelective(entity) > 0;
	}

	@Override
	public List<T> listAll() {
		return this.mapper.selectAll();
	}

	@Override
	public PageInfo<T> listForDataGrid(DataGrid grid) {
		return this.listForDataGrid(grid, null);
	}

	@Override
	public PageInfo<T> listForDataGrid(DataGrid grid, T entity) {
		grid.getOrderBy();
		PageHelper.startPage(grid.getPageNum(), grid.getPageSize());
		return new PageInfo<T>(mapper.select(entity));
	}

	
}
