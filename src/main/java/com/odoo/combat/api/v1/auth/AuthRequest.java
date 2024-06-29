package com.odoo.combat.api.v1.auth;


public record AuthRequest(String email, String password) {
}