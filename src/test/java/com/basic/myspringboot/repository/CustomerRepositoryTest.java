package com.basic.myspringboot.repository;

import com.basic.myspringboot.entity.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class CustomerRepositoryTest {
    @Autowired
    CustomerRepository repository;
    
    @Test
    void insertSelectCustomer() {
        Customer customer = new Customer();
        customer.setCustomerId("A001");
        customer.setCustomerName("스프링");
        //CrudRepository save() 호출해서 Insert 하기
        Customer saveCustomer = repository.save(customer);
        assertThat(saveCustomer).isNotNull();
        assertThat(saveCustomer.getCustomerName()).isEqualTo("스프링");
        assertEquals("A001",saveCustomer.getCustomerId());
    }
}