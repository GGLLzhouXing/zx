package cn.highedu.cat.common;


import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.util.List;

/**
 * 分页VO类
 */
@Slf4j
@Data

public class PagedVO<E> implements Serializable {

    /**
     * 当前页码 从1开始
     */

    private Integer pageNum;

    /**
     * 每页条数
     */

    private Integer pageSize;

    /**
     * 总条数 从数据库查询
     */

    private Long total;

    /**
     * 总页数 通过计算得到
     */

    private Integer pages;

    /**
     * 数据 从数据库查询
     */

    private List<E> data;

    /**
     * 创建分页VO对象
     */
    public PagedVO(int pageNum, int pageSize, long total, List<E> data) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.total = total;
        this.data = data;
        // 计算总页数
        this.pages = (int) (total % pageSize == 0 ? total / pageSize : total / pageSize + 1);
    }

}
