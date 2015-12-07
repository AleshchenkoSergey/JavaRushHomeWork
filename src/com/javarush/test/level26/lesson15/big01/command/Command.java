package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.io.IOException;

/**
 * Created by sergey on 19.09.15.
 */
interface Command {
    public void execute() throws InterruptOperationException;
}
