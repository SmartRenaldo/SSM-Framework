package com.x.service;

import com.x.exception.MyException;

import java.io.FileNotFoundException;

/**
 * @author Gavin
 */
public interface DemoService {

    void show1();

    void show2();

    void show3() throws FileNotFoundException;

    void show4();

    void show5() throws MyException;
}
