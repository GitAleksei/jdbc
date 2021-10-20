package ru.netology.jdbc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.jdbc.service.JDBCService;

import java.util.List;

@RestController
public class JDBCController {
    private final JDBCService jdbcService;

    public JDBCController(JDBCService jdbcService) {
        this.jdbcService = jdbcService;
    }

    @GetMapping("/products/fetch-products")
    public List<String> getProductName(@RequestParam(name = "name") String name) {
        System.out.println(name);
        return jdbcService.getProductName(name);
    }
}
