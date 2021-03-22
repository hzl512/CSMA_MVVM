package com.imyyq.mvvm.http.interceptor.logging;

import android.text.TextUtils;

import androidx.annotation.NonNull;

import com.imyyq.mvvm.utils.LogUtil;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.platform.Platform;

public class LoggingInterceptor implements Interceptor {

    private final Builder builder;

    private LoggingInterceptor(Builder builder) {
        this.builder = builder;
    }

    @NonNull
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        if (!LogUtil.INSTANCE.isLog() || builder.getLevel() == Level.NONE) {
            return chain.proceed(request);
        }
        RequestBody requestBody = request.body();

        MediaType rContentType = null;
        if (requestBody != null) {
            rContentType = requestBody.contentType();
        }

        String rSubtype = null;
        if (rContentType != null) {
            rSubtype = rContentType.subtype();
        }

        if (rSubtype != null && (rSubtype.contains("json")
                || rSubtype.contains("xml")
                || rSubtype.contains("plain")
                || rSubtype.contains("html"))) {
            Printer.printJsonRequest(builder, request);
        } else {
            Printer.printFileRequest(builder, request);
        }

        long st = System.nanoTime();
        Response response = chain.proceed(request);

        List<String> segmentList = request.url().encodedPathSegments();
        long chainMs = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - st);
        String header = response.headers().toString();
        int code = response.code();
        boolean isSuccessful = response.isSuccessful();
        ResponseBody responseBody = response.body();
        MediaType contentType = null;
        if (responseBody != null) {
           contentType = responseBody.contentType();
        }

        String subtype = null;
        ResponseBody body;

        if (contentType != null) {
            subtype = contentType.subtype();
        }

        if (subtype != null && (subtype.contains("json")
                || subtype.contains("xml")
                || subtype.contains("plain")
                || subtype.contains("html"))) {
            String bodyString = responseBody.string();
            String bodyJson = Printer.getJsonString(bodyString);
            Printer.printJsonResponse(builder, chainMs, isSuccessful, code, header, bodyJson, segmentList);
            body = ResponseBody.create(contentType, bodyString);
        } else {
            Printer.printFileResponse(builder, chainMs, isSuccessful, code, header, segmentList);
            return response;
        }
        return response.newBuilder().body(body).build();
    }

    @SuppressWarnings("unused")
    public static class Builder {

        private static String TAG = "LoggingI";
        private int type = Platform.INFO;
        private String requestTag;
        private String responseTag;
        private Integer level = Level.BASIC;
        private Logger logger;

        public Builder() {
        }

        int getType() {
            return type;
        }

        Integer getLevel() {
            return level;
        }

        String getTag(boolean isRequest) {
            if (isRequest) {
                return TextUtils.isEmpty(requestTag) ? TAG : requestTag;
            } else {
                return TextUtils.isEmpty(responseTag) ? TAG : responseTag;
            }
        }

        Logger getLogger() {
            return logger;
        }

        /**
         * @param level set log level
         * @return Builder
         * @see Level
         */
        public Builder setLevel(Integer level) {
            this.level = level;
            return this;
        }

        /**
         * Set request and response each log tag
         *
         * @param tag general log tag
         * @return Builder
         */
        public Builder tag(String tag) {
            TAG = tag;
            return this;
        }

        /**
         * Set request log tag
         *
         * @param tag request log tag
         * @return Builder
         */
        public Builder request(String tag) {
            this.requestTag = tag;
            return this;
        }

        /**
         * Set response log tag
         *
         * @param tag response log tag
         * @return Builder
         */
        public Builder response(String tag) {
            this.responseTag = tag;
            return this;
        }

        /**
         * @param type set sending log output type
         * @return Builder
         * @see Platform
         */
        public Builder log(int type) {
            this.type = type;
            return this;
        }

        /**
         * @param logger manuel logging interface
         * @return Builder
         * @see Logger
         */
        public Builder logger(Logger logger) {
            this.logger = logger;
            return this;
        }

        public LoggingInterceptor build() {
            return new LoggingInterceptor(this);
        }
    }

}
