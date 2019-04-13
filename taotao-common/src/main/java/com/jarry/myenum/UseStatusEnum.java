package com.jarry.myenum;

/**
 * @author fengzheng
 * @date 2019/4/11
 * @describe 使用状态枚举
 */
public enum UseStatusEnum {

    正常(1), 删除(2);

    private Integer code;

    private UseStatusEnum(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
