package cn.highedu.cat.common;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.Data;

import java.io.Serializable;

/**
 * 统一响应结果类型
 *
 * @author java@tedu.cn
 * @version 0.0.1
 */
@Data
//@ApiModel(description = "统一响应结果类型")
public class JsonResult<T> implements Serializable {

    /**
     * 状态码, 20000表示成功
     */
   // @ApiModelProperty(value = "状态码，20000表示成功")
    private Integer code;
    /**
     * 操作“失败”时的描述文本，正确时候可能为null
     */
    //@ApiModelProperty(value = "操作“失败”时的描述文本")
    private String message;
    /**
     * 操作“成功”时响应的数据
     */
   // @ApiModelProperty(value = "操作“成功”时响应的数据")
    private T data; // E > Element / K > Key / V > Value / T > Type

    public static JsonResult<Void> ok() {
        return ok(null);
    }

    public static <T> JsonResult<T> ok(T data) {
        JsonResult<T> jsonResult = new JsonResult<>();
        jsonResult.setCode(ServiceCode.OK.getValue());
        jsonResult.setData(data);
        jsonResult.message = "OK";
        return jsonResult;
    }

    public static JsonResult<Void> fail(ServiceException e) {
        return fail(e.getServiceCode(), e.getMessage());
    }

    public static JsonResult<Void> fail(ServiceCode serviceCode, String message) {
        JsonResult<Void> jsonResult = new JsonResult<>();
        jsonResult.setCode(serviceCode.getValue());
        jsonResult.setMessage(message);
        return jsonResult;
    }

    public String toJson() {
        try {
            return new ObjectMapper().writeValueAsString(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
