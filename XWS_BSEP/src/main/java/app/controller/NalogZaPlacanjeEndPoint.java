package app.controller;

import java.math.BigDecimal;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import app.model.Banka;
import app.model.Racuni;
import app.repo.BankaRepo;
import app.repo.RacuniRepo;
import app.service.BankaService;
import app.service.ClearingMt102Service;
import app.service.NalogZaPlacanjeService;
import app.service.PojedinacnoPlacanjeService;
import app.service.RacuniService;
import app.service.RtgsNalogMt103Service;
import app.soap.clearing_mt102.ClearingMt102;
import app.soap.clearing_mt102.ClearingMt102.PojedinacnoPlacanje;
import app.soap.clearing_mt102.GetClearingNalogResponse;
import app.soap.nalog_za_placanje.CreateNalogRequest;
import app.soap.nalog_za_placanje.GetNalogRequest;
import app.soap.nalog_za_placanje.GetNalogResponse;
import app.soap.rtgs_mt103.RtgsMt103;

@Endpoint
public class NalogZaPlacanjeEndPoint {
	private static final String NAMESPACE_URI = "soap.app/nalog_za_placanje";
	
	private NalogZaPlacanjeService nzps;
	
	private RacuniService rser;
	
	private RtgsNalogMt103Service rmts;
	private BankaService bs;
	private ClearingMt102Service cmts;
	private PojedinacnoPlacanjeService pps;
	@Autowired
	public RacuniRepo rrep;
	
	@Autowired
	public NalogZaPlacanjeEndPoint(NalogZaPlacanjeService nzps, RacuniService rser, RtgsNalogMt103Service rmts, BankaService bs, RacuniRepo rrep, ClearingMt102Service cmts, PojedinacnoPlacanjeService pps ) {
		super();
		this.nzps = nzps;
		this.rser = rser;
		this.rmts = rmts;
		this.bs = bs;
		this.rrep = rrep;
		this.cmts = cmts;
		this.pps = pps;
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
		
		// RTGS
		app.soap.rtgs_mt103.GetNalogResponse rtgsResponse = new app.soap.rtgs_mt103.GetNalogResponse();
		
		response.setNalogZaPlacanje(nzps.addNew(request.getNalogZaPlacanje()));
		BigDecimal bd = new BigDecimal(250000);
		RtgsMt103 mt103 = new RtgsMt103();
		String brojRacunDuznika = request.getNalogZaPlacanje().getBrojRacunaDuznika();
		Racuni racun = rser.getOneByRacun(brojRacunDuznika);
		int idBanke = racun.getMaticnaBanka().getId();
		Banka matBanka= bs.getById(idBanke);
		String swiftKodBankeDuznika = matBanka.getSwift();
		//String swiftKodBankeDuznika = racun.getMaticnaBanka().getSwift();
		//String obracunskiRacunBankeDuznika = racun.getMaticnaBanka().getRacun();
		String obracunskiRacunBankeDuznika = matBanka.getRacun();
		System.out.println(matBanka);
		String brojRacunaPoverioca = request.getNalogZaPlacanje().getBrojRacunaPoverioca();
		Racuni racunPov = rser.getOneByRacun(brojRacunaPoverioca);
		int idBankePov = racunPov.getMaticnaBanka().getId();
		Banka matBankaPov = bs.getById(idBankePov);
		String swiftKodBankePoverioca = matBankaPov.getSwift();
		String obracunskiRacunBankePoverioca = matBankaPov.getRacun();
		//String swiftKodBankePoverioca = racunPov.getMaticnaBanka().getSwift();
		//String obracunskiRacunBankePoverioca = racunPov.getMaticnaBanka().getRacun();
		
		
		// CLEARING
		PojedinacnoPlacanje pp = new PojedinacnoPlacanje();
		ClearingMt102 mt102 = new ClearingMt102();
		
		GetClearingNalogResponse clearingResponse = new GetClearingNalogResponse();
		
	  if(!swiftKodBankeDuznika.equals(swiftKodBankePoverioca)) {
		if(request.getNalogZaPlacanje().getIznos().compareTo(bd)==1 || request.getNalogZaPlacanje().isHitno()==true){
			mt103.setIdPoruke((UUID.randomUUID().toString()));
			mt103.setSwiftKodBankeDuznika(swiftKodBankeDuznika);
			mt103.setObracunskiRacunBankeDuznika(obracunskiRacunBankeDuznika);
			mt103.setSwiftKodBankePoverioca(swiftKodBankePoverioca);
			mt103.setObracunskiRacunBankePoverioca(obracunskiRacunBankePoverioca);
			mt103.setDuznikNalogodavac(request.getNalogZaPlacanje().getDuznikNalogodavac());
			mt103.setSvrhaPlacanja(request.getNalogZaPlacanje().getSvrhaPlacanja());
			mt103.setPrimalacPoverilac(request.getNalogZaPlacanje().getPrimalacPoverilac());
			mt103.setDatumNaloga(request.getNalogZaPlacanje().getDate());
			mt103.setDatumValute(request.getNalogZaPlacanje().getDate());
			mt103.setBrojRacunaDuznika(request.getNalogZaPlacanje().getBrojRacunaDuznika());
			mt103.setModelZaduzenja(request.getNalogZaPlacanje().getModelZaduzenja());
			mt103.setPozivNaBrojZaduzenja(request.getNalogZaPlacanje().getPozivNaBrojZaduzenja());
			mt103.setBrojRacunaPoverioca(request.getNalogZaPlacanje().getBrojRacunaPoverioca());
			mt103.setModelOdobrenja(request.getNalogZaPlacanje().getModelOdobrenja());
			mt103.setPozivNaBrojOdobrenja(request.getNalogZaPlacanje().getPozivNaBrojOdobrenja());
			mt103.setIznos(request.getNalogZaPlacanje().getIznos());
			mt103.setSifraValute(request.getNalogZaPlacanje().getOznakaValute());
			
			rtgsResponse.setRtgsMt103(rmts.addNew(mt103));
		}else {
			
			
			
			
			
			mt102.setIdPoruke((UUID.randomUUID().toString()));
			mt102.setSwiftKodBankeDuznika(swiftKodBankeDuznika);
			mt102.setObracunskiRacunBankeDuznika(obracunskiRacunBankeDuznika);
			mt102.setSwiftKodBankePoverioca(swiftKodBankePoverioca);
			mt102.setObracunskiRacunBankePoverioca(obracunskiRacunBankePoverioca);
			mt102.setUkupanIznos(request.getNalogZaPlacanje().getIznos());
			mt102.setSifraValute(request.getNalogZaPlacanje().getOznakaValute());
			mt102.setDatumValute(request.getNalogZaPlacanje().getDate());
			mt102.setDatum(request.getNalogZaPlacanje().getDate());
			clearingResponse.setClearingMt102(cmts.addNew(mt102));
			
			pp.setIdNalogaZaPlacanje(request.getNalogZaPlacanje().getIdPoruke());
			pp.setDuznikNalogodavac(request.getNalogZaPlacanje().getDuznikNalogodavac());
			pp.setSvrhaPlacanja(request.getNalogZaPlacanje().getSvrhaPlacanja());
			pp.setPrimalacPoverilac(request.getNalogZaPlacanje().getPrimalacPoverilac());
			pp.setDatumNaloga(request.getNalogZaPlacanje().getDate());
			pp.setBrojRacunaDuznika(request.getNalogZaPlacanje().getBrojRacunaDuznika());
			pp.setModelZaduzenja(request.getNalogZaPlacanje().getModelZaduzenja());
			pp.setPozivNaBrojZaduzenja(request.getNalogZaPlacanje().getPozivNaBrojZaduzenja());
			pp.setBrojRacunaPoverioca(request.getNalogZaPlacanje().getBrojRacunaPoverioca());
			pp.setModelOdobrenja(request.getNalogZaPlacanje().getModelOdobrenja());
			pp.setPozivNaBrojOdobrenja(request.getNalogZaPlacanje().getPozivNaBrojOdobrenja());
			pp.setIznos(request.getNalogZaPlacanje().getIznos());
			pp.setOznakaValute(request.getNalogZaPlacanje().getOznakaValute());
			pp.setMatClearing(mt102);
			
			
			clearingResponse.setPojedinacnoPlacanje(pps.addNew(pp));
			
			
			
			
		}
	  }
		
		
		
		return response;
	}
	
}
