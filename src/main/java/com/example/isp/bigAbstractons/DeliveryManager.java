package com.example.isp.bigAbstractons;

import com.example.isp.models.Address;
import com.example.isp.models.DeliveryPlan;
import com.example.isp.models.TrackingInfo;

// Tydzień 8, Zasada Segregacji Interfejsów, Kamil Pietrak
// DeliveryManager jako przykład "grubego" interfejsu dostaw.
public interface DeliveryManager {
    DeliveryPlan createPlan(Address address);
    void shipPackage(Package pkg, DeliveryPlan plan);
    TrackingInfo trackPackage(String trackingNumber);
    void cancelDelivery(String trackingNumber);
}
//Koniec, Tydzień 8, Zasada Segregacji Interfejsów (ISP) 3