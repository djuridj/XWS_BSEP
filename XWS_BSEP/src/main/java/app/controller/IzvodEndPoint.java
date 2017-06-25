package app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import app.service.IzvodService;
import app.soap.izvod.CreateIzvodRequest;
import app.soap.izvod.GetIzvodRequest;
import app.soap.izvod.GetIzvodResponse;

@Endpoint
public class IzvodEndPoint {
	private static final String NAMESPACE_URI = "soap.app/izvod";
	
	private IzvodService is;
	
	@Autowired
	public IzvodEndPoint(IzvodService is) {
		super();
		this.is = is;
	}



	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getIzvodRequest")
	@ResponsePayload
	public GetIzvodResponse getById(@RequestPayload GetIzvodRequest request) {
		GetIzvodResponse response = new GetIzvodResponse();
		response.setIzvod(is.getOneById(request.getIdPoruke()));
		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "createIzvodRequest")
	@ResponsePayload
	public GetIzvodResponse create(@RequestPayload CreateIzvodRequest request) {
		GetIzvodResponse response = new GetIzvodResponse();
		response.setIzvod(is.addNew(request.getIzvod()));
		return response;
	}

}
