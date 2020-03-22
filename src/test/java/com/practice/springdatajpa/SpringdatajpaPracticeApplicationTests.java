package com.practice.springdatajpa;

import com.practice.springdatajpa.entity.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class SpringdatajpaPracticeApplicationTests {

    @Autowired
    private CustomerRepository repository;


    @Test
    public void save(){//fixme 有bug,执行成功但没有插入到db. 当末尾添加查询语句时则插入成功
        repository.save(new Customer("Jack", "Bauer"));
        repository.save(new Customer("Chloe", "O'Brian"));
        repository.save(new Customer("Kim", "Bauer"));
        repository.save(new Customer("David", "Palmer"));
        repository.save(new Customer("Michelle", "Dessler"));

    }

    @Test
    public void find(){
        for (Customer customer : repository.findAll()) {
            System.out.println("customer = " + customer);
        }
        System.out.println(repository.findById(1L));

        repository.findByLastName("Bauer").forEach(System.out::println);
    }
}
