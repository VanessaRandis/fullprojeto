package com.front.ads.exceptions;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.context.MessageSource;

import java.util.ArrayList;
import java.util.List;


@ControllerAdvice
public class ExceptionHandlerController {

    private MessageSource messageResource;

    public ExceptionHandlerController(MessageSource msg) {
        this.messageResource = msg;

    }

    public ResponseEntity<List<ErrorMessageDto>> handlerMethodArgumentNotValidException(MethodArgumentNotValidException e ){

        List<ErrorMessageDto> dto = new ArrayList<>();

        e.getBindingResult().getFieldErrors().forEach(err -> {
            String message = messageResource.getMessage(err, LocaleContextHolder.getLocale());
            ErrorMessageDto error = new ErrorMessageDto(message, err.getField());
            dto.add(error);
        });
        return new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);


    }

}
