package com.example.springdatajpa;

import javax.persistence.Embeddable;

@Embeddable
public class Address {

    // 기본적으로 @Column이 생략되어 있다.

    private String street;

    private String city;

    private String state;

    private String zipCode;
}
