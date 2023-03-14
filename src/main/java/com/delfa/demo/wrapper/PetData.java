package com.delfa.demo.wrapper;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class PetData {
    private Long id;
    private CategoryData category;
    private String name;
    private List<String> photoUrls;
    private List<TagData> tags;
    private String status;
}
