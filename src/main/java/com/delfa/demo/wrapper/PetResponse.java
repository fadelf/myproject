package com.delfa.demo.wrapper;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class PetResponse {
    private StatusResponse status;
    private List<PetData> result;

}
