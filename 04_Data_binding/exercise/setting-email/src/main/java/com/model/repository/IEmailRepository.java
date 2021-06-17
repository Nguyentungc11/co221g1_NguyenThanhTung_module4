package com.model.repository;

import com.model.bean.Email;

import java.util.List;

public interface IEmailRepository {
    List<String> getListLanguage();

    List<Integer> getListPageSize();

    void save(Email email);

    Email getEmailSetting();

    void update(Email email);
}
