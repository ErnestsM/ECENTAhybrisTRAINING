package de.hybris.training.core.customer.impl;
//A little bit in other way - implementation of interface in this package, but interface(this class) in 'de.hybris.training.core.customer'
//Take a look on DefaultSimpleSuggestionFacade.java and file structure of that Facade. Follow that with all interfaces.

import de.hybris.platform.commerceservices.customer.CustomerAccountService;
import de.hybris.platform.commerceservices.customer.DuplicateUidException;
import de.hybris.platform.core.model.user.CustomerModel;

public interface EcentaCustomerAccountService extends CustomerAccountService {
    void updateProfile(CustomerModel customerModel, String titleCode, String name, String login, String phoneNumber) throws DuplicateUidException;
    void register(CustomerModel customerModel, String password) throws DuplicateUidException;
}
