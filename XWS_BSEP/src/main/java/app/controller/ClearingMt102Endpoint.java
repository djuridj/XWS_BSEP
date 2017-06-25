package app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import app.service.ClearingMt102Service;
import app.service.RtgsNalogMt103Service;
import app.soap.clearing_mt102.CreateClearingNalogRequest;
import app.soap.clearing_mt102.GetClearingNalogRequest;
import app.soap.clearing_mt102.GetClearingNalogResponse;
import app.soap.rtgs_mt103.CreateRTGSNalogRequest;
import app.soap.rtgs_mt103.GetNalogResponse;
import app.soap.rtgs_mt103.GetRTGSNalogRequest;

@Endpoint
public class ClearingMt102Endpoint {
private static final String NAMESPACE_URI = "soap.app/clearing_mt102";
	
    private ClearingMt102Service cmts;
	
	@Autowired
	public ClearingMt102Endpoint(ClearingMt102Service cmts) {
		super();
		this.cmts = cmts;
	}



	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getClearingNalogRequest")
	@ResponsePayload
	public GetClearingNalogResponse getById(@RequestPayload GetClearingNalogRequest request) {
		GetClearingNalogResponse response = new GetClearingNalogResponse();
		response.setClearingMt102(cmts.getOneById(request.getIdPoruke()));
		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "createClearingNalogRequest")
	@ResponsePayload
	public GetClearingNalogResponse create(@RequestPayload CreateClearingNalogRequest request) {
		GetClearingNalogResponse response = new GetClearingNalogResponse();
		response.setClearingMt102(cmts.addNew(request.getClearingMt102()));
		return response;
	}
}
