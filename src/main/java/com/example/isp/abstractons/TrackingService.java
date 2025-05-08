package com.example.isp.abstractons;

import com.example.isp.models.TrackingInfo;

public interface TrackingService {
    TrackingInfo trackPackage(String trackingNumber);
}
