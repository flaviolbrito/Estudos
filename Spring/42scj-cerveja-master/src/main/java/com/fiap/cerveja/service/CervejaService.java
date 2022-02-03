package com.fiap.cerveja.service;

import com.fiap.cerveja.domain.Tipo;
import com.fiap.cerveja.dto.CervejaCreateOrUpdateDTO;
import com.fiap.cerveja.dto.CervejaDTO;
import com.fiap.cerveja.dto.CervejaVencimentoDTO;

import java.util.List;

public interface CervejaService {

    List<CervejaDTO> getAll(Tipo tipo);
    CervejaDTO getById(Long id);
    CervejaDTO create(CervejaCreateOrUpdateDTO createOrUpdateDTO);
    CervejaDTO update(Long id, CervejaCreateOrUpdateDTO cervejaCreateOrUpdateDTO);
    CervejaDTO updateVencimento(Long id, CervejaVencimentoDTO cervejaVencimentoDTO);
    void delete(Long id);

}
