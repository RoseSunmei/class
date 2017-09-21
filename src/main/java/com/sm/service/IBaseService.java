package com.sm.service;

import java.io.Serializable;
import java.util.List;
import com.sm.query.BaseQuery;
import com.sm.query.PageList;

public interface IBaseService<T> {
	void save(T t);

	void update(T t);

	void delete(Serializable id);

	T get(Serializable id);

	List<T> getAll();

	PageList findByQuery(BaseQuery baseQuery);
}
