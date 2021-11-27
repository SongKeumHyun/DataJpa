package com.song.communicatioins;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tibco.tibrv.*;



@Service
public class TibDriver implements TibrvMsgCallback, Runnable  {

	@Autowired
	private final TibConfigration tibConfigration;
	
	private TibrvRvdTransport tibrvRvdTransport;
	
	private TibrvCmTransport tibrvCmTransport;
	
	private TibrvCmListener tibrvCmListener;
	
	private String queueName = "song.queue";
	
	private Thread tibThread;
	
	private Boolean stopDispather = true;


	public TibConfigration getTibConfigration() {
		return tibConfigration;
	}
	
	private TibrvQueue tibrvQueue;
	
	public TibDriver(TibConfigration tibConfigration) {
		super();
		this.tibConfigration = tibConfigration;
		
	}

	
	private Logger logger = LoggerFactory.getLogger(TibDriver.class);

	
	public TibrvQueue getTibrvQueue() {
		return tibrvQueue;
	}
	
	@PostConstruct
	public void postConstruct()
	{
		try 
		{

			if(!Tibrv.isValid())
			Tibrv.open(Tibrv.IMPL_NATIVE);


			this.tibrvQueue = new TibrvQueue();
			
			this.tibrvRvdTransport = new TibrvRvdTransport(tibConfigration.getService(), tibConfigration.getNetwrok(), tibConfigration.getDeamon());
			
			this.tibrvCmTransport = new TibrvCmTransport(this.tibrvRvdTransport , queueName,true);
			
			this.tibrvCmListener = new TibrvCmListener(this.getTibrvQueue(),this,this.tibrvCmTransport,tibConfigration.getReciveSubject(),null);
			
			this.tibrvCmListener.setExplicitConfirm();
	
			this.stopDispather = false;
			
			this.tibThread = new Thread(this);
			
			this.tibThread.run();
			
			logger.info("Tib rv Open Success");
			
		}
		catch (TibrvException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error(e.toString());
		}
		
	}
	
	@PreDestroy
	public void PreDestroy()
	{
		
		this.stopDispather = true;
		
		if(this.tibThread != null)
			this.tibThread =  null;
		
		if(this.tibrvQueue.isValid())
			this.tibrvQueue.destroy();
		
		if(this.tibrvCmTransport.isValid())
			this.tibrvCmTransport.destroy();
		
		if(this.tibrvCmListener.isValid())
			this.tibrvCmListener.destroy();
		
		
		try {
			Tibrv.close();
		} catch (TibrvException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error(e.toString());
		}
		
		
		logger.info("Tib Deriver is Closed");
		
	}





	@Override
	public void onMsg(TibrvListener arg0, TibrvMsg arg1) {
		// TODO Auto-generated method stub
		
		logger.debug("Tib Listen" + arg1.toString());
		
	}

	@Override
	public void run() {
		
		logger.info("Tib Driver is Runn...");
		while(!stopDispather)
		{
			if(this.tibrvQueue.isValid())
			{
				try {
					this.tibrvQueue.dispatch();
				} catch (TibrvException e) {
					// TODO Auto-generated catch block
					logger.error(e.toString());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					logger.error(e.toString());
				}
			}
		
		}
		
		logger.info("Tib Driver is Stop");
	}

		
	
	
}
