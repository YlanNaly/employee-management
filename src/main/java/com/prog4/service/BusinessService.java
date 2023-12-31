package com.prog4.service;

import com.prog4.entity.Business;
import com.prog4.repository.BusinessRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class BusinessService {
    private final BusinessRepository repository;
    public Business findById(Long id){
        Optional<Business> optionalBusiness = repository.findById(id);

        return optionalBusiness.orElseThrow(()->new RuntimeException("no business with id " +id+ " found"));
    }
    public Business save(Business business){
        repository.save(business);
        return this.findById(business.getId());
    }
}
