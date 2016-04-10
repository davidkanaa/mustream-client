package com.mustream.app.register;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.ISafeRunnable;
import org.eclipse.core.runtime.SafeRunner;
import org.eclipse.e4.core.di.annotations.Execute;
import com.mustream.app.services.AbstractServiceConsumer;
import com.mustream.app.services.ServiceConsumer;

public class EvaluateIntegrationPointHandler {
	
	private static final String INTEGRATION_CONNECTOR_ID = 
		      "com.mustream.integration.services";
	
	@Execute
	  public void execute(IExtensionRegistry registry) {
	    IConfigurationElement[] config =
	        registry.getConfigurationElementsFor(INTEGRATION_CONNECTOR_ID);
	    System.out.println(config.length);
	    try {
	      for (IConfigurationElement e : config) {
	        System.out.println("Evaluating extension");
	        final Object o =
	            e.createExecutableExtension("class");
	        if (o instanceof ServiceConsumer && o instanceof AbstractServiceConsumer) {
	          executeExtension(o);
	        }
	      }
	    } catch (CoreException ex) {
	      System.out.println(ex.getMessage());
	    }
	   
	  }
	
	  private void executeExtension(final Object o) {
	    ISafeRunnable runnable = new ISafeRunnable() {
	      @Override
	      public void handleException(Throwable e) {
	        System.out.println("Exception in client");
	      }

	      @Override
	      public void run() throws Exception {
	        ServiceRegister.getInstance_().loadService(((ServiceConsumer)o));
	      }
	    };
	    SafeRunner.run(runnable);
	  }

}
