package com.example.demo.Utils;

import com.example.demo.Respository.TextWriter;
import org.springframework.stereotype.Component;

@Component
public class PlainTextWriter implements TextWriter {
    @Override
    public void write(String fileName, String text) {
        System.out.println("Write to: " + fileName +"\ttext: "+text);
    }
}