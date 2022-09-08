package br.com.bookservice.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
public class Cambio implements Serializable {

    private static final long SerialVersionUID = 1L;

    private Long id;

    private String from;

    private String to;

    private BigDecimal conversionFactor;

    private BigDecimal convertedValue;

    private String enviormente;

    public Cambio(Long id, String from, String to, BigDecimal conversionFactor, BigDecimal convertedValue, String enviormente) {
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
