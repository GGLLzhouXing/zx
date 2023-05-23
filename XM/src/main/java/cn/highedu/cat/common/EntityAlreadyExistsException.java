package cn.highedu.cat.common;

/**
 * 实体已经存在异常
 * 例如：添加商品时，商品已经存在
 * 例如：添加商品时，商品的标题已经存在
 * 例如：添加商品时，商品的SKU已经存在
 * @author HighEDU
 * @version 0.0.1
 */
public class EntityAlreadyExistsException extends ServiceException {

    public EntityAlreadyExistsException(String message) {
        super(ServiceCode.ERR_EXISTS, message);
    }
}
