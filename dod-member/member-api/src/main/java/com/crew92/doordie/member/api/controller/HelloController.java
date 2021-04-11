package com.crew92.doordie.member.api.controller;

import com.crew92.doordie.member.domain.provider.HelloProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HelloController {

    private final HelloProvider helloProvider;

    @GetMapping("/hello")
    public String hello() {
        return "hello. member-api";
    }

    @GetMapping("/helloMeta")
    public String helloMeta() {
        return helloProvider.getHello().toString();
    }

}
