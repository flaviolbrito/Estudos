package com.fiap.cerveja.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fiap.cerveja.domain.Tipo;
import com.fiap.cerveja.dto.CervejaCreateOrUpdateDTO;
import com.fiap.cerveja.dto.CervejaDTO;
import com.fiap.cerveja.dto.CervejaVencimentoDTO;
import com.fiap.cerveja.entity.Cerveja;
import com.fiap.cerveja.repository.CervejaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CervejaServiceImpl implements CervejaService {

    private CervejaRepository cervejaRepository;
    private ObjectMapper objectMapper;

    public CervejaServiceImpl(
            CervejaRepository cervejaRepository,
            ObjectMapper objectMapper
    ){
        this.cervejaRepository = cervejaRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public List<CervejaDTO> getAll(Tipo tipo) {
        List<Cerveja> cervejaList;

        if(tipo != null){
            cervejaList = cervejaRepository.findAllByTipoEquals(tipo);
        }else{
            cervejaList = cervejaRepository.findAll();
        }

        return cervejaList.stream()
                .map(CervejaDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public CervejaDTO getById(Long id) {
        Cerveja cerveja = getCervejaById(id);
        return new CervejaDTO(cerveja);
    }

    @Override
    public CervejaDTO create(CervejaCreateOrUpdateDTO createOrUpdateDTO) {

        Cerveja cerveja = objectMapper.convertValue(createOrUpdateDTO, Cerveja.class);

        Cerveja cervejaSaved = cervejaRepository.save(cerveja);

        return new CervejaDTO(cervejaSaved);
    }

    @Override
    public CervejaDTO update(Long id, CervejaCreateOrUpdateDTO cervejaCreateOrUpdateDTO) {

        Cerveja cerveja = getCervejaById(id);
        cerveja.setNome(cervejaCreateOrUpdateDTO.getNome());
        cerveja.setTipo(cervejaCreateOrUpdateDTO.getTipo());
        cerveja.setVencimento(cervejaCreateOrUpdateDTO.getVencimento());

        Cerveja cervejaSaved = cervejaRepository.save(cerveja);

        return new CervejaDTO(cervejaSaved);
    }

    @Override
    public CervejaDTO updateVencimento(Long id, CervejaVencimentoDTO cervejaVencimentoDTO) {
        Cerveja cerveja = getCervejaById(id);

        cerveja.setVencimento(cervejaVencimentoDTO.getVencimento());

        Cerveja cervejaSaved = cervejaRepository.save(cerveja);

        return new CervejaDTO(cervejaSaved);
    }

    @Override
    public void delete(Long id) {
        Cerveja cerveja = getCervejaById(id);

        cervejaRepository.delete(cerveja);
    }

    private Cerveja getCervejaById(Long id) {
        return cervejaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "cerveja.nao.encontrada"));
    }

}
