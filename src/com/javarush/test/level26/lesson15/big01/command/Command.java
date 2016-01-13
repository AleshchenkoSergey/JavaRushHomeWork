package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

/**
 * Created by sergey on 07.12.15.
 */
public interface Command {
    public void execute() throws InterruptOperationException;
}
