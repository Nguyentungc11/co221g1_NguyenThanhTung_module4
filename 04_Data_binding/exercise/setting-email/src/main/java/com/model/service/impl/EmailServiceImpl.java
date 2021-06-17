package com.model.service.impl;

import com.model.bean.Email;
import com.model.repository.IEmailRepository;
import com.model.service.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailServiceImpl implements IEmailService {
    @Autowired
    IEmailRepository emailRepository;

    @Override
    public List<String> getListLanguage() {
        return emailRepository.getListLanguage();
    }

    @Override
    public List<Integer> getListPageSize() {
        return emailRepository.getListPageSize();
    }

    @Override
    public void save(Email email) {
        emailRepository.save(email);
    }

    @Override
    public Email getEmailSetting() {
        return emailRepository.getEmailSetting();
    }

    @Override
    public void update(Email email) {
        emailRepository.update(email);
    }
}
