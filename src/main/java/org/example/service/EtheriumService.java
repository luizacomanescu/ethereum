package org.example.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.example.model.BlockByNumberDtoRequest;

import java.io.IOException;
import java.net.MalformedURLException;

public interface EtheriumService {
    void processingRequest(BlockByNumberDtoRequest request, String url) throws IOException;
}
