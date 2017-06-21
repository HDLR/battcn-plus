package com.battcn.framework.mybatis.service;

import java.util.List;
import java.util.Optional;

import com.battcn.framework.mybatis.page.DataGrid;
import com.github.pagehelper.PageInfo;

/**
 * 
 * @ClassName: BaseService
 * @author fly
 * @date 2017年2月23日
 */
public interface BaseService<T> {

	/**
	 * 新增一个实体，方法的实现需保证：当返回true时，实体entity的id属性已被赋值。
	 * 
	 * @author fly
	 * @param entity
	 * @return
	 * @since
	 */
	boolean insert(T entity);

	/**
	 * Null字段使用数据库默认值
	 * 
	 * @author fly
	 * @param entity
	 * @return
	 * @since
	 */
	boolean insertSelective(T entity);

	/**
	 * 根据主键删除一个实体
	 * 
	 * @author fly
	 * @param key
	 * @return
	 * @since
	 */
	boolean deleteById(Object key);

	/**
	 * 根据主键字段进行查询
	 * 
	 * @author fly
	 * @param key
	 * @return
	 * @since
	 */
	Optional<T> selectById(Object key);

	/**
	 * 根据主键更新实体全部字段( 公共属性部分不必赋值，入库拦截前会自动将修改人 修改时间加上)
	 * 
	 * @author fly
	 * @param entity
	 * @return
	 * @since
	 */
	boolean updateById(T entity);

	/**
	 * 根据主键更新不为NUll的值
	 * 
	 * @author fly
	 * @param entity
	 * @return
	 * @since
	 */
	boolean updateSelectiveById(T entity);
	
	List<T> listAll();
	
	PageInfo<T> listForDataGrid(DataGrid grid);
	
	PageInfo<T> listForDataGrid(DataGrid grid, T entity);
}
