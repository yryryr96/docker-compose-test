package com.example.demo.user.service;

import com.example.demo.common.domain.exception.CertificationNumberNotMatchedException;
import com.example.demo.common.service.port.UuidHolder;
import com.example.demo.mock.FakeMailSender;
import com.example.demo.mock.TestUuidHolder;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;


import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.*;


//@ExtendWith(MockitoExtension.class)
@SpringBootTest
class CertificationServiceTest {

    final String EMAIL = "s9285s@naver.com";

    @Autowired
    RedisTemplate<String, String> redisTemplate;

    @Test
    void 메일_보내기_테스트() throws Exception {
        //given
        String email = EMAIL;
        String title = "[evan] 본인 인증 메일입니다.";
        String certificationNumber = "1234";
        String content = "인증번호: " + certificationNumber;
        String key = email + ":certificationNumber";

        FakeMailSender fakeMailSender = new FakeMailSender();
        UuidHolder uuidHolder = new TestUuidHolder("1234-5678-4949-2122");
        CertificationService certificationService = new CertificationService(fakeMailSender, uuidHolder, redisTemplate);

        //when
        String result = certificationService.send(email);

        //then
        assertThat(fakeMailSender.email).isEqualTo(email);
        assertThat(fakeMailSender.title).isEqualTo(title);
        assertThat(fakeMailSender.content).isEqualTo(content);
        assertThat(result).isEqualTo(certificationNumber);
        assertThat(redisTemplate.opsForValue().get(key)).isEqualTo(result);
    }

    @Test
    void 메일_인증_성공_테스트() throws Exception {
        //given
        String key = EMAIL + ":certificationNumber";
        redisTemplate.opsForValue().set(key, "1234", 3000, TimeUnit.SECONDS);
        FakeMailSender fakeMailSender = new FakeMailSender();
        UuidHolder uuidHolder = new TestUuidHolder("1234-5678-4949-2122");
        CertificationService certificationService = new CertificationService(fakeMailSender, uuidHolder, redisTemplate);

        //when
        String result = certificationService.certify(EMAIL, "1234");

        //then
        assertThat(EMAIL).isEqualTo(result);
    }

    @Test
    void 메일_인증_실패_테스트() throws Exception {

        //given
        String key = EMAIL + ":certificationNumber";
        redisTemplate.opsForValue().set(key, "1234", 3000, TimeUnit.SECONDS);
        FakeMailSender fakeMailSender = new FakeMailSender();
        UuidHolder uuidHolder = new TestUuidHolder("1234-5678-4949-2122");
        CertificationService certificationService = new CertificationService(fakeMailSender, uuidHolder, redisTemplate);

        //when

        //then
        assertThatThrownBy(() -> certificationService.certify(EMAIL, "실패 테스트"))
                .isInstanceOf(CertificationNumberNotMatchedException.class);
    }
}