package com.esctb.restapiserver.domain.nyang.controller;

import com.esctb.restapiserver.domain.nyang.entitiy.Nyang;
import com.esctb.restapiserver.domain.nyang.service.NyangService;
import com.esctb.restapiserver.global.annotation.Timer;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1.0/nyang")
@RequiredArgsConstructor
@Getter
@Slf4j
public class NyangController {

    private final NyangService nyangService;

    @PostMapping()
    public Nyang saveNyang(@RequestBody Nyang nyang){
        return nyangService.saveNayng(nyang);
    }

    @DeleteMapping("/{id}")
    public void deleteNyang(@PathVariable Long id){
        nyangService.delteNyang(id);
    }

    @GetMapping("/{id}")
    @Timer
    public Nyang getNyang(@PathVariable Long id){
        return nyangService.getNyang(id);
    }
}
