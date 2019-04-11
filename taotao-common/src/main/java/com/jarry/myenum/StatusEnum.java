package com.jarry.myenum;

/**
 * @author fengzheng
 * @date 2019/4/11
 * @describe
 */
public enum StatusEnum {

    正常((byte) 1), 下架((byte) 2), 删除((byte) 3);

    private byte code;

    private StatusEnum(byte code) {
        this.code = code;
    }

    public byte getCode() {
        return code;
    }
}
