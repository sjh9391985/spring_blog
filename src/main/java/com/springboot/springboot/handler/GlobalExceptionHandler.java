package com.springboot.springboot.handler;

import com.springboot.springboot.dto.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice // 모든 Exception를 들어올 경우 GlobalExceptionHandler Class로 들어옵니다.
@RestController
public class GlobalExceptionHandler {

    // Exception 걸릴 경우 아래의 함수를 실행시킵니다.
    @ExceptionHandler(value = Exception.class) //IllegalArgumentException이 발생하면 그 에러를 handleArgumentException에 전달해줘서 보여줍니다.
    public ResponseDto<String> handleArgumentException(IllegalArgumentException e){
        return new ResponseDto<String>(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
    }

}
