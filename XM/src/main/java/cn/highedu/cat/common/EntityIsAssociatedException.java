package cn.highedu.cat.common;

/**
 * 实体已经关联异常
 * 例如：删除商品时，商品已经被订单关联
 * 例如：删除商品时，商品已经被购物车关联
 * @version 0.0.1
 * @author HighEDU
 */
public class EntityIsAssociatedException extends ServiceException {

    public EntityIsAssociatedException(String message) {
        super(ServiceCode.ERR_IS_ASSOCIATED, message);
    }

}
