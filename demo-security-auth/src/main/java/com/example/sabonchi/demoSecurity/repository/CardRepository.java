package com.example.sabonchi.demoSecurity.repository;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import com.example.sabonchi.demoSecurity.entity.Card;

@Repository
public interface CardRepository extends ListCrudRepository <Card, Long>{

}
