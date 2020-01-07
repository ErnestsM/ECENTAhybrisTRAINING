package de.hybris.training.core.customer;

import de.hybris.platform.commerceservices.customer.DuplicateUidException;
import de.hybris.platform.commerceservices.customer.impl.DefaultCustomerAccountService;
import de.hybris.platform.commerceservices.event.RegisterEvent;
import de.hybris.platform.commerceservices.event.UpdatedProfileEvent;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.training.core.customer.impl.EcentaCustomerAccountService;
import org.apache.commons.lang.StringUtils;


import static de.hybris.platform.servicelayer.util.ServicesUtil.validateParameterNotNullStandardMessage;

public class DefaultEcentaCustomerAccountService extends DefaultCustomerAccountService implements EcentaCustomerAccountService {




    public void updateProfile(final CustomerModel customerModel, final String titleCode, final String name, final String login, final String phoneNumber)
            throws DuplicateUidException
    {
        validateParameterNotNullStandardMessage("customerModel", customerModel);

        customerModel.setUid(login);
        customerModel.setName(name);
        if (StringUtils.isNotBlank(titleCode))
        {
            customerModel.setTitle(getUserService().getTitleForCode(titleCode));
        }
        else
        {
            customerModel.setTitle(null);
        }

        customerModel.setPhoneNumber(phoneNumber);

        internalSaveCustomer(customerModel);

        getEventService().publishEvent(initializeEvent(new UpdatedProfileEvent(), customerModel));
    }


    public void register(final CustomerModel customerModel, final String password) throws DuplicateUidException
    {
        registerCustomer(customerModel, password);
        getEventService().publishEvent(initializeEvent(new RegisterEvent(), customerModel));
    }

}