package app.controller;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import app.model.Racuni;
import app.repo.NalogZaPlacanjeRepo;
import app.service.IzvodService;
import app.service.RacuniService;
import app.service.StavkaService;
import app.service.ZaglavljeService;
import app.soap.izvod.CreateIzvodRequest;
import app.soap.izvod.GetIzvodRequest;
import app.soap.izvod.GetIzvodResponse;
import app.soap.izvod.Izvod;
import app.soap.izvod.StavkaPreseka;
import app.soap.izvod.Zaglavlje;
import app.soap.nalog_za_placanje.NalogZaPlacanje;

@Endpoint
public class IzvodEndPoint {
	private static final String NAMESPACE_URI = "soap.app/izvod";
	
	private IzvodService is;
	private StavkaService ss;
	private ZaglavljeService zs;
	private RacuniService rs;
	private NalogZaPlacanjeRepo npr;
	
	@Autowired
	public IzvodEndPoint(IzvodService is, NalogZaPlacanjeRepo npr, StavkaService ss, ZaglavljeService zs, RacuniService rs) {
		super();
		this.is = is;
		this.zs = zs;
		this.ss = ss;
		this.npr = npr;
		this.rs = rs;
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
	public GetIzvodResponse create(@RequestPayload CreateIzvodRequest request) throws ParseException {
		GetIzvodResponse response = new GetIzvodResponse();
		System.out.println("ovde");
		System.out.println("ovde11");
		DateFormat formatter1;
		formatter1 = new SimpleDateFormat("dd-MM-yyyy");
		System.out.println((Date)formatter1.parse(request.getIzvod().getDatum()));
		Date ddate = (Date)formatter1.parse(request.getIzvod().getDatum());
		String account = request.getIzvod().getBrojRacuna();
		int rbpreseka = request.getIzvod().getRedniBrojPreseka();
		Racuni racun = rs.getOneByRacun(account);
		BigDecimal stanje = racun.getStanje_na_racunu();
		List<NalogZaPlacanje> list = new ArrayList<NalogZaPlacanje>();
		for(NalogZaPlacanje np : npr.findAll())
		{
			Date cdate = (Date)formatter1.parse(np.getDate());
			if(cdate.after(ddate)&&
					(account.equals(np.getBrojRacunaDuznika())||
							account.equals(np.getBrojRacunaPoverioca()))) 
			{				
				if(account.equals(np.getBrojRacunaDuznika()))
				{					
					stanje = stanje.add(np.getIznos());
				}
				else if(account.equals(np.getBrojRacunaPoverioca()))
				{
					stanje = stanje.subtract(np.getIznos());
				}
				
			}
			else if (cdate.equals(ddate)&&
					(account.equals(np.getBrojRacunaDuznika())||
							account.equals(np.getBrojRacunaPoverioca())))
			{
				System.out.println("MIS");
				System.out.println(cdate);
				System.out.println(ddate);
				list.add(np);
			}
		}
		//check min and max
		if(rbpreseka*10-10 <= list.size())
		{
			
			if(rbpreseka*10 <= list.size()) 
			{
				System.out.println("NO");
				list = list.subList(rbpreseka*10-10, rbpreseka*10);
				List<NalogZaPlacanje> stanjeList = list.subList(rbpreseka*10, list.size());
				for(NalogZaPlacanje np : stanjeList)
				{
					if(account.equals(np.getBrojRacunaDuznika()))
					{					
						stanje = stanje.add(np.getIznos());
					}
					else if(account.equals(np.getBrojRacunaPoverioca()))
					{
						stanje = stanje.subtract(np.getIznos());
					}
				}
			}
			else 
			{
				System.out.println("NO");
				list = list.subList(rbpreseka*10-10, list.size());
			}
			Izvod izvod = new Izvod();
			izvod.setIdPoruke((UUID.randomUUID().toString()));
			is.addNew(izvod);
			Zaglavlje zaglavlje = new Zaglavlje();
			Set<StavkaPreseka> stavke = new HashSet<StavkaPreseka>();
			StavkaPreseka stavka;
			int puk = 0;
			int pnt = 0;
			BigDecimal uk = BigDecimal.ZERO;
			BigDecimal ut = BigDecimal.ZERO;
			for(NalogZaPlacanje np : list)
			{
				stavka = new StavkaPreseka();
				stavka.setDatumNaloga(np.getDate());
				stavka.setDatumValute(np.getDate());
				stavka.setDuznikNalogodavac(np.getDuznikNalogodavac());
				stavka.setIznos(np.getIznos());
				stavka.setModelduznik(np.getModelZaduzenja());
				stavka.setModelpoverioc(np.getModelOdobrenja());
				stavka.setPnbd(np.getPozivNaBrojZaduzenja());
				stavka.setPnbp(np.getModelOdobrenja());
				stavka.setPrimalacPoverilac(np.getPrimalacPoverilac());
				stavka.setRacunduznik(np.getBrojRacunaDuznika());
				stavka.setRacunpoverioc(np.getBrojRacunaPoverioca());
				System.out.println(stavka.getDatumValute());
				stavka.setSvrhaPlacanja(np.getSvrhaPlacanja());
				stavka.setSmer("smer?");
				stavka.setIdStavke((UUID.randomUUID().toString()));
				stavka.setMaticniIzvod(izvod);
				ss.addNew(stavka);
				stavke.add(stavka);

				if(account.equals(np.getBrojRacunaDuznika()))
				{
					pnt += 1;
					ut = ut.add(np.getIznos());
				}
				else if(account.equals(np.getBrojRacunaPoverioca()))
				{
					puk += 1;
					uk = ut.add(np.getIznos());
				}			
			}

			izvod.setStavke(stavke);
			zaglavlje.setBrojPreseka(rbpreseka);
			zaglavlje.setBrojracuna(account);
			zaglavlje.setDatumNaloga(request.getIzvod().getDatum());
			zaglavlje.setBrojPromenaNaTeret(pnt);
			zaglavlje.setBrojPromenaUKorist(puk);
			zaglavlje.setUkupnoNaTeret(ut);
			System.out.println(zaglavlje.getBrojPromenaNaTeret());
			zaglavlje.setUkupnoUKorist(uk);
			zaglavlje.setNovoStanje(stanje);
			zaglavlje.setIdZaglavlja((UUID.randomUUID().toString()));
			zaglavlje.setPrethodnoStanje(zaglavlje.getNovoStanje().add(ut).subtract(uk));
			zaglavlje.setIzvod(izvod);
			zs.addNew(zaglavlje);
			izvod.setZaglavlje(zaglavlje);


			System.out.println(izvod.toString());
			response.setIzvod(izvod);
		}
		
		return response;
	}

}
