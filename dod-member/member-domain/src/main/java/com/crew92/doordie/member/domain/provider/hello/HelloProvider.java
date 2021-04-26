package com.crew92.doordie.member.domain.provider.hello;

import com.crew92.doordie.member.meta.HelloMeta;
import org.springframework.stereotype.Component;

import static com.crew92.doordie.member.meta.HelloMeta.HELLO;

@Component
public class HelloProvider {

    public HelloMeta getHello() {
        return HELLO;
    }

}
