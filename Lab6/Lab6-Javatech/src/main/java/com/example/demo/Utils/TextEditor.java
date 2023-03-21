package com.example.demo.Utils;

import com.example.demo.Respository.TextWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;



public class TextEditor {
    @Qualifier("plain")
    @Autowired
    private TextWriter textWriter;

    private String text;
    public void input(String text) {
        this.text = text;
    }

    public void save(String fileName) {
        textWriter.write(fileName, this.text);
    }

}