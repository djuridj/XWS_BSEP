package app.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;













import app.service.OdobrenjeMt910Service;
import app.service.RtgsNalogMt103Service;
import app.service.ZaduzenjeMt900Service;
import app.soap.odobrenje_mt910.GetOdobrenjeNalogResponse;
import app.soap.odobrenje_mt910.OdobrenjeMt910;
import app.soap.rtgs_mt103.CreateRTGSNalogRequest;
import app.soap.rtgs_mt103.GetNalogResponse;
import app.soap.rtgs_mt103.GetRTGSNalogRequest;
import app.soap.rtgs_mt103.RtgsMt103;
import app.soap.zaduzenje_mt900.GetZaduzenjeNalogResponse;
import app.soap.zaduzenje_mt900.ZaduzenjeMt900;


@Endpoint
public class RtgsNalogMt103EndPoint {
    private static final String NAMESPACE_URI = "soap.app/rtgs_mt103";
	
    private RtgsNalogMt103Service rnmts;
	
    private ZaduzenjeMt900Service zmts;
    
    private OdobrenjeMt910Service omts;
	@Autowired
	public RtgsNalogMt103EndPoint(RtgsNalogMt103Service rnmts, ZaduzenjeMt900Service zmts,OdobrenjeMt910Service omts) {
		super();
		this.rnmts = rnmts;
		this.zmts = zmts;
		this.omts = omts;
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
		GetNalogResponse response1 = new GetNalogResponse();
		GetZaduzenjeNalogResponse zaduzenjeResponse = new GetZaduzenjeNalogResponse();
		GetOdobrenjeNalogResponse odobrenjeResponse = new GetOdobrenjeNalogResponse();
		response.setRtgsMt103(rnmts.addNew(request.getRtgsMt103()));
		ZaduzenjeMt900 mt900 = new ZaduzenjeMt900();
		mt900.setIdPoruke((UUID.randomUUID().toString()));
	    mt900.setSwiftKodBankeDuznika(request.getRtgsMt103().getSwiftKodBankeDuznika());
	    mt900.setObracunskiRacunBankeDuznika(request.getRtgsMt103().getObracunskiRacunBankeDuznika());
	    mt900.setIdPorukeNaloga(request.getRtgsMt103().getIdPoruke());
	    mt900.setDatumValute(request.getRtgsMt103().getDatumValute());
	    mt900.setIznos(request.getRtgsMt103().getIznos());
	    mt900.setSifraValute(request.getRtgsMt103().getSifraValute());
	    response1.setMt900(mt900);
		zaduzenjeResponse.setZaduzenjeMt900(zmts.addNew(mt900));
		
		OdobrenjeMt910 mt910 = new OdobrenjeMt910();
		mt910.setIdPoruke((UUID.randomUUID().toString()));
	    mt910.setSwiftKodBankePoverioca(request.getRtgsMt103().getSwiftKodBankePoverioca());
	    mt910.setObracunskiRacunBankePoverioca(request.getRtgsMt103().getObracunskiRacunBankePoverioca());
	    mt910.setIdPorukeNaloga(request.getRtgsMt103().getIdPoruke());
	    mt910.setDatumValute(request.getRtgsMt103().getDatumValute());
	    mt910.setIznos(request.getRtgsMt103().getIznos());
	    mt910.setSifraValute(request.getRtgsMt103().getSifraValute());
	    odobrenjeResponse.setOdobrenjeMt910(omts.addNew(mt910));
		return response1;
	}
    
}
