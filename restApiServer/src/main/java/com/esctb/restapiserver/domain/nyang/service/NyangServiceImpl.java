package com.esctb.restapiserver.domain.nyang.service;

import com.esctb.restapiserver.domain.nyang.entitiy.Nyang;
import com.esctb.restapiserver.domain.nyang.repository.NyangRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NyangServiceImpl implements NyangService{

    private final NyangRepository nyangRepository;

    @Override
    public Nyang saveNayng(Nyang nyang) {
        return nyangRepository.save(nyang);
    }

    @Override
    public void delteNyang(Long id) {
        nyangRepository.deleteById(id);
    }

    @Override
    public Nyang getNyang(Long id) {
        Nyang nyang=nyangRepository.findById(id).orElse(null);
        return nyangRepository.findById(id).orElse(null);
    }
}
