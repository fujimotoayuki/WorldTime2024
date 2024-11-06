package com.example.worldtime.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.worldtime.entity.Country;
import com.example.worldtime.repository.CountryRepository;
import com.example.worldtime.repository.CrudCountryRepository;

@Service
public class CountryService {
    @Autowired
    private CountryRepository countryRepository;
    @Autowired
    private CrudCountryRepository crudCountryRepository;

    public Country getRamdomCountry(){ //画面にランダムな国を取得して表示する jdbc
        return  countryRepository.getRamdomCountry();      
    }

    public List<Country> getAllCountry(){//すべての国を獲得してるはず jdbc
        return countryRepository.getAllCountry();
    }

    public void removeCountry(long id){//指定したidの国を削除　crud
        crudCountryRepository.deleteById(id);
    }

    public void addCountry(Country country) {//新しく国を追加 crud
        crudCountryRepository.save(country); 
    }


}
