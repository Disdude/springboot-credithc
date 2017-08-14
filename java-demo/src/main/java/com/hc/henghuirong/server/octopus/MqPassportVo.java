
package com.hc.henghuirong.server.octopus;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>mqPassportVo complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="mqPassportVo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="destAddr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="expireDateTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="expireTimeMillis" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="msgId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="operator" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="realtime" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="signInfo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="srcAddr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="systemSign" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "mqPassportVo", propOrder = {
    "destAddr",
    "expireDateTime",
    "expireTimeMillis",
    "msgId",
    "operator",
    "realtime",
    "signInfo",
    "srcAddr",
    "systemSign"
})
@XmlSeeAlso({
    MqResponseVo.class,
    MqRequestVo.class
})
public class MqPassportVo {

    protected String destAddr;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar expireDateTime;
    protected Long expireTimeMillis;
    protected String msgId;
    protected String operator;
    protected boolean realtime;
    protected String signInfo;
    protected String srcAddr;
    protected String systemSign;

    /**
     * 获取destAddr属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDestAddr() {
        return destAddr;
    }

    /**
     * 设置destAddr属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDestAddr(String value) {
        this.destAddr = value;
    }

    /**
     * 获取expireDateTime属性的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getExpireDateTime() {
        return expireDateTime;
    }

    /**
     * 设置expireDateTime属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setExpireDateTime(XMLGregorianCalendar value) {
        this.expireDateTime = value;
    }

    /**
     * 获取expireTimeMillis属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getExpireTimeMillis() {
        return expireTimeMillis;
    }

    /**
     * 设置expireTimeMillis属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setExpireTimeMillis(Long value) {
        this.expireTimeMillis = value;
    }

    /**
     * 获取msgId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMsgId() {
        return msgId;
    }

    /**
     * 设置msgId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMsgId(String value) {
        this.msgId = value;
    }

    /**
     * 获取operator属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOperator() {
        return operator;
    }

    /**
     * 设置operator属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOperator(String value) {
        this.operator = value;
    }

    /**
     * 获取realtime属性的值。
     * 
     */
    public boolean isRealtime() {
        return realtime;
    }

    /**
     * 设置realtime属性的值。
     * 
     */
    public void setRealtime(boolean value) {
        this.realtime = value;
    }

    /**
     * 获取signInfo属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSignInfo() {
        return signInfo;
    }

    /**
     * 设置signInfo属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSignInfo(String value) {
        this.signInfo = value;
    }

    /**
     * 获取srcAddr属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSrcAddr() {
        return srcAddr;
    }

    /**
     * 设置srcAddr属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSrcAddr(String value) {
        this.srcAddr = value;
    }

    /**
     * 获取systemSign属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSystemSign() {
        return systemSign;
    }

    /**
     * 设置systemSign属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSystemSign(String value) {
        this.systemSign = value;
    }

}
