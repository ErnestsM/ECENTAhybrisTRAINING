package de.hybris.training.core.customer.impl;

import de.hybris.platform.commerceservices.customer.CustomerAccountService;
import de.hybris.platform.commerceservices.customer.DuplicateUidException;
import de.hybris.platform.core.model.user.CustomerModel;

public interface EcentaCustomerAccountService extends CustomerAccountService {
    void updateProfile(CustomerModel customerModel, String titleCode, String name, String login, String phoneNumber) throws DuplicateUidException;
    void register(CustomerModel customerModel, String password) throws DuplicateUidException;
}
