package com.example.worldtime.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.worldtime.entity.Country;

@Repository
public class CountryRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate; // crudrepositoryで再現の仕方がよくわからないやつをjdbctemprlateで代用してる

    public Country getRamdomCountry() {
        String sql = "SELECT * FROM country ORDER BY RANDOM() LIMIT 1"; // ランダムな国を取得
        return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
            Country country = new Country();
            country.setId(rs.getLong("id"));
            country.setName(rs.getString("name"));
            country.setLocalTime(rs.getInt("local_time"));
            country.setNationalFlag(rs.getString("national_flag"));
            country.setMap(rs.getString("map"));
            country.setArea(rs.getInt("area"));
            country.setPopulation(rs.getInt("population"));
            country.setCaptial(rs.getString("captial"));
            country.setCaptialImg(rs.getString("captial_Img"));
            country.setGoods(rs.getString("goods"));
            country.setGoodsImg(rs.getString("goods_Img"));
            country.setOverview(rs.getString("overview"));
            country.setTrivia(rs.getString("trivia"));
            return country;
        });
    }

    public List<Country> getAllCountry() {
        String sql = "SELECT * FROM country"; // すべての国を取得
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Country country = new Country();
            country.setId(rs.getLong("id"));
            country.setName(rs.getString("name"));
            country.setLocalTime(rs.getInt("local_time"));
            country.setNationalFlag(rs.getString("national_flag"));
            country.setMap(rs.getString("map"));
            country.setArea(rs.getInt("area"));
            country.setPopulation(rs.getInt("population"));
            country.setCaptial(rs.getString("captial"));
            country.setCaptialImg(rs.getString("captial_Img"));
            country.setGoods(rs.getString("goods"));
            country.setGoodsImg(rs.getString("goods_Img"));
            country.setOverview(rs.getString("overview"));
            country.setTrivia(rs.getString("trivia"));
            return country;
        });
    }
}
