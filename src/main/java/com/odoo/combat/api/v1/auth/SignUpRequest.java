package com.odoo.combat.api.v1.auth;

import com.odoo.combat.entities.constants.UserRoles;

public record SignUpRequest(String name,String email, String password, String phoneNumber, UserRoles role) {

}