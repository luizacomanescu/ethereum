package org.example.model;

public class BlockByNumberDtoResponse {
    private String jsonrpc;
    private Long id;

    public String getJsonrpc() {
        return jsonrpc;
    }

    public void setJsonrpc(String jsonrpc) {
        this.jsonrpc = jsonrpc;
    }

    private Result result;

    public BlockByNumberDtoResponse() {

    }

    public BlockByNumberDtoResponse(String jsonrpc, Long id, Result result) {
        this.jsonrpc = jsonrpc;
        this.id = id;
        this.result = result;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }
}
