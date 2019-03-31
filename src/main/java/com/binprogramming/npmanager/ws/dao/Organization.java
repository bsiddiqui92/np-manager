package com.binprogramming.npmanager.ws.dao;

import com.binprogramming.npmanager.ws.shared.dto.OrganizationDTO;

public interface Organization {
    
    OrganizationDTO getOrganization(String field, String value);
    
    OrganizationDTO saveOrganization(OrganizationDTO organization);
}
