package com.hyp.crm.workbench.dao;

import com.hyp.crm.workbench.domain.Customer;

public interface CustomerDao {

    Customer getCustomerByName(String company);

    int save(Customer cus);
}
