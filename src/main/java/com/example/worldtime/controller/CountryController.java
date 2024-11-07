package com.example.worldtime.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.example.worldtime.entity.Country;
import com.example.worldtime.service.CountryService;

import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CountryController {

    @Autowired
    private CountryService countryService;

    // ランダムに一つの国を取得して表示する。
    @GetMapping("/")
    public String index(Model model) {
        Country country = countryService.getRamdomCountry();
        model.addAttribute("country", country);
        return "index";
    }

    // 管理者画面の表示
    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }

    // 管理者 画面国一覧の表示 list.html
    @GetMapping("/admin/countrylist")
    public String getMethodName(Model model) {
        List<Country> country = countryService.getAllCountry();
        model.addAttribute("country", country);
        return "list";
    }

    // 管理者 国の削除 list.htmlのページで削除する
    @PostMapping("/remove")
    public String remove(@RequestParam("id") long id) {
        countryService.removeCountry(id);
        return "admin";
    }

    // 管理者 国情報の追加ページ表示 addCounry.html
    @GetMapping("/admin/addCountry")
    public String viewaddcountry() {
        return "addCountry";
    }

    // 管理者 国情報の追加
    @PostMapping("/addCountry")
    public void addCountry(@ModelAttribute Country country, HttpSession session) {
        Object sessionId = session.getAttribute("id");
        if (sessionId != null) {
            country.setId((Long) sessionId);
        }
        countryService.addCountry(country);
    }

    // 編集画面へ遷移 国追加と同じ画面に遷移して、そこで文字を入力すると更新される。※使い勝手が悪い
    @PostMapping("/editing")
    public String editingCountry(@RequestParam("id") long id, HttpSession session) {
        session.setAttribute("id", id);
        return "addcountry";
    }

}
