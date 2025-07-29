package org.example;

import org.example.model.BlockByNumberDtoRequest;
import org.example.service.EtheriumService;
import org.example.service.EtheriumServiceImpl;

import java.io.IOException;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        EtheriumService etheriumService = new EtheriumServiceImpl();

        etheriumService.processingRequest(new BlockByNumberDtoRequest("eth_getBlockByNumber",
                List.of("0xc5043f",false), 1l, "2.0"), "https://docs-demo.quiknode.pro/");
        }
    }