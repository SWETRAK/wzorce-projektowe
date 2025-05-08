package com.example.isp.impl;

import com.example.isp.abstractons.PackageShipper;
import com.example.isp.abstractons.TrackingService;
import com.example.isp.models.DeliveryPlan;
import com.example.isp.models.TrackingInfo;


// Tydzień 8, Zasada Segregacji Interfejsów, Kamil Pietrak
// DHLDeliveryService implementujący tylko potrzebne interfejsy.
public class DHLDeliveryService implements PackageShipper, TrackingService {
    public void shipPackage(Package pkg, DeliveryPlan plan) {
        System.out.println("DHL shipping package to: " + plan.getDestination());
    }

    public TrackingInfo trackPackage(String trackingNumber) {
        return new TrackingInfo(trackingNumber, "IN_TRANSIT", "TODAY");
    }
}
//Koniec, Tydzień 8, Zasada Segregacji Interfejsów (ISP) 9