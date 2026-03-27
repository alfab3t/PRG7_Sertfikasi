package id.co.prg7_sertfikasi.constant;

import id.co.prg7_sertfikasi.model.Prodi;

import java.util.ArrayList;
import java.util.List;

public class ProdiConstant {

    public static List<Prodi> prodis;

    static {
        prodis = new ArrayList<>();
        prodis.add(new Prodi(1, "Teknik Informatika", "TI", "Teknik", 1));
        prodis.add(new Prodi(2, "Sistem Informasi", "SI", "Teknik", 1));
    }

    public static final String mNotFound = "Prodi not found";
    public static final String mCreateSuccess = "Prodi created successfully";
    public static final String mUpdateSuccess = "Prodi updated successfully";
    public static final String mDeleteSuccess = "Prodi deleted successfully";
}
