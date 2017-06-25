package app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import app.service.ZahtevZaIzvodService;
import app.soap.zahtev_za_izvod.CreateZahtevIzvodRequest;
import app.soap.zahtev_za_izvod.GetZahtevIzvodRequest;
import app.soap.zahtev_za_izvod.GetZahtevIzvodResponse;

@Endpoint
public class ZahtevZaIzvodEndpoint {
	private static final String NAMESPACE_URI = "soap.app/zahtev_za_izvod";
	
	private ZahtevZaIzvodService zzis;
	
	@Autowired
	public ZahtevZaIzvodEndpoint(ZahtevZaIzvodService zzis) {
		super();
		this.zzis = zzis;
	}



	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getZahtevIzvodRequest")
	@ResponsePayload
	public GetZahtevIzvodResponse getById(@RequestPayload GetZahtevIzvodRequest request) {
		GetZahtevIzvodResponse response = new GetZahtevIzvodResponse();
		response.setZahtevZaIzvod(zzis.getOneById(request.getIdPoruke()));
		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "createZahtevIzvodRequest")
	@ResponsePayload
	public GetZahtevIzvodResponse create(@RequestPayload CreateZahtevIzvodRequest request) {
		GetZahtevIzvodResponse response = new GetZahtevIzvodResponse();
		response.setZahtevZaIzvod(zzis.addNew(request.getZahtevZaIzvod()));
		return response;
	}

}
