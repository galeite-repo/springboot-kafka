package com.portal.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude
public class OwnerPostDTO {
    private String name;
    private String type;
    private String contactNumber;
}