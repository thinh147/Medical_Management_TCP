package com.gogitek.clientweb.entity.dto;


import java.io.Serializable;

public class ObjectSender implements Serializable {
    private Object object;
    private Action action;
    private ModelReceiver modelReceiver;

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public ModelReceiver getModelReceiver() {
        return modelReceiver;
    }

    public void setModelReceiver(ModelReceiver modelReceiver) {
        this.modelReceiver = modelReceiver;
    }
}
