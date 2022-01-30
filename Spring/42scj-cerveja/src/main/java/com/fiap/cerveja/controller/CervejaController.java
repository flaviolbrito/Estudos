package com.fiap.cerveja.controller;

import com.fiap.cerveja.domain.Tipo;
import com.fiap.cerveja.dto.CervejaCreateOrUpdateDTO;
import com.fiap.cerveja.dto.CervejaDTO;
import com.fiap.cerveja.dto.CervejaVencimentoDTO;
import com.fiap.cerveja.service.CervejaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("cervejas")
public class CervejaController {

    private CervejaService cervejaService;

    public CervejaController(CervejaService cervejaService){
        this.cervejaService = cervejaService;
    }

    @GetMapping
    public List<CervejaDTO> buscarCervejas(
            @RequestParam(value = "tipo", required = false) Tipo tipo
    ) {
        return cervejaService.getAll(tipo);
    }

    @GetMapping("{idCerveja}")
    public CervejaDTO buscarCervejaPorId(
            @PathVariable(value = "idCerveja") Long id
    ) {
        return cervejaService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CervejaDTO criar(
            @RequestBody CervejaCreateOrUpdateDTO createOrUpdateDTO
    ) {
        return cervejaService.create(createOrUpdateDTO);
    }

    @PutMapping("{id}")
    public CervejaDTO update(
            @PathVariable Long id,
            @RequestBody CervejaCreateOrUpdateDTO createOrUpdateDTO
    ) {
        return cervejaService.update(id, createOrUpdateDTO);

    }

    @PatchMapping("{id}")
    public CervejaDTO updateVencimento(
            @PathVariable Long id,
            @RequestBody CervejaVencimentoDTO cervejaVencimentoDTO
    ) {
        return cervejaService.updateVencimento(id, cervejaVencimentoDTO);

    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarCerveja(
            @PathVariable Long id
    ) {
        cervejaService.delete(id);
    }

}
