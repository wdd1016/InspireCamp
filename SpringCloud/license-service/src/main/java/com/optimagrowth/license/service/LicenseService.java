package com.optimagrowth.license.service;

import java.util.Locale;
import java.util.Random;
import java.util.UUID;

import com.optimagrowth.license.config.ServiceConf;
import com.optimagrowth.license.repository.LicenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.optimagrowth.license.model.License;


// 각 메서드는 CRUD 테스트를 위해서 임의의 데이터를 반환하는 코드를 추가

@Service
public class LicenseService {
    @Autowired
    MessageSource messages;

    @Autowired
    LicenseRepository licenseRepository;

    @Autowired
    ServiceConf config;

    public License getLicense(String licenseId, String organizationId) {
        License license = licenseRepository.findByOrganizationIdAndLicenseId(organizationId, licenseId);
        if (license == null) {
            throw new IllegalArgumentException(
                    String.format(
                            messages.getMessage("license.search.error.message", null, null),
                            licenseId, organizationId));
        }

        return license.withComment(config.getProperty());
    }

    public License createLicense(License license) {
        license.setLicenseId(UUID.randomUUID().toString());
        licenseRepository.save(license);
        return license.withComment(config.getProperty());
    }

    public License updateLicense(License license) {
        licenseRepository.save(license);
        return license.withComment(config.getProperty());
    }

    public String deleteLicense(String licenseId) {
        License license = new License();
        license.setLicenseId(licenseId);
        licenseRepository.delete(license);

        String responseMessage = null;
        responseMessage
                = String.format(messages.getMessage("license.delete.message", null, null), licenseId);
        return responseMessage;
    }
}
