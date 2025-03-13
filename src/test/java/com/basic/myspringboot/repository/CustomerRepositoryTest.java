package com.basic.myspringboot.repository;

import com.basic.myspringboot.entity.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class CustomerRepositoryTest {
    @Autowired
    CustomerRepository repository;
    
    @Test
    //value=false 이면 rollback 처리 되지 않음
    @Rollback(value = false)
    void insertSelectCustomer() {
        Customer customer = new Customer();
        customer.setCustomerId("A001");
        customer.setCustomerName("스프링");
        //CrudRepository save() 호출해서 Insert 하기
        Customer saveCustomer = repository.save(customer);
        assertThat(saveCustomer).isNotNull();
        assertThat(saveCustomer.getCustomerName()).isEqualTo("스프링");
        assertEquals("A001",saveCustomer.getCustomerId());

        //PK로 조회하기
        Optional<Customer> optionalById = repository.findById(1L);
        if(optionalById.isPresent()){
            Customer existCustomer = optionalById.get();
            assertThat(existCustomer.getCustomerName()).isEqualTo("스프링");
        }

    }
}