package com.example.pp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository repository;

    @Autowired
    private EntityManager manager;

    @Test
    void persistTest() throws Exception {
        Customer customer = new Customer();

        repository.save(customer);
        manager.clear();
        repository.save(customer);

        Customer afterSelect = repository.findById(customer.getId()).orElseThrow(Exception::new);
        long id = afterSelect.getId();
        assertTrue(id > 0);
        assertEquals(String.valueOf(id), afterSelect.getCode());
    }


}
