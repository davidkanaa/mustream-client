package com.mustream.app.register;

import java.util.ArrayList;
import java.util.List;

import com.mustream.app.services.ServiceConsumer;

/**
 * Created by davidkanaa on 16-01-29.
 */

/**
 *
 * A service register holds the list of all available services for
 * modules to use.
 *
 */
public class ServiceRegister{

    private List<ServiceConsumer> serviceConsumers;
    private static ServiceRegister instance_;

    private ServiceRegister(){
        serviceConsumers = new ArrayList<ServiceConsumer>();
    }

    /**
     *
     * @return The sole instance of the service register.
     */
    public static ServiceRegister getInstance_(){

        if (instance_ == null){
            instance_ = new ServiceRegister();
        }

        return instance_;
    }

    /**
     *
     * @return The list of available services.
     */
    public List<ServiceConsumer> getServiceConsumers() {
        return serviceConsumers;
    }

    /**
     * Loads a service into the service register.
     * @param s The ServiceConsumer associated with the service provider we want to add.
     */
    public  void loadService(ServiceConsumer s){
        serviceConsumers.add(s);
    }
}

