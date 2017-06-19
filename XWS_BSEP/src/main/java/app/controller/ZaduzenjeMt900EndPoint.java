package app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;





import app.service.ZaduzenjeMt900Service;
import app.soap.zaduzenje_mt900.CreateZaduzenjeNalogRequest;
import app.soap.zaduzenje_mt900.GetZaduzenjeNalogRequest;
import app.soap.zaduzenje_mt900.GetZaduzenjeNalogResponse;


@Endpoint
public class ZaduzenjeMt900EndPoint {
	
private static final String NAMESPACE_URI = "soap.app/zaduzenje_mt900";
	
	private ZaduzenjeMt900Service zmts;
	
	@Autowired
	public ZaduzenjeMt900EndPoint(ZaduzenjeMt900Service zmts) {
		super();
		this.zmts = zmts;
	}



	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getZaduzenjeNalogRequest")
	@ResponsePayload
	public GetZaduzenjeNalogResponse getById(@RequestPayload GetZaduzenjeNalogRequest request) {
		GetZaduzenjeNalogResponse response = new GetZaduzenjeNalogResponse();
		response.setZaduzenjeMt900(zmts.getOneById(request.getIdPoruke()));
		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "createZaduzenjeNalogRequest")
	@ResponsePayload
	public GetZaduzenjeNalogResponse create(@RequestPayload CreateZaduzenjeNalogRequest  request) {
		GetZaduzenjeNalogResponse response = new GetZaduzenjeNalogResponse();
		response.setZaduzenjeMt900(zmts.addNew(request.getZaduzenjeMt900()));
		return response;
	}

}
