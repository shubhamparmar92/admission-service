package com.sunrise.admissionservice.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class CandidateResponse {
    public int id;

    public String firstName;

    public String lastName;

    public String fatherName;

    public String dob;

    public List<PhoneResponse> phoneList;

    public List<AddressResponse> addressList;

    public List<EmailResponse> emailList;
    public String className;

    public String section;
}
