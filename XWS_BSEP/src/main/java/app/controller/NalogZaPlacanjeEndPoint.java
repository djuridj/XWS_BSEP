package app.controller;

import java.math.BigDecimal;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import app.model.Banka;
import app.model.Faktura;
import app.model.Racuni;
import app.repo.BankaRepo;
import app.repo.RacuniRepo;
import app.service.BankaService;
import app.service.ClearingMt102Service;
import app.service.FakturaService;
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
import app.soap.nalog_za_placanje.NalogZaPlacanje;
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
	private FakturaService fs;
	@Autowired
	public RacuniRepo rrep;
	
	@Autowired
	public NalogZaPlacanjeEndPoint(NalogZaPlacanjeService nzps, RacuniService rser, RtgsNalogMt103Service rmts, BankaService bs, RacuniRepo rrep, ClearingMt102Service cmts, PojedinacnoPlacanjeService pps,
			FakturaService fs) {
		super();
		this.nzps = nzps;
		this.rser = rser;
		this.rmts = rmts;
		this.bs = bs;
		this.rrep = rrep;
		this.cmts = cmts;
		this.pps = pps;
		this.fs = fs;
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
		System.out.println("NO");
		GetNalogResponse response = new GetNalogResponse();
		System.out.println(request.getNalogZaPlacanje().getDuznikNalogodavac());
		Faktura fak = fs.getOneById(request.getNalogZaPlacanje().getFaktura());
		System.out.println("NO");
		BigDecimal iznos = BigDecimal.valueOf(fak.getIznos_za_uplatu());
		String oznakaValute = fak.getOznaka_valute();
		String racunPoverioca = fak.getUplata_na_racun();
		String primalac = fak.getFirma_dobavljac().getNaziv_firme();
		NalogZaPlacanje nalogZaPlacanje = new NalogZaPlacanje();
		nalogZaPlacanje.setIdPoruke(request.getNalogZaPlacanje().getIdPoruke());
		nalogZaPlacanje.setBrojRacunaDuznika(request.getNalogZaPlacanje().getBrojRacunaDuznika());
		nalogZaPlacanje.setBrojRacunaPoverioca(racunPoverioca);
		
		nalogZaPlacanje.setDate(request.getNalogZaPlacanje().getDate());
		nalogZaPlacanje.setDuznikNalogodavac(request.getNalogZaPlacanje().getDuznikNalogodavac());
		nalogZaPlacanje.setHitno(request.getNalogZaPlacanje().isHitno());
		nalogZaPlacanje.setIznos(iznos);
		nalogZaPlacanje.setModelOdobrenja(request.getNalogZaPlacanje().getModelOdobrenja());
		nalogZaPlacanje.setModelZaduzenja(request.getNalogZaPlacanje().getModelZaduzenja());
		nalogZaPlacanje.setOznakaValute(oznakaValute);
		nalogZaPlacanje.setPozivNaBrojOdobrenja(request.getNalogZaPlacanje().getPozivNaBrojOdobrenja());
		nalogZaPlacanje.setPozivNaBrojZaduzenja(request.getNalogZaPlacanje().getPozivNaBrojZaduzenja());
		nalogZaPlacanje.setPrimalacPoverilac(primalac);
		System.out.println("NO");
		nalogZaPlacanje.setSvrhaPlacanja(request.getNalogZaPlacanje().getSvrhaPlacanja());
		
		response.setNalogZaPlacanje(nzps.addNew(nalogZaPlacanje));
		// RTGS
		app.soap.rtgs_mt103.GetNalogResponse rtgsResponse = new app.soap.rtgs_mt103.GetNalogResponse();
		
		
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
		String brojRacunaPoverioca = racunPoverioca;
		System.out.println("NO");
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
		if(iznos.compareTo(bd)==1 || request.getNalogZaPlacanje().isHitno()==true){
			mt103.setIdPoruke((UUID.randomUUID().toString()));
			mt103.setSwiftKodBankeDuznika(swiftKodBankeDuznika);
			mt103.setObracunskiRacunBankeDuznika(obracunskiRacunBankeDuznika);
			mt103.setSwiftKodBankePoverioca(swiftKodBankePoverioca);
			mt103.setObracunskiRacunBankePoverioca(obracunskiRacunBankePoverioca);
			mt103.setDuznikNalogodavac(request.getNalogZaPlacanje().getDuznikNalogodavac());
			mt103.setSvrhaPlacanja(request.getNalogZaPlacanje().getSvrhaPlacanja());
			mt103.setPrimalacPoverilac(primalac);
			mt103.setDatumNaloga(request.getNalogZaPlacanje().getDate());
			mt103.setDatumValute(request.getNalogZaPlacanje().getDate());
			mt103.setBrojRacunaDuznika(request.getNalogZaPlacanje().getBrojRacunaDuznika());
			mt103.setModelZaduzenja(request.getNalogZaPlacanje().getModelZaduzenja());
			mt103.setPozivNaBrojZaduzenja(request.getNalogZaPlacanje().getPozivNaBrojZaduzenja());
			mt103.setBrojRacunaPoverioca(racunPoverioca);
			mt103.setModelOdobrenja(request.getNalogZaPlacanje().getModelOdobrenja());
			mt103.setPozivNaBrojOdobrenja(request.getNalogZaPlacanje().getPozivNaBrojOdobrenja());
			mt103.setIznos(iznos);
			System.out.println("NO");
			mt103.setSifraValute(oznakaValute);
			
			rtgsResponse.setRtgsMt103(rmts.addNew(mt103));
		}else {
			
			
			
			
			
			mt102.setIdPoruke((UUID.randomUUID().toString()));
			mt102.setSwiftKodBankeDuznika(swiftKodBankeDuznika);
			mt102.setObracunskiRacunBankeDuznika(obracunskiRacunBankeDuznika);
			mt102.setSwiftKodBankePoverioca(swiftKodBankePoverioca);
			mt102.setObracunskiRacunBankePoverioca(obracunskiRacunBankePoverioca);
			mt102.setUkupanIznos(iznos);
			mt102.setSifraValute(oznakaValute);
			mt102.setDatumValute(request.getNalogZaPlacanje().getDate());
			mt102.setDatum(request.getNalogZaPlacanje().getDate());
			clearingResponse.setClearingMt102(cmts.addNew(mt102));
			
			pp.setIdNalogaZaPlacanje(request.getNalogZaPlacanje().getIdPoruke());
			pp.setDuznikNalogodavac(request.getNalogZaPlacanje().getDuznikNalogodavac());
			pp.setSvrhaPlacanja(request.getNalogZaPlacanje().getSvrhaPlacanja());
			pp.setPrimalacPoverilac(primalac);
			pp.setDatumNaloga(request.getNalogZaPlacanje().getDate());
			pp.setBrojRacunaDuznika(request.getNalogZaPlacanje().getBrojRacunaDuznika());
			pp.setModelZaduzenja(request.getNalogZaPlacanje().getModelZaduzenja());
			pp.setPozivNaBrojZaduzenja(request.getNalogZaPlacanje().getPozivNaBrojZaduzenja());
			pp.setBrojRacunaPoverioca(racunPoverioca);
			pp.setModelOdobrenja(request.getNalogZaPlacanje().getModelOdobrenja());
			pp.setPozivNaBrojOdobrenja(request.getNalogZaPlacanje().getPozivNaBrojOdobrenja());
			pp.setIznos(iznos);
			pp.setOznakaValute(oznakaValute);
			pp.setMatClearing(mt102);
			
			
			clearingResponse.setPojedinacnoPlacanje(pps.addNew(pp));
			
			
			
			
		}
	  }
		
		
		
		return response;
	}
	
}
