package cn.highedu.cat.common;

/**
 * 实体保存失败异常
 * 例如：添加商品时，商品已经存在
 * 例如：添加商品时，商品的标题已经存在
 * @version 0.0.1
 * @author HighEDU
 */
public class EntitySaveFailedException extends ServiceException {

    public EntitySaveFailedException(String message) {
        super(ServiceCode.ERR_SAVE_FAILED, message);
    }

}
