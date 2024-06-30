package com.example.webbansach_backend.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "hinh_anh")
public class HinhAnh {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_hinh_anh")
    private int maHinhAnh;
    @Column(name = "ten_hinh_anh", length = 255)
    private String tenHinhAnh;
    @Column(name = "la_icon")
    private boolean laIcon;

    @Column(name = "duong_dan")
    private String duongDan;
    @Column(name = "du_lieu_anh")
    @Lob
    private String duLieuAnh;

    //Xóa 1 hinhanh , ko được xóa sách, HinhAnh ton tai thi phai ton tai
    // cho cuon Sach nao -> nullable = false
    @ManyToOne(fetch = FetchType.LAZY
            , cascade = {
            CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH
    })
    @JoinColumn(name = "ma_sach", nullable = false) //
    private Sach sach;
}
