package com.delfa.demo.wrapper;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class StatusResponse {
    private String code;
    private String message;
}
