package com.googlecode.hotire.base.domain;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.*;
import java.util.stream.Collectors;

/**
 * Get request body N times
 */
@Slf4j
public class MultiRequestWrapper extends HttpServletRequestWrapper {
    private String body;
    public MultiRequestWrapper(HttpServletRequest request) throws IOException {
        super(request);
        InputStream inputStream = request.getInputStream();
        if (inputStream != null) {
            try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, request.getCharacterEncoding()))) {
                body = bufferedReader.lines().collect(Collectors.joining(System.lineSeparator()));
            }
        } else {
            body = null;
        }
    }
    @Override
    public ServletInputStream getInputStream() throws IOException {
        final ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(body.getBytes());
        ServletInputStream servletInputStream = new ServletInputStream() {
            @Override
            public boolean isFinished(){
                return byteArrayInputStream.available() == 0;
            }
            @Override
            public boolean isReady() {
                /**
                 * Returns true if data can be read without blocking else returns false.
                 */
                return true;
            }
            @Override
            public void setReadListener(ReadListener readListener) {
                /**
                 * Instructs the ServletInputStream to invoke the provided ReadListener when it is possible to read
                 */
                throw new RuntimeException("Not implemented");
            }
            @Override
            public int read() throws IOException {
                return byteArrayInputStream.read();
            }
        };
        return servletInputStream;
    }
    @Override
    public BufferedReader getReader() throws IOException {
        return new BufferedReader(new InputStreamReader(this.getInputStream()));
    }
    public String getBody() {
        return this.body;
    }
}
