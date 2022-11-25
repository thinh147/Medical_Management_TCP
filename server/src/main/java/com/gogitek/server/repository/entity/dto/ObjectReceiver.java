/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gogitek.server.repository.entity.dto;

import java.io.Serializable;

/**
 *
 * @author bmtnt
 */
public class ObjectReceiver implements Serializable {
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
