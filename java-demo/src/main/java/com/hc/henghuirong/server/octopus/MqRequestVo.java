
package com.hc.henghuirong.server.octopus;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>mqRequestVo complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="mqRequestVo">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ws.credithc.com/}mqPassportVo">
 *       &lt;sequence>
 *         &lt;element name="callbackInterface" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="destInterface" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="destSystemSign" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="jsonParam" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "mqRequestVo", propOrder = {
    "callbackInterface",
    "destInterface",
    "destSystemSign",
    "jsonParam"
})
public class MqRequestVo
    extends MqPassportVo
{

    protected String callbackInterface;
    protected String destInterface;
    protected String destSystemSign;
    protected String jsonParam;

    /**
     * 获取callbackInterface属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCallbackInterface() {
        return callbackInterface;
    }

    /**
     * 设置callbackInterface属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCallbackInterface(String value) {
        this.callbackInterface = value;
    }

    /**
     * 获取destInterface属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDestInterface() {
        return destInterface;
    }

    /**
     * 设置destInterface属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDestInterface(String value) {
        this.destInterface = value;
    }

    /**
     * 获取destSystemSign属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDestSystemSign() {
        return destSystemSign;
    }

    /**
     * 设置destSystemSign属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDestSystemSign(String value) {
        this.destSystemSign = value;
    }

    /**
     * 获取jsonParam属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJsonParam() {
        return jsonParam;
    }

    /**
     * 设置jsonParam属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJsonParam(String value) {
        this.jsonParam = value;
    }

}
