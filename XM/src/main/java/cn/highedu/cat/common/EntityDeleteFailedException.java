package cn.highedu.cat.common;

/**
 * 实体删除失败异常
 * 例如：删除商品时，商品不存在
 * 例如：删除商品时，商品的标题不存在
 * @version 0.0.1-SNAPSHOT
 * @author HighEDU
 */
public class EntityDeleteFailedException extends ServiceException {

        public EntityDeleteFailedException(String message) {
            super(ServiceCode.ERR_DELETE_FAILED, message);
        }

}
