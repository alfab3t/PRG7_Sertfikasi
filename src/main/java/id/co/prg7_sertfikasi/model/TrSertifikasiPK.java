package id.co.prg7_sertfikasi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class TrSertifikasiPK implements Serializable {

    @Column(name = "tsk_id")
    private Integer tsk_id;

    @Column(name = "usr_id")
    private Integer usr_id;

    @Column(name = "dsk_id")
    private Integer dsk_id;

    public TrSertifikasiPK() {}

    public TrSertifikasiPK(Integer tsk_id, Integer usr_id, Integer dsk_id) {
        this.tsk_id = tsk_id;
        this.usr_id = usr_id;
        this.dsk_id = dsk_id;
    }

    public Integer getTsk_id() { return tsk_id; }
    public void setTsk_id(Integer tsk_id) { this.tsk_id = tsk_id; }

    public Integer getUsr_id() { return usr_id; }
    public void setUsr_id(Integer usr_id) { this.usr_id = usr_id; }

    public Integer getDsk_id() { return dsk_id; }
    public void setDsk_id(Integer dsk_id) { this.dsk_id = dsk_id; }
}
