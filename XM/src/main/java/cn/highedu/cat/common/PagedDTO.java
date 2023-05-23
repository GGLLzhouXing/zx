package cn.highedu.cat.common;


import lombok.Data;

import java.io.Serializable;

/**
 * 分页DTO类
 */
@Data
//@ApiModel("分页DTO类")
public class PagedDTO implements Serializable {
    /**
     * 当前页码 从1开始
     */

    private Integer pageNum;

    /**
     * 每页条数
     */
   // @ApiModelProperty("每页条数")
    private Integer pageSize;

    /**
     * 开始查询位置, 从0开始, 通过计算得到
     */
    public Integer getOffset(){
        return (pageNum - 1) * pageSize;
    }
}
