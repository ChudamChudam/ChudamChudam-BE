package com.teosprint.chudam.util;

import org.apache.commons.codec.binary.Base64;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

public class Base64Utils {
    public static MultipartFile convertBase64ToMultipartFile(String base64String) {
        try {
            // base64 문자열을 디코드하여 바이너리 데이터로 변환
            byte[] decodedBytes = Base64.decodeBase64(base64String);

            // 디코드된 바이너리 데이터를 MultipartFile 객체로 변환
            MultipartFile multipartFile = new Base64DecodedMultipartFile(decodedBytes);

            return multipartFile;
        } catch (Exception e) {
            // 디코딩 과정에서 오류가 발생할 경우 예외 처리
            e.printStackTrace();
            return null;
        }
    }

    // 디코드된 바이너리 데이터를 사용하여 MultipartFile 객체를 생성하는 클래스
    private static class Base64DecodedMultipartFile implements MultipartFile {

        private final byte[] content;

        public Base64DecodedMultipartFile(byte[] content) {
            this.content = content;
        }

        @Override
        public String getName() {
            return null;
        }

        @Override
        public String getOriginalFilename() {
            return null;
        }

        @Override
        public String getContentType() {
            return null;
        }

        @Override
        public boolean isEmpty() {
            return content == null || content.length == 0;
        }

        @Override
        public long getSize() {
            return content.length;
        }

        @Override
        public byte[] getBytes() {
            return content;
        }

        @Override
        public InputStream getInputStream() throws IOException {
            return new ByteArrayInputStream(content);
        }

        @Override
        public void transferTo(File dest) throws IOException, IllegalStateException {
            new FileOutputStream(dest).write(content);
        }
    }
}
