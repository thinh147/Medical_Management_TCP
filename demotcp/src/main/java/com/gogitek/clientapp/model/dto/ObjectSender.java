package com.gogitek.clientapp.model.dto;

public class ObjectSender {
    private Object object;
    private Action action;
    private ModelSender modelSender;

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

    public ModelSender getModelSender() {
        return modelSender;
    }

    public void setModelSender(ModelSender modelSender) {
        this.modelSender = modelSender;
    }
}