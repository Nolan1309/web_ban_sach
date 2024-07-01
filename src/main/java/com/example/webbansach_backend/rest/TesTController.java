package com.example.webbansach_backend.rest;

import com.example.webbansach_backend.dao.ChiTietDonHangRepository;
import com.example.webbansach_backend.entity.ChiTietDonHang;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TesTController {

    ChiTietDonHangRepository chiTietDonHangRepositoryl;

    @Autowired
    public TesTController(ChiTietDonHangRepository chiTietDonHangRepositoryl) {
        this.chiTietDonHangRepositoryl = chiTietDonHangRepositoryl;
    }

    //demo
    @GetMapping("/")
    public void test() {
        ChiTietDonHang chiTietDonHang = new ChiTietDonHang();
        chiTietDonHangRepositoryl.delete(chiTietDonHang);
    }
}
