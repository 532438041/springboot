package com.core.base.result;

import com.github.pagehelper.Page;

import java.util.List;

/**
 * @author smallTao.liu
 * @version V1.0
 * @description :
 * @date 2018/6/21 15:38
 */
public class PageResult<T> {

    // 数据
    private List<T> dataList;
    // 当前页
    private long pageNum;
    // 条数
    private long pageSize;
    // 总条数
    private long total;
    // 总页面数目
    private long pages;

    public List<T> getDataList() {
        return dataList;
    }

    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
    }

    public long getPageNum() {
        return pageNum;
    }

    public void setPageNum(long pageNum) {
        this.pageNum = pageNum;
    }

    public long getPageSize() {
        return pageSize;
    }

    public void setPageSize(long pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public long getPages() {
        return pages;
    }

    public void setPages(long pages) {
        this.pages = pages;
    }

    public PageResult(org.springframework.data.domain.Page<T> list) {
        this.pageNum = list.getNumber();
        this.pageSize = list.getSize();

        this.pages = list.getTotalPages();
        this.dataList = list.getContent();
        this.total = list.getTotalElements();
    }

    public PageResult(Page<T> list) {
        this.pageNum = list.getPageNum();
        this.pageSize = list.getPageSize();

        this.pages = list.getPages();
        this.dataList = list;
        this.total = list.getTotal();
    }

}
