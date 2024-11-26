package com.example.demo.common.domain.exception;

public class CertificationNumberNotMatchedException extends RuntimeException {

    public CertificationNumberNotMatchedException() {
        super("인증 번호가 일치하지 않습니다.");
    }
}
