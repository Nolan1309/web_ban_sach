package com.example.webbansach_backend.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "sach")
public class Sach {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_sach")
    private int maSach;
    @Column(name = "ten_sach", length = 255)
    private String tenSach;
    @Column(name = "ten_tac_gia", length = 255)
    private String tenTacGia;
    @Column(name = "isbn", length = 255)
    private String ISBN;
    @Column(name = "mo_ta", columnDefinition = "text")
    private String moTa;
    @Column(name = "gia_niem_yet")
    private double giaNiemYet;
    @Column(name = "gia_ban")
    private double giaBan;
    @Column(name = "so_luong")
    private int soLuong;
    @Column(name = "trung_binh_xep_hang")
    private double trungBinhXepHang;

    //Xoá đi 1 thể loại , k xóa sách
    // Xóa đi 1 cuốn sách , k xóa đi thể loại
    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.DETACH, CascadeType.MERGE,
                    CascadeType.PERSIST, CascadeType.REFRESH
            }
    )
    @JoinTable(name = "sach_theloai",
            joinColumns = @JoinColumn(name = "ma_sach"),
            inverseJoinColumns = @JoinColumn(name = "ma_the_loai")
    )
    List<TheLoai> danhSachTheLoai;


    //Xóa 1 sách , thì phải xóa đi HinhAnh
    @OneToMany(mappedBy = "sach",
            fetch = FetchType.LAZY
            , cascade = {
            CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.REMOVE
    })
    List<HinhAnh> danhSachHinhAnh;

    @OneToMany(mappedBy = "sach",
            fetch = FetchType.LAZY
            , cascade = {
            CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.REMOVE
    })
    List<SuDanhGia> danhSachSuDanhGia;


    //Xoa sanpham ko duoc xoa di sanpham trong chitietdonhang
    // Vi DoanhThu se khong dung
    @OneToMany(mappedBy = "sach",
            fetch = FetchType.LAZY
            , cascade = {
            CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH
    })
    List<ChiTietDonHang> danhSachChiTietDonHang;

    @OneToMany(mappedBy = "sach",
            fetch = FetchType.LAZY
            , cascade = {
            CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.REMOVE
    })
    List<SachYeuThich> danhSachSachYeuThich;

}
