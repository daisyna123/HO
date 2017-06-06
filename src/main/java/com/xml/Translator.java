package com.xml;/**
 * Created by administrator on 2017-06-02.
 */

import javax.xml.bind.annotation.*;

/**
 * @DESCRIPTION 测试xml解析
 * @AUTHER administrator zhangna
 * @create 2017-06-02
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Translator")
@XmlType(propOrder = { })
public class Translator {
    @XmlElement
    private String wordKey;

    public String getWordKey() {
        return wordKey;
    }

    public void setWordKey(String wordKey) {
        this.wordKey = wordKey;
    }
}
