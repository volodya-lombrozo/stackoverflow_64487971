package com.example.pp;


import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
