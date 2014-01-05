package com.crg.oe;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;


public class HelloWorldTest {
    private HelloWorld helloWorld;
    private String greeting;

    @Test
    public void saysHello() {
        helloWorld = new HelloWorld();
        greeting = helloWorld.say();
        
        assertThat(greeting, is("Hello, World"));
    }

}
