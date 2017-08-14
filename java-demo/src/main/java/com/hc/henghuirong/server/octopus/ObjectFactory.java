
package com.hc.henghuirong.server.octopus;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.hc.henghuirong.server.octopus package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _MqSendRequestResponse_QNAME = new QName("http://ws.credithc.com/", "mqSendRequestResponse");
    private final static QName _Exception_QNAME = new QName("http://ws.credithc.com/", "Exception");
    private final static QName _MqGetResponseResponse_QNAME = new QName("http://ws.credithc.com/", "mqGetResponseResponse");
    private final static QName _SendOperateLog_QNAME = new QName("http://ws.credithc.com/", "sendOperateLog");
    private final static QName _MqSendRtRequestResponse_QNAME = new QName("http://ws.credithc.com/", "mqSendRtRequestResponse");
    private final static QName _MqSendResponseResponse_QNAME = new QName("http://ws.credithc.com/", "mqSendResponseResponse");
    private final static QName _MgGetRtRequest_QNAME = new QName("http://ws.credithc.com/", "mgGetRtRequest");
    private final static QName _MqGetRequest_QNAME = new QName("http://ws.credithc.com/", "mqGetRequest");
    private final static QName _SendOperateLogResponse_QNAME = new QName("http://ws.credithc.com/", "sendOperateLogResponse");
    private final static QName _MqSendRequest_QNAME = new QName("http://ws.credithc.com/", "mqSendRequest");
    private final static QName _MqGetResponse_QNAME = new QName("http://ws.credithc.com/", "mqGetResponse");
    private final static QName _MgGetRtRequestResponse_QNAME = new QName("http://ws.credithc.com/", "mgGetRtRequestResponse");
    private final static QName _MqSendResponse_QNAME = new QName("http://ws.credithc.com/", "mqSendResponse");
    private final static QName _MqGetRequestResponse_QNAME = new QName("http://ws.credithc.com/", "mqGetRequestResponse");
    private final static QName _MqSendRtRequest_QNAME = new QName("http://ws.credithc.com/", "mqSendRtRequest");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.hc.henghuirong.server.octopus
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link MqGetResponseResponse }
     * 
     */
    public MqGetResponseResponse createMqGetResponseResponse() {
        return new MqGetResponseResponse();
    }

    /**
     * Create an instance of {@link SendOperateLog }
     * 
     */
    public SendOperateLog createSendOperateLog() {
        return new SendOperateLog();
    }

    /**
     * Create an instance of {@link MqSendResponseResponse }
     * 
     */
    public MqSendResponseResponse createMqSendResponseResponse() {
        return new MqSendResponseResponse();
    }

    /**
     * Create an instance of {@link MqSendRtRequestResponse }
     * 
     */
    public MqSendRtRequestResponse createMqSendRtRequestResponse() {
        return new MqSendRtRequestResponse();
    }

    /**
     * Create an instance of {@link MqSendRequestResponse }
     * 
     */
    public MqSendRequestResponse createMqSendRequestResponse() {
        return new MqSendRequestResponse();
    }

    /**
     * Create an instance of {@link Exception }
     * 
     */
    public Exception createException() {
        return new Exception();
    }

    /**
     * Create an instance of {@link MqGetRequestResponse }
     * 
     */
    public MqGetRequestResponse createMqGetRequestResponse() {
        return new MqGetRequestResponse();
    }

    /**
     * Create an instance of {@link MqSendRtRequest }
     * 
     */
    public MqSendRtRequest createMqSendRtRequest() {
        return new MqSendRtRequest();
    }

    /**
     * Create an instance of {@link SendOperateLogResponse }
     * 
     */
    public SendOperateLogResponse createSendOperateLogResponse() {
        return new SendOperateLogResponse();
    }

    /**
     * Create an instance of {@link MgGetRtRequest }
     * 
     */
    public MgGetRtRequest createMgGetRtRequest() {
        return new MgGetRtRequest();
    }

    /**
     * Create an instance of {@link MqGetRequest }
     * 
     */
    public MqGetRequest createMqGetRequest() {
        return new MqGetRequest();
    }

    /**
     * Create an instance of {@link MqSendRequest }
     * 
     */
    public MqSendRequest createMqSendRequest() {
        return new MqSendRequest();
    }

    /**
     * Create an instance of {@link MqGetResponse }
     * 
     */
    public MqGetResponse createMqGetResponse() {
        return new MqGetResponse();
    }

    /**
     * Create an instance of {@link MqSendResponse }
     * 
     */
    public MqSendResponse createMqSendResponse() {
        return new MqSendResponse();
    }

    /**
     * Create an instance of {@link MgGetRtRequestResponse }
     * 
     */
    public MgGetRtRequestResponse createMgGetRtRequestResponse() {
        return new MgGetRtRequestResponse();
    }

    /**
     * Create an instance of {@link MqPassportVo }
     * 
     */
    public MqPassportVo createMqPassportVo() {
        return new MqPassportVo();
    }

    /**
     * Create an instance of {@link MqResponseVo }
     * 
     */
    public MqResponseVo createMqResponseVo() {
        return new MqResponseVo();
    }

    /**
     * Create an instance of {@link MqRequestVo }
     * 
     */
    public MqRequestVo createMqRequestVo() {
        return new MqRequestVo();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MqSendRequestResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.credithc.com/", name = "mqSendRequestResponse")
    public JAXBElement<MqSendRequestResponse> createMqSendRequestResponse(MqSendRequestResponse value) {
        return new JAXBElement<MqSendRequestResponse>(_MqSendRequestResponse_QNAME, MqSendRequestResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Exception }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.credithc.com/", name = "Exception")
    public JAXBElement<Exception> createException(Exception value) {
        return new JAXBElement<Exception>(_Exception_QNAME, Exception.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MqGetResponseResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.credithc.com/", name = "mqGetResponseResponse")
    public JAXBElement<MqGetResponseResponse> createMqGetResponseResponse(MqGetResponseResponse value) {
        return new JAXBElement<MqGetResponseResponse>(_MqGetResponseResponse_QNAME, MqGetResponseResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SendOperateLog }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.credithc.com/", name = "sendOperateLog")
    public JAXBElement<SendOperateLog> createSendOperateLog(SendOperateLog value) {
        return new JAXBElement<SendOperateLog>(_SendOperateLog_QNAME, SendOperateLog.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MqSendRtRequestResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.credithc.com/", name = "mqSendRtRequestResponse")
    public JAXBElement<MqSendRtRequestResponse> createMqSendRtRequestResponse(MqSendRtRequestResponse value) {
        return new JAXBElement<MqSendRtRequestResponse>(_MqSendRtRequestResponse_QNAME, MqSendRtRequestResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MqSendResponseResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.credithc.com/", name = "mqSendResponseResponse")
    public JAXBElement<MqSendResponseResponse> createMqSendResponseResponse(MqSendResponseResponse value) {
        return new JAXBElement<MqSendResponseResponse>(_MqSendResponseResponse_QNAME, MqSendResponseResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MgGetRtRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.credithc.com/", name = "mgGetRtRequest")
    public JAXBElement<MgGetRtRequest> createMgGetRtRequest(MgGetRtRequest value) {
        return new JAXBElement<MgGetRtRequest>(_MgGetRtRequest_QNAME, MgGetRtRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MqGetRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.credithc.com/", name = "mqGetRequest")
    public JAXBElement<MqGetRequest> createMqGetRequest(MqGetRequest value) {
        return new JAXBElement<MqGetRequest>(_MqGetRequest_QNAME, MqGetRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SendOperateLogResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.credithc.com/", name = "sendOperateLogResponse")
    public JAXBElement<SendOperateLogResponse> createSendOperateLogResponse(SendOperateLogResponse value) {
        return new JAXBElement<SendOperateLogResponse>(_SendOperateLogResponse_QNAME, SendOperateLogResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MqSendRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.credithc.com/", name = "mqSendRequest")
    public JAXBElement<MqSendRequest> createMqSendRequest(MqSendRequest value) {
        return new JAXBElement<MqSendRequest>(_MqSendRequest_QNAME, MqSendRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MqGetResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.credithc.com/", name = "mqGetResponse")
    public JAXBElement<MqGetResponse> createMqGetResponse(MqGetResponse value) {
        return new JAXBElement<MqGetResponse>(_MqGetResponse_QNAME, MqGetResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MgGetRtRequestResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.credithc.com/", name = "mgGetRtRequestResponse")
    public JAXBElement<MgGetRtRequestResponse> createMgGetRtRequestResponse(MgGetRtRequestResponse value) {
        return new JAXBElement<MgGetRtRequestResponse>(_MgGetRtRequestResponse_QNAME, MgGetRtRequestResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MqSendResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.credithc.com/", name = "mqSendResponse")
    public JAXBElement<MqSendResponse> createMqSendResponse(MqSendResponse value) {
        return new JAXBElement<MqSendResponse>(_MqSendResponse_QNAME, MqSendResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MqGetRequestResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.credithc.com/", name = "mqGetRequestResponse")
    public JAXBElement<MqGetRequestResponse> createMqGetRequestResponse(MqGetRequestResponse value) {
        return new JAXBElement<MqGetRequestResponse>(_MqGetRequestResponse_QNAME, MqGetRequestResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MqSendRtRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.credithc.com/", name = "mqSendRtRequest")
    public JAXBElement<MqSendRtRequest> createMqSendRtRequest(MqSendRtRequest value) {
        return new JAXBElement<MqSendRtRequest>(_MqSendRtRequest_QNAME, MqSendRtRequest.class, null, value);
    }

}
