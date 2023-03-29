package object;

public class LyThuyetBienBao {
    private String CauHoi;
    private String DapAn1, DapAn2, DapAn3, DapAnDung;
    private int HinhAnh;

    public LyThuyetBienBao(String cauHoi, String dapAn1, String dapAn2, String dapAn3, String dapAnDung, int hinhAnh) {
        this.CauHoi = cauHoi;
        this.DapAn1 = dapAn1;
        this.DapAn2 = dapAn2;
        this.DapAn3 = dapAn3;
        this.DapAnDung = dapAnDung;
        HinhAnh = hinhAnh;
    }

    public String getCauHoi() {
        return CauHoi;
    }

    public void setCauHoi(String cauHoi) {
        CauHoi = cauHoi;
    }

    public String getDapAn1() {
        return DapAn1;
    }

    public void setDapAn1(String dapAn1) {
        DapAn1 = dapAn1;
    }

    public String getDapAn2() {
        return DapAn2;
    }

    public void setDapAn2(String dapAn2) {
        DapAn2 = dapAn2;
    }

    public String getDapAn3() {
        return DapAn3;
    }

    public void setDapAn3(String dapAn3) {
        DapAn3 = dapAn3;
    }

    public String getDapAnDung() {
        return DapAnDung;
    }

    public void setDapAnDung(String dapAnDung) {
        DapAnDung = dapAnDung;
    }

    public int getHinhAnh() {
        return HinhAnh;
    }

    public void setHinhAnh(int hinhAnh) {
        HinhAnh = hinhAnh;
    }

    public LyThuyetBienBao() {
    }
}
