package com.binprogramming.npmanager.ws;

import com.binprogramming.npmanager.ws.io.dao.mysql.MySqlUserDao;
import com.binprogramming.npmanager.ws.shared.dto.UserDTO;

public class Test {

    public static void main(String[] args){

        MySqlUserDao mySqlUserDao  = new MySqlUserDao();
        UserDTO userDTO = new UserDTO();
        userDTO.setUserName("HarisSiddiqui");
        userDTO.setLastName("Siddiqui");
        userDTO.setFirstName("Haris");
        userDTO.setEmail("hhb450@gmail.com");
        userDTO.setSalt("salt");
        userDTO.setEncryptedPassword("paswword");
        userDTO.setUserId("1");
        mySqlUserDao.createUser(userDTO);

        UserDTO user = mySqlUserDao.getUserByName("HarisSiddiqui");

        System.out.println("UserName :" + user.getUserName());

    }
}
