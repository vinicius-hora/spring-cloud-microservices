package br.com.cambioservice.repository;

import br.com.cambioservice.model.Cambio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CambioRepostiroy extends JpaRepository<Cambio, Long> {

    Cambio findByFromAndTo(String from, String to);
}
