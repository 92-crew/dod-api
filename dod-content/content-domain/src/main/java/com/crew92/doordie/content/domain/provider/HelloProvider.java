package com.crew92.doordie.content.domain.provider;

import com.crew92.doordie.content.meta.HelloMeta;
import org.springframework.stereotype.Component;

import static com.crew92.doordie.content.meta.HelloMeta.HELLO;

@Component
public class HelloProvider {

    public HelloMeta getHello() {
        return HELLO;
    }

}