package com.crew92.doordie.content.domain.provider.hello;

import static com.crew92.doordie.content.meta.HelloMeta.HELLO;

import com.crew92.doordie.content.meta.HelloMeta;
import org.springframework.stereotype.Component;

@Component
public class HelloProvider {

    public HelloMeta getHello() {
        return HELLO;
    }

}
