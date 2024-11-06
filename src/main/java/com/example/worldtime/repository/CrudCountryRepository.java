package com.example.worldtime.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.worldtime.entity.Country;
public interface CrudCountryRepository extends CrudRepository<Country,Long>{
    //このinterfaceを使用しているメソッド　getAllCountry addCountry
}