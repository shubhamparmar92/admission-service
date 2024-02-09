package com.sunrise.admissionservice.service.helper;

import com.sunrise.admissionservice.client.request.StudentRequest;
import com.sunrise.admissionservice.dto.response.AdmissionResponse;
import com.sunrise.admissionservice.exception.APIResponseException;
import com.sunrise.admissionservice.mapper.AdmissiontoStudentMapper;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class AdmissionServiceHelper {

    @Autowired
    WebClient studentClient;
    public Integer saveAsStudent(AdmissionResponse source) throws APIResponseException {
        AdmissiontoStudentMapper mapper = Mappers.getMapper(AdmissiontoStudentMapper.class);
        StudentRequest studentRequest = mapper.toStudentRequest(source.getCandidate());
        log.info("Student Request: {}", studentRequest);
        try{
        Integer id = studentClient.post()
                .uri("student")
                .body(Mono.just(studentRequest), StudentRequest.class)
                .retrieve()
                .bodyToMono(Integer.class)
                .block();

        return id;}
        catch(Exception e)
        {
            throw new APIResponseException("Error Occurred While Saving Student Details: "+e.getMessage());
        }
    }

}
