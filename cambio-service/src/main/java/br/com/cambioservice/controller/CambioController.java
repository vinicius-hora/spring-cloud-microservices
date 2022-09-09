package br.com.cambioservice.controller;

import br.com.cambioservice.model.Cambio;
import br.com.cambioservice.repository.CambioRepostiroy;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.math.RoundingMode;

@RestController
@RequestMapping("cambio-service")
@RequiredArgsConstructor
@Tag(name = "Cambio Service")
public class CambioController {

    private final Environment environment;

    private final CambioRepostiroy cambioRepostiroy;

    @Operation(summary = "Get cambio from currency")
    @GetMapping(value = "/{amount}/{from}/{to}")
    public Cambio getCambio(@PathVariable("amount")BigDecimal amount, @PathVariable("from") String from,@PathVariable("to") String to){


        var cambio = cambioRepostiroy.findByFromAndTo(from, to);

        if(cambio == null){
            throw new RuntimeException("Currency not suported");
        }

        var port = environment.getProperty("local.server.port");
        BigDecimal conversionFactor = BigDecimal.valueOf(cambio.getConversionFactor());
        BigDecimal convertedValue = conversionFactor.multiply(amount);
        cambio.setConvertedValue(convertedValue.setScale(2, RoundingMode.CEILING));

        cambio.setEnviormente(port);
        return cambio;

    }
}
