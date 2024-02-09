package com.sunrise.admissionservice.dto.response;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class ClassResponse {
    public int id;
    public String section;

    public String name;
}
