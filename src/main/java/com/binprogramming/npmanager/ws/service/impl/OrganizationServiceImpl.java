/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.binprogramming.npmanager.ws.service.impl;

import com.binprogramming.npmanager.ws.dao.DAO;
import com.binprogramming.npmanager.ws.dao.DAOFactory;
import com.binprogramming.npmanager.ws.dao.Organization;
import com.binprogramming.npmanager.ws.shared.dto.OrganizationDTO;


/**
 *
 * @author ahmed
 */
public class OrganizationServiceImpl implements OrganizationService{
    
    private static int MYSQL_DAO = 1;
    
    private Organization OrganizationDAO;
    
    public OrganizationServiceImpl(){
        DAOFactory daoFactory = new DAOFactory();
        DAO dao = daoFactory.getDAOFactory(this.MYSQL_DAO);
        
        this.OrganizationDAO = dao.Organization();
    }
    
    public OrganizationDTO getOrganization(String field, String value){
        
        OrganizationDTO returnValue = this.OrganizationDAO.getOrganization(field, value);
        
        return returnValue;
    }
    
    public OrganizationDTO createOrganization(OrganizationDTO dto){
        
        dto = this.OrganizationDAO.saveOrganization(dto);
        
        return dto;
    }
    

}
