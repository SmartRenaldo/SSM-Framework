package com.x.proxy.jdk;

/**
 * @author Gavin
 */
public class Target implements TargetInterface {
    @Override
    public void save() {
        System.out.println("save running...");
    }
}
