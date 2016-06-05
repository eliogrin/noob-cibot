package com.github.eliogrin;

import org.springframework.stereotype.Component;

@Component("MyTask")
public class TaskExample {

    public static int index = 0;

    public static void doSmth() {
        index++;
    }

    public static int getIndex() {
        return index;
    }
}
