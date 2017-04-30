package com.denghb.zuiyou.gateway.utils;

import com.denghb.dbhelper.paging.PagingResult;
import com.denghb.zuiyou.gateway.model.DataTablesResult;

public class DataUtils {

	public static <T> DataTablesResult<T> pagingResult2DataTablesResult(PagingResult<T> pagingResult) {
		DataTablesResult<T> object = new DataTablesResult<T>();
		object.setData(pagingResult.getList());
		object.setRecordsTotal(pagingResult.getPaging().getTotal());
		object.setRecordsFiltered(pagingResult.getPaging().getTotal());
		return object;
	}
}
