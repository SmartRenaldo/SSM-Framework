package com.x.anno;

import org.springframework.stereotype.Component;

/**
 * @author Gavin
 */
@Component("target")
public class Target implements TargetInterface {
    @Override
    public void save() {
        System.out.println("save running...");
        int i = 1 / 0;
    }
}
