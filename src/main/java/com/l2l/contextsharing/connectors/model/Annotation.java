package com.l2l.contextsharing.connectors.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.*;

public class Annotation {
    public String id = UUID.randomUUID().toString();
    public String name;
    public String pointcutType;
    public String implementationType;
    public String destination;
    public String handler;//可以去除？
    public String script;//可以去除？
    public String processDefinitionId;
    public String targetElementId;
    public String policy;
    public Map<String,Object> awsVariables = new HashMap<>();//map
    public Map<String,Object> processVariables = new HashMap<>();
    public String iftttRules;
    public String IOThub;
    public String Topic;
    public Map<String,Object> executionvars = new HashMap<>();

    @Override
    public String toString() {
        return "Annotation{" +
            "id='" + id + '\'' +
            ", name='" + name + '\'' +
            ", pointcutType='" + pointcutType + '\'' +
            ", implementationType='" + implementationType + '\'' +
            ", destination='" + destination + '\'' +
            ", handler='" + handler + '\'' +
            ", script='" + script + '\'' +
            ", processDefinitionId='" + processDefinitionId + '\'' +
            ", targetElementId='" + targetElementId + '\'' +
            ", policy='" + policy + '\'' +
            ", awsVariables=" + awsVariablestoString() +
            ", processVariables=" + processVariablestoString() +
            ", iftttRules='" + iftttRules + '\'' +
            ", IOThub='" + IOThub + '\'' +
            ", Topic='" + Topic + '\'' +
            '}';
    }

    public Annotation(){

    }

    public Map<String, Object> getExecutionvars() {
        return executionvars;
    }

    public void setExecutionvars(Map<String, Object> executionvars) {
        this.executionvars = executionvars;
    }

    public String getTopic() {
        return Topic;
    }

    public void setTopic(String topic) {
        Topic = topic;
    }

    public String awsVariablestoString(){
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<String, Object> entry : this.getAwsVariables().entrySet()) {
            builder.append(entry.getKey()+":"+entry.getValue()+",");//可能需要更加复杂的转化方式
        }
        builder.deleteCharAt(builder.length()-1);
        builder.append(".");
        return String.valueOf(builder);
    }
    public String processVariablestoString(){
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<String, Object> entry : this.getProcessVariables().entrySet()) {
            builder.append(entry.getKey()+":"+entry.getValue()+",");
        }
        builder.deleteCharAt(builder.length()-1);
        builder.append(".");
        return String.valueOf(builder);
    }

    public String getIOThub() {
        return IOThub;
    }

    public void setIOThub(String IOThub) {
        this.IOThub = IOThub;
    }

    public String getIftttRules() {
        return iftttRules;
    }

    public void setIftttRules(String iftttRules) {
        this.iftttRules = iftttRules;
    }

    public String getPolicy() {
        return policy;
    }

    public void setPolicy(String policy) {
        this.policy = policy;
    }

    public Map<String, Object> getAwsVariables() {
        return awsVariables;
    }

    public void setAwsVariables(Map<String, Object> awsVariables) {
        this.awsVariables = awsVariables;
    }

    public Map<String, Object> getProcessVariables() {
        return processVariables;
    }

    public void setProcessVariables(Map<String, Object> processVariables) {
        this.processVariables = processVariables;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPointcutType() {
        return pointcutType;
    }

    public void setPointcutType(String pointcutType) {
        this.pointcutType = pointcutType;
    }

    public String getTargetElementId() {
        return targetElementId;
    }

    public void setTargetElementId(String targetElementId) {
        this.targetElementId = targetElementId;
    }

    public String getImplementationType() {
        return implementationType;
    }

    public void setImplementationType(String implementationType) {
        this.implementationType = implementationType;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getScript() {
        return script;
    }

    public void setScript(String script) {
        this.script = script;
    }

    public Annotation(String handler) {
        this.handler = handler;
    }

    public String getHandler() {
        return handler;
    }

    public void setHandler(String handler) {
        this.handler = handler;
    }

    public String getProcessDefinitionId() {
        return processDefinitionId;
    }

    public void setProcessDefinitionId(String processDefinitionId) {
        this.processDefinitionId = processDefinitionId;
    }
}
