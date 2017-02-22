package com.sample;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;


public class ProcessMain {
	
	 public static final void main(String[] args) {
	        try {
	            // load up the knowledge base
	        	 KieServices ks = KieServices.Factory.get();
	             KieContainer kContainer = ks.getKieClasspathContainer();
	             KieSession kSession = kContainer.newKieSession();
	             Account account = new Account();
	             account.setName("gow");
	             kSession.insert(account);
	             kSession.startProcess("demo.test");
	             int fired = kSession.fireAllRules();
	             System.out.println("Number of Rules executed = " + fired);

	            
	        } catch (Throwable t) {
	            t.printStackTrace();
	        }        }

}
