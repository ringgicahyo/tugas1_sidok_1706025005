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
public class DokterModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 20)
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
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    @Column(name = "tanggal_lahir", nullable = false)
    private Date tanggal_lahir;

    @NotNull
    @Size(max = 20)
    @Column(name = "tempat_lahir", nullable = false, columnDefinition = "VARCHAR(255)")
    private String tempat_lahir;

    @NotNull
    @Column(name = "jenis_kelamin", nullable = false)
    private Integer jenis_kelamin;

    //@ManyToMany(mappedBy = "listDokter", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
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
