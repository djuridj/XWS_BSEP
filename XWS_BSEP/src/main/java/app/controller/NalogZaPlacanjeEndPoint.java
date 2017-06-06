package app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import app.service.NalogZaPlacanjeService;
import app.soap.nalog_za_placanje.CreateNalogRequest;
import app.soap.nalog_za_placanje.GetNalogRequest;
import app.soap.nalog_za_placanje.GetNalogResponse;

@Endpoint
public class NalogZaPlacanjeEndPoint {
	private static final String NAMESPACE_URI = "soap.app/nalog_za_placanje";
	
	private NalogZaPlacanjeService nzps;
	
	@Autowired
	public NalogZaPlacanjeEndPoint(NalogZaPlacanjeService nzps) {
		super();
		this.nzps = nzps;
	}



	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getNalogRequest")
	@ResponsePayload
	public GetNalogResponse getById(@RequestPayload GetNalogRequest request) {
		GetNalogResponse response = new GetNalogResponse();
		response.setNalogZaPlacanje(nzps.getOneById(request.getIdPoruke()));
		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "createNalogRequest")
	@ResponsePayload
	public GetNalogResponse create(@RequestPayload CreateNalogRequest request) {
		GetNalogResponse response = new GetNalogResponse();
		response.setNalogZaPlacanje(nzps.addNew(request.getNalogZaPlacanje()));
		return response;
	}

}
