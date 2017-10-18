package com.it.shop.dao;

import com.it.shop.exception.MyException;

import java.util.List;
import java.util.Map;

public interface BaseDao<T> {

    /**
     * 插入操作
     * @param item 要插入数据库的对象
     * @throws MyException 自定义异常
     */
    public void doInsert(T item) throws MyException;

    /**
     * 更新操作
     * @param item 要更新的对象
     * @throws MyException 自定义异常
     */
    public void doUpdate(T item) throws MyException;

    /**
     * 删除操作
     * @param item 要删除的对象
     * @throws MyException 自定义异常
     */
    public void doDelete(T item) throws MyException;

    /**
     * 根据主键id查找
     * @param id 主键id
     * @return 查找的结果的实体类
     * @throws MyException 自定义异常
     */
    public T findById(Integer id) throws MyException;


    /**
     * 查找所有记录
     * @return 所有实体记录集合
     * @throws MyException  自定义异常
     */
    public List<T> findAll() throws MyException;

    /**
     * 带分页的模糊查询
     * @param column 查询条件的列名
     * @param keyWord 查询关键词
     * @param currPage 当前页数
     * @param pageSize 每页显示的数量
     * @return 所有符合条件的对象集合
     * @throws MyException 自定义异常
     */
    public List<T> findAllPaging(String column, String keyWord, int currPage, int pageSize) throws MyException;

    /**
     * 根据特定条件查询
     * @param conditions 查询条件的键值对
     * @return 所有符合条件的对象集合
     * @throws MyException 自定义异常
     */
    public List<T> findByCondition(Map<String, Object> conditions) throws MyException;

    /**
     * 查询符合条件的记录数
     * @param column 查询条件的列名
     * @param keyWord 查询的关键词，如果关键词为空，则查询所有记录
     * @return 所有符合条件的记录数
     * @throws MyException 自定义异常
     */
    public int getAllCount(String column, String keyWord) throws MyException;

}
