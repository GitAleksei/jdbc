package ru.netology.jdbc.service;

import org.springframework.stereotype.Service;
import ru.netology.jdbc.repository.JDBCRepository;

import java.util.List;

@Service
public class JDBCService {
    private final JDBCRepository jdbcRepository;

    public JDBCService(JDBCRepository jdbcRepository) {
        this.jdbcRepository = jdbcRepository;
    }

    public List<String> getProductName(String name) {
        return jdbcRepository.getProductName(name);
    }
}
