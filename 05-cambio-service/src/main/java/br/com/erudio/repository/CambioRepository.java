package br.com.erudio.repository;

import br.com.erudio.model.Cambio;
import org.springframework.data.jpa.repository.JpaRepository;

// Isso daria um crud completo (salvar, deletar, atualizar)
public interface CambioRepository extends JpaRepository<Cambio, Long> {

    // Gerar um sql para criar (Spring Data que faz isso aqui)
    Cambio findByFromAndTo(String from, String to);
}
