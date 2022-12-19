package com.rapidtech.springdasar.config;

import com.rapidtech.springdasar.model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

class DependencyInjectionTest {
    private static ApplicationContext context;
    @BeforeEach
    void setUp() {
        context = new AnnotationConfigApplicationContext(DependencyInjection.class);
    }

    @Test
    void dependencyTest() {
        Foo foo = context.getBean(Foo.class);
        Foo foo1 = context.getBean("fooFirst",Foo.class);
        Foo foo2 = context.getBean("fooSecond",Foo.class);
        Bar bar = context.getBean(Bar.class);
        FooBar fooBar = context.getBean(FooBar.class);

        Assertions.assertNotSame(foo, fooBar.getFoo());
        Assertions.assertNotSame(foo1, fooBar.getFoo());
        Assertions.assertSame(foo2, fooBar.getFoo());
        Assertions.assertSame(bar, fooBar.getBar());
    }
}