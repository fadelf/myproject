package com.delfa.demo.service;

import com.delfa.demo.wrapper.PetData;

import java.util.List;

public interface PetService {

    List<PetData> getPetByStatus(String status);
}
