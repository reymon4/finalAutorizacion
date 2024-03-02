package com.example.demo.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


@Component
public class JwtUtils {
	
	
	private String jwtSemilla;
	

	private int jwtExpirationMs;


	public String buildTokenJwt(String nombre) {
		return Jwts.builder().setSubject(nombre).setSubject(nombre).setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis()+this.jwtExpirationMs))
				.signWith(SignatureAlgorithm.HS512, this.jwtSemilla).compact();
	}


	public String getJwtSemilla() {
		return jwtSemilla;
	}


	public void setJwtSemilla(String jwtSemilla) {
		this.jwtSemilla = jwtSemilla;
	}


	public int getJwtExpirationMs() {
		return jwtExpirationMs;
	}


	public void setJwtExpirationMs(int jwtExpirationMs) {
		this.jwtExpirationMs = jwtExpirationMs;
	}

	
	
	
}
