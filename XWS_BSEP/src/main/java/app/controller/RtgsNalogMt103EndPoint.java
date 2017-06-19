package app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;





import app.service.RtgsNalogMt103Service;
import app.soap.rtgs_mt103.CreateRTGSNalogRequest;
import app.soap.rtgs_mt103.GetNalogResponse;
import app.soap.rtgs_mt103.GetRTGSNalogRequest;


@Endpoint
public class RtgsNalogMt103EndPoint {
    private static final String NAMESPACE_URI = "soap.app/rtgs_mt103";
	
    private RtgsNalogMt103Service rnmts;
	
	@Autowired
	public RtgsNalogMt103EndPoint(RtgsNalogMt103Service rnmts) {
		super();
		this.rnmts = rnmts;
	}



	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getRTGSNalogRequest")
	@ResponsePayload
	public GetNalogResponse getById(@RequestPayload GetRTGSNalogRequest request) {
		GetNalogResponse response = new GetNalogResponse();
		response.setRtgsMt103(rnmts.getOneById(request.getIdPoruke()));
		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "createRTGSNalogRequest")
	@ResponsePayload
	public GetNalogResponse create(@RequestPayload CreateRTGSNalogRequest request) {
		GetNalogResponse response = new GetNalogResponse();
		response.setRtgsMt103(rnmts.addNew(request.getRtgsMt103()));
		return response;
	}

}
