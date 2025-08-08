package com.jianghaike.ddd.filter;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

/**
 * @author jianghaike
 */
 @Component
public class UriNormalizationFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        String uri = request.getRequestURI();
        // 去掉重复斜杠
        String clean = uri.replaceAll("/+", "/");
        // 去掉末尾斜杠
        if (clean.length() > 1 && clean.endsWith("/")) {
            clean = clean.substring(0, clean.length() - 1);
        }

        if (!uri.equals(clean)) {
            String qs = request.getQueryString();
            String url = clean + (Objects.isNull(qs) ? "" : "?" + qs);
            response.sendRedirect(url);
            return;
        }
        filterChain.doFilter(request, response);
    }
}
