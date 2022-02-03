package com.fiap.cerveja.repository;

import com.fiap.cerveja.domain.Tipo;
import com.fiap.cerveja.entity.Cerveja;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CervejaRepository extends JpaRepository<Cerveja, Long> {

    List<Cerveja> findAllByTipoEquals(Tipo tipo);

    @Query("from Cerveja c where c.tipo = :tipo")
    List<Cerveja> buscarPorTipo(Tipo tipo);

}
