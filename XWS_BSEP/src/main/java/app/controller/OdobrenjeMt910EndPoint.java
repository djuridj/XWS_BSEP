package app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import app.service.OdobrenjeMt910Service;
import app.service.ZaduzenjeMt900Service;
import app.soap.odobrenje_mt910.CreateOdobrenjeNalogRequest;
import app.soap.odobrenje_mt910.GetOdobrenjeNalogRequest;
import app.soap.odobrenje_mt910.GetOdobrenjeNalogResponse;
import app.soap.zaduzenje_mt900.CreateZaduzenjeNalogRequest;
import app.soap.zaduzenje_mt900.GetZaduzenjeNalogRequest;
import app.soap.zaduzenje_mt900.GetZaduzenjeNalogResponse;

public class OdobrenjeMt910EndPoint {
	
private static final String NAMESPACE_URI = "soap.app/odobrenje_mt910";
	
	private OdobrenjeMt910Service omts;
	
	@Autowired
	public OdobrenjeMt910EndPoint(OdobrenjeMt910Service omts) {
		super();
		this.omts = omts;
	}



	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getOdobrenjeNalogRequest")
	@ResponsePayload
	public GetOdobrenjeNalogResponse getById(@RequestPayload GetOdobrenjeNalogRequest request) {
		GetOdobrenjeNalogResponse response = new GetOdobrenjeNalogResponse();
		response.setOdobrenjeMt910(omts.getOneById(request.getIdPoruke()));
		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "createOdobrenjeNalogRequest")
	@ResponsePayload
	public GetOdobrenjeNalogResponse create(@RequestPayload CreateOdobrenjeNalogRequest  request) {
		GetOdobrenjeNalogResponse response = new GetOdobrenjeNalogResponse();
		response.setOdobrenjeMt910(omts.addNew(request.getOdobrenjeMt910()));
		return response;
	}

}
