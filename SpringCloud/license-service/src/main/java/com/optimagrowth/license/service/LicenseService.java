package com.optimagrowth.license.service;

import java.util.Random;

import org.springframework.stereotype.Service;

import com.optimagrowth.license.model.License;


// 각 메서드는 CRUD 테스트를 위해서 임의의 데이터를 반환하는 코드를 추가

@Service
public class LicenseService {

    public License getLicense(String licenseId, String organizationId) {
        License license = new License();
        license.setId(new Random().nextInt(1000));
        license.setLicenseId(licenseId);
        license.setOrganizationId(organizationId);
        license.setDescription("Software product");
        license.setProductName("Ostock");
        license.setLicenseType("full");
        return license;
    }

    public String createLicense(License license, String organizationId) {
        String responseMessage = null;
        if (license != null) {
            license.setOrganizationId(organizationId);
            responseMessage = String.format("License created %s", license.toString());
        }
        return responseMessage;
    }

    public String updateLicense(License license, String organizationId) {
        String responseMessage = null;
        if (license != null) {
            license.setOrganizationId(organizationId);
            responseMessage = String.format("License updated %s", license.toString());
        }
        return responseMessage;
    }

    public String deleteLicense(String licenseId, String organizationId) {
        String responseMessage = null;
        responseMessage
                = String.format("Deleting license with id %s for the organization %s",
                licenseId, organizationId);
        return responseMessage;
    }
}
