package com.example.webbansach_backend;


import com.example.webbansach_backend.entity.ChiTietDonHang;
import com.example.webbansach_backend.entity.TheLoai;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@SpringBootApplication
public class WebbansachBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebbansachBackendApplication.class, args);
//		TheLoai th = new TheLoai();
//		th.setTenTheLoai("Thanh Sonw");
//		System.out.println("Ten TL : "+th.getTenTheLoai());
		ChiTietDonHang chiTietDonHang = new ChiTietDonHang();

	}

}
