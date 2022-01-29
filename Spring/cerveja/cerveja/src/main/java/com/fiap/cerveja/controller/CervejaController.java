package com.fiap.cerveja.controller;

import com.fiap.cerveja.domain.Tipo;
import com.fiap.cerveja.dto.CervejaDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
    //@GetMapping
    //public String buscarCervejas(){
    //    return "Hello Word";

   // public List<String> buscarCervejas(){
   //     return Arrays.asList("Skol","Gracial");


   // }

