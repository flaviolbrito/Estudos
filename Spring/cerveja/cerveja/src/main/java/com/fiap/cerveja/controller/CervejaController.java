package com.fiap.cerveja.controller;

import com.fiap.cerveja.domain.Tipo;
import com.fiap.cerveja.dto.CervejaCreateOrUpdateDTO;
import com.fiap.cerveja.dto.CervejaDTO;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("cervejas")
public class CervejaController {


    @GetMapping
    public List<CervejaDTO> buscarCervejas() {
        CervejaDTO cervejaDT01 = new CervejaDTO();
        cervejaDT01.setId(1L);
        cervejaDT01.setNome("Baden Baden");
        cervejaDT01.setTipo(Tipo.WEISS);
        cervejaDT01.setVencimento(LocalDate.of(2022, 6, 30));

        CervejaDTO cervejaDTO2 = new CervejaDTO();
        cervejaDTO2.setId(2L);
        cervejaDTO2.setNome("Colonia");
        cervejaDTO2.setTipo(Tipo.PILSEN);
        cervejaDTO2.setVencimento(LocalDate.of(2022, 2, 15));

        return Arrays.asList(cervejaDT01, cervejaDTO2);
    }
     @GetMapping
    public List<CervejaDTO> buscarCervejas(



     )
        return cervejaList.stream()


    }
    @GetMapping("{idCerveja}")
    public CervejaDTO buscarCervejaPorId(
        @PathVariable(value = "idCerveja") Long id
        ){
        return cervejaList.stream()
                .filter(cervejaDTO -> cervejaDTO.getId().equals(id))
                .findFirst()
                .orElseThrow(()-> new ResponseStatusException(HttpSatus.BAD_REQUEST,"cerveja não encotrada"));
                ;

    }

    @PostMapping
    public CervejaDTO criar (
            @RequestBody CervejaCreateOrUpdateDTO createOrUpdateDTO
            ){
      cervejaDTO cervejaDTO =  new CervejaDTO();
      cerveja.DTO setId(cervejaList.size() + 1L);
      cervejaDTO.setNome(createOrUpdateDTO.getNome());
      cervejaList.add(cervejaDTO);
      return  cervejaDTO;

    }

    )

}


