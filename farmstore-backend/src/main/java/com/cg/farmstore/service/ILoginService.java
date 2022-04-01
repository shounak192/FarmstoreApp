package com.cg.farmstore.service;

import org.springframework.stereotype.Service;
import com.cg.farmstore.dto.Response;
import com.cg.farmstore.entities.Credentials;

@Service
public interface ILoginService {
	public Response validateLogin(Credentials credentials);
}
