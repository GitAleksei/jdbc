package ru.netology.jdbc.repository;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class JDBCRepository {
    private String myScript;

    @PersistenceContext
    private final EntityManager entityManager;

    public JDBCRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.myScript = read("myScript.sql");
    }

    private static String read(String scriptFileName) {
        try (InputStream is = new ClassPathResource(scriptFileName).getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<String> getProductName(String name) {
        return entityManager.createQuery(myScript, String.class)
                .setParameter("name", name)
                .getResultList();
    }
}
