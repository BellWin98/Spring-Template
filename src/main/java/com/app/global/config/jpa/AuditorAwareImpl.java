package com.app.global.config.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.AuditorAware;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<String> {

    @Autowired
    private HttpServletRequest httpServletRequest;

    @Override
    public Optional<String> getCurrentAuditor() {
        String modifiedBy = httpServletRequest.getRequestURI();

        // StringUtils: java의 String 클래스가 제공하는 문자열 관련 기능을 강화한 클래스
        // hasText(): 문자열 유효성 검증 유틸 메서드 - null, 길이가 0, 공백("" / " ") 일 시 false 반환
        if (StringUtils.hasText(modifiedBy)){
            modifiedBy = "unknown";
        }

        return Optional.of(modifiedBy);
    }
}
