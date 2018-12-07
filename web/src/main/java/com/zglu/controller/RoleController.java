package com.zglu.controller;

import com.zglu.service.RoleApi;
import com.zglu.utils.AmapApi;
import com.zglu.vo.RoleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleController {
    @Autowired
    private RoleApi roleApi;
    @Autowired
    private AmapApi amapApi;

    @ResponseBody
    @GetMapping(value = "/role/{id}")
    public RoleVo get(@PathVariable int id){
        return roleApi.get(id);
    }

    @ResponseBody
    @GetMapping(value = "/test1")
    public String test1(){
        return amapApi.geo("南宁饭店");
    }

}