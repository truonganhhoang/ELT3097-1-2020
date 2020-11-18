package nhom6.com.duoihinhbatchu.model;

public class Question {
    private String dapAn;
    private String goiY;
    private String ketQua;
    private String fileName;
    private String cauHoi;

    public Question(String dapAn, String goiY, String ketQua, String fileName, String cauHoi) {
        this.dapAn = dapAn;
        this.goiY = goiY;
        this.ketQua = ketQua;
        this.fileName = fileName;
        this.cauHoi = cauHoi;
    }

    public Question(String dapAn, String goiY, String ketQua, String fileName) {
        this.dapAn = dapAn;
        this.goiY = goiY;
        this.ketQua = ketQua;
        this.fileName = fileName;
    }

    public String getDapAn() {
        return dapAn;
    }

    public void setDapAn(String dapAn) {
        this.dapAn = dapAn;
    }

    public String getGoiY() {
        return goiY;
    }

    public void setGoiY(String goiY) {
        this.goiY = goiY;
    }

    public String getKetQua() {
        return ketQua;
    }

    public void setKetQua(String ketQua) {
        this.ketQua = ketQua;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getCauHoi() {
        return cauHoi;
    }

    public void setCauHoi(String cauHoi) {
        this.cauHoi = cauHoi;
    }
}
