package object;

public class BienBao {
    private String SoHieu, TenBienBao, NoiDung;
    private int HinhAnh;

    public BienBao(String soHieu, String tenBienBao, String noiDung, int hinhAnh) {
        SoHieu = soHieu;
        TenBienBao = tenBienBao;
        NoiDung = noiDung;
        HinhAnh = hinhAnh;
    }

    public BienBao() {
        SoHieu = null;
        HinhAnh = 0;
        TenBienBao = null;
        NoiDung = null;
    }

    public String getSoHieu() {
        return SoHieu;
    }

    public void setSoHieu(String soHieu) {
        SoHieu = soHieu;
    }

    public String getTenBienBao() {
        return TenBienBao;
    }

    public void setTenBienBao(String tenBienBao) {
        TenBienBao = tenBienBao;
    }

    public String getNoiDung() {
        return NoiDung;
    }

    public void setNoiDung(String noiDung) {
        NoiDung = noiDung;
    }

    public int getHinhAnh() {
        return HinhAnh;
    }

    public void setHinhAnh(int hinhAnh) {
        HinhAnh = hinhAnh;
    }
}
