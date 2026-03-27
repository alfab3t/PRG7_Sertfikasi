package id.co.prg7_sertfikasi.vo;

import id.co.prg7_sertfikasi.model.User;

public class UserVo {
    private int id;
    private String nama;
    private String username;
    private String email;
    private String role;

    public UserVo() {
    }

    public UserVo(User user) {
        this.id = user.getId();
        this.nama = user.getNama();
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.role = user.getRole();
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
}
