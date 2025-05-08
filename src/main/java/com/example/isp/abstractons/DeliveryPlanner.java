package com.example.isp.abstractons;

import com.example.isp.models.Address;
import com.example.isp.models.DeliveryPlan;

public interface DeliveryPlanner {
    DeliveryPlan createPlan(Address address);
}
