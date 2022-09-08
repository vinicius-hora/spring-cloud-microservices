package br.com.cambioservice.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@Entity(name = "cambio")
public class Cambio implements Serializable {

    private static final long SerialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "from_currency", nullable = false, length = 3)
    private String from;

    @Column(name = "to_currency", nullable = false, length = 3)
    private String to;

    @Column(nullable = false)
    private Double conversionFactor;

    @Transient
    private BigDecimal convertedValue;

    @Transient
    private String enviormente;

    public Cambio(Long id, String from, String to, Double conversionFactor, BigDecimal convertedValue, String enviormente) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.conversionFactor = conversionFactor;
        this.convertedValue = convertedValue;
        this.enviormente = enviormente;
    }

    public Cambio() {
    }
}
