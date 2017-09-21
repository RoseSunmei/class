package com.sm.query;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 鎶婃煡璇㈠悗缁撴灉鍏ㄩ儴灏佽鍒癙ageList
 *
 */
public class PageList {
	// 褰撳墠椤电爜
	private int currentPage = 1;
	// 涓�〉鏄剧ず鏉℃暟
	private int pageSize = 10;
	// 鎬荤殑鏉℃暟
	private int totalCount;
	// 鎬荤殑椤垫暟锛氳绠楀嚭鏉�
	private int totalPage;
	// 褰撳墠椤甸渶瑕佹樉绀虹殑鏁版嵁
	private List rows = new ArrayList();

	public PageList() {

	}

	public PageList(int currentPage, int pageSize, int totalCount) {
		// 1.鍒ゆ柇鏄惁浼犲叆璐熸暟
		this.currentPage = currentPage < 1 ? 1 : currentPage;
		this.pageSize = pageSize < 1 ? 10 : pageSize;
		this.totalCount = totalCount;
		// 2.璁＄畻鎬荤殑椤垫暟
		// this.totalPage = (this.totalCount % this.pageSize) == 0 ?
		// this.totalCount / this.pageSize
		// : this.totalCount / this.pageSize + 1;
		// static double Math.ceil(double a) 杩斿洖鏈�皬鐨勶紙鏈�帴杩戣礋鏃犵┓澶э級double
		// 鍊硷紝璇ュ�澶т簬绛変簬鍙傛暟锛屽苟绛変簬鏌愪釜鏁存暟銆�
		this.totalPage = (int) Math.ceil(this.totalCount * 1.0D / this.pageSize);
		// 3.鍒ゆ柇褰撳墠椤电爜鏄惁澶т簬鎬荤殑椤垫暟
		this.currentPage = this.currentPage > this.totalPage ? this.totalPage : this.currentPage;
	}

	// 棰濆娣诲姞鐨勬柟娉�
	public int getBegin() {
		return (currentPage - 1) * pageSize + 1;
	}

	public int getEnd() {
		int end = currentPage * pageSize;
		return end > totalCount ? totalCount : end;
	}

	public String getPage() {
		StringBuilder builder = new StringBuilder();
		// 澶勭悊棣栭〉
		if (this.currentPage == 1) {
			builder.append("<li class='prev disabled'><a href='javascript:;'>棣栭〉</a></li>");
			builder.append("<li class='prev disabled'><a href='javascript:;'>涓婁竴椤�/a></li>");
		} else {
			builder.append("<li class='prev'><a href='javascript:;' onclick='go(1);'>棣栭〉</a></li>");
			builder.append("<li class='prev'><a href='javascript:;' onclick='go(" + (currentPage - 1) + ");'>涓婁竴椤�/a></li>");
		}
		// 绠�崟澶勭悊涓棿鐨勫垎椤垫潯
		for (int i = 1; i <= this.totalPage; i++) {
			// 褰撳墠椤电爜鏄惁绛変簬寰幆閲岄潰鐨刬
			if (i == this.currentPage) {
				builder.append("<li class='active'><a href='javascript:;'>" + i + "</a></li>");
			} else {
				builder.append("<li><a href='javascript:;' onclick='go(" + i + ");'>" + i + "</a></li>");
			}
		}
		// 澶勭悊鏈〉
		if (this.currentPage == this.totalPage) {
			builder.append("<li class='next disabled'><a href='javascript:;'>涓嬩竴椤�/a></li>");
			builder.append("<li class='next disabled'><a href='javascript:;'>鏈〉</a></li>");
		} else {
			builder.append("<li class='next'><a href='javascript:;' onclick='go(" + (currentPage + 1) + ");'>涓嬩竴椤�/a></li>");
			builder.append("<li class='next'><a href='javascript:;' onclick='go(" + this.totalPage + ");'>鏈〉</a></li>");
		}
		return builder.toString();
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public List getRows() {
		return rows;
	}

	public void setRows(List rows) {
		this.rows = rows;
	}

	@Override
	public String toString() {
		return "PageList [currentPage=" + currentPage + ", pageSize=" + pageSize + ", totalCount=" + totalCount
				+ ", totalPage=" + totalPage + ", rows=" + rows.size() + "]";
	}

}
