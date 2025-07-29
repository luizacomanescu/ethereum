package org.example.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.model.BlockByNumberDtoRequest;
import org.example.model.BlockByNumberDtoResponse;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class EtheriumServiceImpl implements EtheriumService{
    // Add ObjectMappper as a static variable in our service;
    @Override
    public void processingRequest(BlockByNumberDtoRequest request, String rpcUrl) throws IOException {

        // convert our object into json
        ObjectMapper mapper = new ObjectMapper();
        String jsonObject = mapper.writeValueAsString(request) ;

        URL url = new URL(rpcUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setDoOutput(true);

        try (OutputStream os = conn.getOutputStream()) {
            byte[] input = jsonObject.getBytes("utf-8");
            os.write(input, 0, input.length);
        }

        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(conn.getInputStream(), "utf-8"))) {
            StringBuilder response = new StringBuilder();
            String responseLine;

            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }

            String responseJson = response.toString();

            BlockByNumberDtoResponse blockByNumberDtoResponse =
                    mapper.readValue(responseJson, BlockByNumberDtoResponse.class);

            buildJsonFile(blockByNumberDtoResponse);
        }

    }

    private void buildJsonFile(BlockByNumberDtoResponse blockByNumberDtoResponse) throws IOException {
        String directory = "/Users/luizacomanescu/git/ethereum/src/main/resources";

        ObjectMapper mapper = new ObjectMapper();
        File file = new File(directory + "blockByNumber_" + blockByNumberDtoResponse.getId() + ".json");


        mapper.writerWithDefaultPrettyPrinter().writeValue(file, blockByNumberDtoResponse);

        System.out.println(file.getAbsoluteFile());
    }
}
