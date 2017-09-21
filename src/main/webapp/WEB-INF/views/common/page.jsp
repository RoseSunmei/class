<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<div class="row">
	<div class="col-sm-6">
		<div id="sample-table-2_info" class="dataTables_info">
			第 ${pageList.begin} 到 ${pageList.end} 条/总共 ${pageList.totalCount} 条记录
			&nbsp;&nbsp;&nbsp;&nbsp;每页
			<s:select list="{5,10,20,50}" name="baseQuery.pageSize"
				onchange='$("#domainForm").submit();' />
			条/第
			<!--s:textfield 默认提交值使用name属性，显示值是value，如果没有value默认使用name -->
			<!--value里面使用ognl表达式，以%{}开头 -->
			<s:textfield id="pageNo" name="baseQuery.currentPage"
				value="%{pageList.currentPage}" size="1" />
			页
			<button class="btn btn-xs btn-info" type="submit">go</button>
		</div>
	</div>
	<div class="col-sm-6">
		<div class="dataTables_paginate paging_bootstrap">
			<ul class="pagination">${pageList.page}
			</ul>
		</div>
	</div>
</div>