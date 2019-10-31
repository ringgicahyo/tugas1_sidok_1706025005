package apap.tugas.sidok.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "spesialisasi")
public class SpesialisasiModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 20)
    @Column(name = "nama", nullable = false, columnDefinition = "VARCHAR(255)")
    private String nama;

    @NotNull
    @Size(max = 20)
    @Column(name = "gelar", nullable = false, columnDefinition = "VARCHAR(255)")
    private String gelar;

    @OneToMany(mappedBy = "spesialisasi", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<SpesialisasiDokterModel> listSpesialisasiDokter;

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

    public String getGelar() {
        return gelar;
    }

    public void setGelar(String gelar) {
        this.gelar = gelar;
    }
}
