package com.jarry.portal.pojo;

/**
 * @author fengzheng
 * @date 2019/4/15
 * @describe 中间轮播图对象
 */
public class ADNode1 {
    //图一
    private String src;
    private Integer width;
    private Integer height;
    //图二
    private String srcB;
    private Integer widthB;
    private Integer heightB;
    //跳转链接
    private String href;
    private String alt;

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public String getSrcB() {
        return srcB;
    }

    public void setSrcB(String srcB) {
        this.srcB = srcB;
    }

    public Integer getWidthB() {
        return widthB;
    }

    public void setWidthB(Integer widthB) {
        this.widthB = widthB;
    }

    public Integer getHeightB() {
        return heightB;
    }

    public void setHeightB(Integer heightB) {
        this.heightB = heightB;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }
}
