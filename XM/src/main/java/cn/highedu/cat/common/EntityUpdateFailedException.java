package cn.highedu.cat.common;

/**
 * 实体更新失败异常
 * 例如：修改商品时，商品不存在
 * 例如：修改商品时，商品的标题不存在
 * @version 0.0.1
 * @author HighEDU
 */
public class EntityUpdateFailedException extends ServiceException {

        public EntityUpdateFailedException(String message) {
            super(ServiceCode.ERR_UPDATE_FAILED, message);
        }

}
