package com.example.isp.abstractons;

import com.example.isp.models.DeliveryPlan;

public interface PackageShipper {
    void shipPackage(Package pkg, DeliveryPlan plan);
}
