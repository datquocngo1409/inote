package com.codegym.inote.formatter;

import com.codegym.inote.model.Notetype;
import com.codegym.inote.service.NotetypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class NotetypeFormatter implements Formatter<Notetype> {

    private NotetypeService notetypeService;

    @Autowired
    public NotetypeFormatter(NotetypeService notetypeService){
        this.notetypeService = notetypeService;
    }

    @Override
    public Notetype parse(String text, Locale locale) throws ParseException {
        return notetypeService.findById(Long.parseLong(text));
    }

    @Override
    public String print(Notetype object, Locale locale) {
        return null;
    }
}
