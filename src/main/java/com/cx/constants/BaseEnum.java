package com.cx.constants;

/**
 * @author ChengXing
 * @Date Created in 21:44 2021/11/29
 * @Description 20211110blog
 */
public enum BaseEnum {

    NORMAL("status", 1),
    CLOSE("status", 0);

    private String name;
    private Integer code;

    BaseEnum(String name, Integer code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public Integer getCode() {
        return code;
    }
}
