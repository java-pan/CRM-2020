package com.hyp.crm.vo;

import java.util.List;

/**
 * @author HYP
 * @create 2020-11-17 13:37
 */
public class PagenationVO<T> {
    private int total;
    private List<T> dataList;

    @Override
    public String toString() {
        return "PagenationVO{" +
                "total=" + total +
                ", dataList=" + dataList +
                '}';
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<T> getDataList() {
        return dataList;
    }

    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
    }
}
