package org.example.model;

import java.util.List;

public class BlockByNumberDtoRequest {

    private String method;
    private List<Object> params;
    private Long id;
    private String jsonrpc;

    public BlockByNumberDtoRequest(String method, List<Object> params, Long id, String jsonrpc) {
        this.method = method;
        this.params = params;
        this.id = id;
        this.jsonrpc = jsonrpc;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public List<Object> getParams() {
        return params;
    }

    public void setParams(List<Object> params) {
        this.params = params;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJsonrpc() {
        return jsonrpc;
    }

    public void setJsonRpc(String jsonrpc) {
        this.jsonrpc = jsonrpc;
    }
}
