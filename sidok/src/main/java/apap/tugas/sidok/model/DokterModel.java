package apap.tugas.sidok.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="dokter")
public class DokterModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 50)
    @Column(name = "nama", nullable = false, columnDefinition = "VARCHAR(255)")
    private String nama;

    @NotNull
    @Size(max = 16)
    @Column(name = "nip", nullable = false, columnDefinition = "VARCHAR(255)")
    private String nip;

    @NotNull
    @Size(max = 13)
    @Column(name = "nik", nullable = false, columnDefinition = "VARCHAR(255)")
    private String nik;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "tanggal_lahir", nullable = false)
    private Date tanggal_lahir;

    @NotNull
    @Size(max = 50)
    @Column(name = "tempat_lahir", nullable = false, columnDefinition = "VARCHAR(255)")
    private String tempat_lahir;

    @NotNull
    @Column(name = "jenis_kelamin", nullable = false)
    private Integer jenis_kelamin;

    @OneToMany(mappedBy = "dokter", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<SpesialisasiDokterModel> listSpesialisasiDokter;

    @OneToMany(mappedBy = "dokter", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<JadwalJagaModel> listJadwalJaga;

    public List<SpesialisasiDokterModel> getListSpesialisasiDokter() {
        return listSpesialisasiDokter;
    }

    public void setListSpesialisasiDokter(List<SpesialisasiDokterModel> listSpesialisasiDokter) {
        this.listSpesialisasiDokter = listSpesialisasiDokter;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public List<JadwalJagaModel> getListJadwalJaga() {
        return listJadwalJaga;
    }

    public void setListJadwalJaga(List<JadwalJagaModel> listJadwalJaga) {
        this.listJadwalJaga = listJadwalJaga;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public Date getTanggal_lahir() {
        return tanggal_lahir;
    }

    public void setTanggal_lahir(Date tanggal_lahir) {
        this.tanggal_lahir = tanggal_lahir;
    }

    public String getTempat_lahir() {
        return tempat_lahir;
    }

    public void setTempat_lahir(String tempat_lahir) {
        this.tempat_lahir = tempat_lahir;
    }

    public Integer getJenis_kelamin() {
        return jenis_kelamin;
    }

    public void setJenis_kelamin(Integer jenis_kelamin) {
        this.jenis_kelamin = jenis_kelamin;
    }
}
