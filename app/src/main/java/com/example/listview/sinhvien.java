package com.example.listview;

public class sinhvien {
    int avatar;
    String tenSinhVien;
    String sdtSinhVien;

    public sinhvien() {
    }

    public sinhvien(int avatar, String tenSinhVien, String sdtSinhVien) {
        this.avatar = avatar;
        this.tenSinhVien = tenSinhVien;
        this.sdtSinhVien = sdtSinhVien;
    }

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }

    public String getTenSinhVien() {
        return tenSinhVien;
    }

    public void setTenSinhVien(String tenSinhVien) {
        this.tenSinhVien = tenSinhVien;
    }

    public String getSdtSinhVien() {
        return sdtSinhVien;
    }

    public void setSdtSinhVien(String sdtSinhVien) {
        this.sdtSinhVien = sdtSinhVien;
    }

}
