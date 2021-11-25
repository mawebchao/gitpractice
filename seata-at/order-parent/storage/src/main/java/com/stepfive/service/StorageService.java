package com.stepfive.service;

public interface StorageService {
    void decrease(Long productId, Integer count) throws Exception;
}
