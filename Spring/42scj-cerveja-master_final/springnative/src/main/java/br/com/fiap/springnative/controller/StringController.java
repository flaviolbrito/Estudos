package br.com.fiap.springnative.controller;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("strings")
public class StringController {

    @GetMapping("reverter")
    public String reverter(@RequestParam String palavra){
        return new StringBuilder(palavra).reverse().toString();
    }

}
