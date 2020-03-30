package com.jjw.springboot.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/swagger")
public class Swagger2Controller {

    @ApiOperation(value = "获取用户信息", notes = "根据用户id获取用户信息")
    @ApiImplicitParam(name = "id", value = "用户id", required = true, dataType = "int")
    @GetMapping(value = "/{id}")
    public Map<String, String> getInfo() {
        Map<String, String> map = new HashMap();
        map.put("name", "jjw");
        map.put("age", "18");
        return map;
    }

}
