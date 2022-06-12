package com.esctb.restapiserver.domain.nyang.service;

import com.esctb.restapiserver.domain.nyang.entitiy.Nyang;

public interface NyangService {
    Nyang saveNayng(Nyang nyang);
    void delteNyang(Long id);
    Nyang getNyang(Long id);
}
