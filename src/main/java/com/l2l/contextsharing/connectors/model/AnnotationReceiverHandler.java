package com.l2l.contextsharing.connectors.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.l2l.contextsharing.aws.bean.AnnotationIntegrationRequestManager;
import com.l2l.contextsharing.aws.bean.awsClient;
import com.l2l.contextsharing.connectors.annotatoionDomain.AnnotationIntegrationRequestImpl;
import com.l2l.contextsharing.connectors.annotatoionDomain.AnnotationIntegrationResultImpl;
import com.l2l.contextsharing.connectors.channels.AnnotationMessageChannels;
import com.l2l.contextsharing.connectors.configuration.ConnectorProperties;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Component
@EnableBinding(AnnotationMessageChannels.class)
public class AnnotationReceiverHandler {
    private final IntegrationResultSender integrationResultSender;
    private static org.slf4j.Logger log = LoggerFactory.getLogger(AnnotationReceiverHandler.class);
    @Autowired
    private ObjectMapper mapper;
    @Autowired
    private ConnectorProperties connectorProperties;
    @Autowired
    public awsClient client;
    @Autowired
    public AnnotationIntegrationRequestManager annotationIntegrationRequestManager;
    public AnnotationReceiverHandler(IntegrationResultSender integrationResultSender) {
        this.integrationResultSender = integrationResultSender;
    }

    @StreamListener(value = AnnotationMessageChannels.ANNOTAION_CONSUMER)
    public void rewardTopRankedUsers(AnnotationIntegrationRequestImpl event) {
        // business logic goes here
        AnnotationIntegrationRequestImpl tv = null;
        if(event instanceof AnnotationIntegrationRequestImpl) {
            tv = (AnnotationIntegrationRequestImpl)event;
            log.debug(tv.getAppName());
        }//publish to aws uuid作为map的key 并在annotation中扩展这一个属性
        //iftt处理  将没有的变量向aws发布获取消息 处理完毕
        Annotation annotation = event.getAnnotationIntergrationContext().getAnnotation();
        String annkey = annotation.getId();
        annotationIntegrationRequestManager.getAnnotationIntegrationRequestMap().put(annkey,event);
        client.publish("arn:aws-cn:sns:cn-northwest-1:148543509440:context-sharing-output-channel", annotation.toString());

        //  build and send result back 这部分转移到 recevie http中
//        Map<String, Object> results = new HashMap<>();
//        results.put("rewards", "test");
//        Message<AnnotationIntegrationResultImpl> message = AnnotationIntegrationResultBuilder.resultFor(event,
//            connectorProperties)
//            .withOutboundVariables(results)
//            .buildMessage();
//        integrationResultSender.send(message);
    }
}
