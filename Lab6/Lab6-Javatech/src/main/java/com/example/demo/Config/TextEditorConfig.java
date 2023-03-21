package com.example.demo.Config;

import com.example.demo.Respository.TextWriter;
import com.example.demo.Utils.PdfTextWriter;
import com.example.demo.Utils.PlainTextWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;

public class TextEditorConfig {
    @Bean
    public TextEditorConfig textEditor(@Qualifier("plain") @Autowired TextWriter textWriter) {
        TextEditorConfig editor = new TextEditorConfig();
        return editor;
    }

    @Bean
    @Qualifier("plain")
    public PlainTextWriter plainTextWriter() {
        return new PlainTextWriter();
    }

    @Bean
    @Qualifier("pdfWriter")
    public PdfTextWriter pdfTextWriter() {
        return new PdfTextWriter();
    }
}
