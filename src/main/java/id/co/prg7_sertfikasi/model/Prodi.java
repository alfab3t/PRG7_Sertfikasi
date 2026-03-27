package id.co.prg7_sertfikasi.model;

public class Prodi {
    private int id;
    private String prodi;
    private String singkatan;
    private String jurusan;
    private int status;

    public Prodi() {}

    public Prodi(int id, String prodi, String singkatan, String jurusan, int status) {
        this.id = id;
        this.prodi = prodi;
        this.singkatan = singkatan;
        this.jurusan = jurusan;
        this.status = status;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getProdi() { return prodi; }
    public void setProdi(String prodi) { this.prodi = prodi; }

    public String getSingkatan() { return singkatan; }
    public void setSingkatan(String singkatan) { this.singkatan = singkatan; }

    public String getJurusan() { return jurusan; }
    public void setJurusan(String jurusan) { this.jurusan = jurusan; }

    public int getStatus() { return status; }
    public void setStatus(int status) { this.status = status; }
}
