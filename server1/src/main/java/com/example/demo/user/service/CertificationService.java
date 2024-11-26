package com.example.demo.user.service;

import com.example.demo.common.domain.exception.CertificationNumberNotMatchedException;
import com.example.demo.common.service.port.UuidHolder;
import com.example.demo.user.service.port.MailSender;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class CertificationService {

    private final MailSender mailSender;
    private final UuidHolder uuidHolder;
    private final RedisTemplate<String, String> redisTemplate;
    final Integer TIME_TO_LIVE = 3000;

    public String send(String email) {

        String certificationNumber = uuidHolder.random().split("-")[0];
        String title = "[evan] 본인 인증 메일입니다.";
        String content = "인증번호: " + certificationNumber;

        try {
            mailSender.send(email, title, content);

            //redis에 인증번호 저장
            String key = email + ":" + "certificationNumber";
            redisTemplate.opsForValue().set(key, certificationNumber, TIME_TO_LIVE, TimeUnit.SECONDS);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return certificationNumber;
    }

    public String certify(String email, String certificationNumber) {

        // redis에서 email로 인증번호 조회 -> redis template 사용
        // 비교해서 같으면 true, 다르면 false -> 반환 타입 고민
        String key = email + ":" + "certificationNumber";
        String redisCertificationNumber = redisTemplate.opsForValue().get(key);

        if (certificationNumber.equals(redisCertificationNumber)) {
            return email;
        }

        throw new CertificationNumberNotMatchedException();
    }
}
