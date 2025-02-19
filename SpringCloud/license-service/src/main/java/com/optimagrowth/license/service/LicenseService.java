package com.optimagrowth.license.service;

import java.util.Locale;
import java.util.Random;
import java.util.UUID;

import com.optimagrowth.license.config.ServiceConf;
import com.optimagrowth.license.model.Organization;
import com.optimagrowth.license.repository.LicenseRepository;
import com.optimagrowth.license.service.client.OrganizationDiscoveryClient;
import com.optimagrowth.license.service.client.OrganizationFeignClient;
import com.optimagrowth.license.service.client.OrganizationRestTemplateClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.optimagrowth.license.model.License;


// 각 메서드는 CRUD 테스트를 위해서 임의의 데이터를 반환하는 코드를 추가
@Slf4j
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

    public License getLicense(String licenseId, String organizationId, String clientType) {
        License license = licenseRepository.findByOrganizationIdAndLicenseId(organizationId, licenseId);
        if (license == null) {
            throw new IllegalArgumentException(
                    String.format(
                            messages.getMessage("license.search.error.message", null, null),
                            licenseId, organizationId));
        }

        // 조직 서비스에서 조직 정보를 조회
        Organization organization = retrieveOrganizationInfo(organizationId, clientType);
        if (organization != null) {
            license.setOrganizationName(organization.getName());
            license.setContactName(organization.getContactName());
            license.setContactEmail(organization.getContactEmail());
            license.setContactPhone(organization.getContactPhone());
        }

        // 조직 정보가 포함된 라이센스 정보를 반환
        return license.withComment(config.getProperty());
    }

    @Autowired
    OrganizationFeignClient organizationFeignClient;

    @Autowired
    OrganizationRestTemplateClient organizationRestTemplateClient;

    @Autowired
    OrganizationDiscoveryClient organizationDiscoveryClient;

    // clientType에 따라 지정된 HTTP 클라이언트 라이브러리를 이용해서 조직 정보를 조회
    private Organization retrieveOrganizationInfo(String organizationId, String clientType) {
        Organization organization = null;

        switch (clientType) {
            case "feign":
                log.info(">>> Feign을 이용한 조직 정보 조회");
                organization = organizationFeignClient.getOrganization(organizationId);
                break;
            case "rest":
                log.info(">>> RestTemplate을 이용한 조직 정보 조회");
                organization = organizationRestTemplateClient.getOrganization(organizationId);
                break;
            case "discovery":
                log.info(">>> DiscoveryClient를 이용한 조직 정보 조회");
                organization = organizationDiscoveryClient.getOrganization(organizationId);
                break;
        }

        return organization;
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
