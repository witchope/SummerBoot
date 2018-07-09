package com.hackzone.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Optional;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors
public class BaseResp<T> {

    private T data;

    public T getData() {
        return data;
    }

    public void setData(Optional<T> data) {
        this.data = (T) data;
    }
}

